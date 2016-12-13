package com.directory.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.directory.base.BaseAPIImpl;
import com.directory.dao.RegistrationDAO;
import com.directory.dao.entity.RegisterUserDaoEntity;
import com.directory.user.AppUser;
import com.directory.user.SecurityConfig;
import com.directory.user.User;
import com.sanworks.common.exception.RegistrationException;

public class RegistrationDAOImpl extends BaseAPIImpl  implements RegistrationDAO {


	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public boolean saveAppUser(AppUser appUser) throws Exception {

		return false;
	}



	@Override
	public boolean saveUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changePassword(int appUserId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getSecurityConfiguration(SecurityConfig securityConfig,
			int appUserId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAppUserPresent(int appUserId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean registerNewUser(RegisterUserDaoEntity registerUserDaoEntity)
			throws RegistrationException {

		try{
		Session session = sessionFactory.openSession();
		session.save(registerUserDaoEntity);
		session.close();


		}
		catch(Exception e){
			throw new RegistrationException("Error While registration. Please try after some time");
		}

		return false;
	}

}
