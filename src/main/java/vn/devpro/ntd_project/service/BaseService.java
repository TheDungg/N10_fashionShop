package vn.devpro.ntd_project.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import vn.devpro.ntd_project.model.BaseModel;


@Service
public abstract class BaseService<E extends BaseModel> {

	@PersistenceContext
	EntityManager entityManager;
	
	public abstract Class<E> clazz();
	
	public E getById(int id) {
		return entityManager.find(clazz(), id);
	}
	
	@SuppressWarnings("unchecked")
	public List<E> findAll() {
		Table table = clazz().getAnnotation(Table.class);
		return (List<E>) entityManager.createNativeQuery("SELECT * FROM " + table.name(), clazz()).getResultList();
	}
	
	//thêm mới hoặc sửa 1 bản ghi
	@Transactional
	public E saveOrUpdate(E entity) {
		if (entity.getId() == null || entity.getId() <= 0) { //Add new entity
			entityManager.persist(entity);
			return entity;
		}
		else { //update entity
			return entityManager.merge(entity);
		}
	}
	
	//xóa 1 bản ghi theo entity
	public void delete(E entity) {
		entityManager.remove(entity);
		
	}
	
	public void deleteById(int id) {
		E entity = this.getById(id);
		delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<E> executeNativeSql(String sql) {
		try {
			Query query = entityManager.createNativeQuery(sql, clazz());
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<E>();
		}
	}
	
	// search and paging
	@SuppressWarnings("unchecked")
	public List<E> executeNativeSql(String sql, int currentPage, int sizeOfPage){
		try {
			Query query = entityManager.createNativeQuery(sql, clazz());
			query.setFirstResult((currentPage - 1) * sizeOfPage); //bản ghi đầu trang
			query.setMaxResults(sizeOfPage); //số bản ghi trên 1 trang
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<E>();
		}
	}
	
	//get Entity
		public E getEntityByNativeSQL(String sql) {
			List<E> list = executeNativeSql(sql);
			if(list.size() > 0) {
				return list.get(0);
			}else {
				return null;
			}
		}
}
