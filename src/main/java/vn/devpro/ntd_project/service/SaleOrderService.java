package vn.devpro.ntd_project.service;

import org.springframework.stereotype.Service;

import vn.devpro.ntd_project.model.SaleOrder;


@Service
public class SaleOrderService extends BaseService<SaleOrder>{
	@Override
	public Class<SaleOrder> clazz() {
		// TODO Auto-generated method stub
		return SaleOrder.class;
	}
}
