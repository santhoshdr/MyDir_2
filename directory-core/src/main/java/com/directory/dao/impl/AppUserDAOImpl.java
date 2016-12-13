package com.directory.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.directory.dao.AppUserDAO;
import com.directory.dao.entity.RegisterUserDaoEntity;
import com.directory.user.AppUser;
import com.directory.user.User;
import com.sanworks.common.exception.FaultCode;
import com.sanworks.common.exception.LoginException;

public class AppUserDAOImpl implements AppUserDAO {

	private SessionFactory sessionFactory;

	@Override
	public List<AppUser> getAllAppUsers() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppUser getAppUserById(int appuserId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppUser AppUserWithHisUsers(int appuserId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(int userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsersForAppUser(int appuserId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppUser valudateLoginUser(AppUser appUser) throws Exception {
		// Validates User Name and Password.

		Session session = null;

		try{
			String emailId =appUser.getUserEmailId();
			session = getSessionFactory().openSession();
			session.beginTransaction();
			Query query =  session.createQuery("From com.directory.dao.entity.RegisterUserDaoEntity where firstName=:emailId");
			query.setParameter("emailId",emailId);
			//Query query = session.createQuery("from Member");
		//	query.setString("username", appUser.getUserEmailId());
			List<RegisterUserDaoEntity> results = (List<RegisterUserDaoEntity>)query.list();

			if(results.size() > 1){
					System.out.println("User Exsits...... Check password now...");
					if(results.get(1) instanceof RegisterUserDaoEntity){
						RegisterUserDaoEntity register =results.get(1);

						if(register.getLastName().equalsIgnoreCase(appUser.getUserPassword())){

							appUser.setUserFirstName(register.getFirstName());
							appUser.setUserLastName(register.getLastName());
							appUser.setLocation(register.getCity());
							appUser.setUserId(register.getId());

							appUser.setSex(register.getSex());
							appUser.setAge(register.getAge());
							appUser.setDob(register.getDob());
							appUser.setMobileNumber(register.getMobile());
							System.out.println("Success Full Login ....");
						}else{

							throw new LoginException(new FaultCode("123"));
						}


						System.out.println("User DOESNT Exsits... Should thows exception....");
					}
				}else{
					System.out.println("User DOESNT Exsits... Should thows exception....");
					throw new LoginException(new FaultCode("123"));

				}

			}catch(Exception e){
				throw e;

			}finally{
				session.close();
			}
		return appUser;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
