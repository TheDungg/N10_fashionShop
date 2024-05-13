package vn.devpro.ntd_project.service;


import org.springframework.stereotype.Service;

import vn.devpro.ntd_project.dto.DuntoConstants;
import vn.devpro.ntd_project.model.ContactMod;


@Service
public class ContactService extends BaseService<ContactMod> implements DuntoConstants {

	@Override
	public Class<ContactMod> clazz() {
		// TODO Auto-generated method stub
		return ContactMod.class;
	}
}
