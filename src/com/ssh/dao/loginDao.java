package com.ssh.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssh.action.Login;
import com.ssh.model.Approve;
import com.ssh.model.login;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;


public class loginDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public loginDao(){
		
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public boolean checkpassword(login login){
		Session session=null;
		
		try{
			session=sessionFactory.openSession();
			String hql="from login where t_ID=? and password=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, login.getT_ID());
			query.setParameter(1, login.getPassword());
			List list=query.list();
			if(list.size()>0){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			System.out.println(" login fail");
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
		
	}
	
	public List<login> getTeacher(String T_No){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from login where t_ID=? ";
			Query query=session.createQuery(hql);
			query.setParameter(0, T_No);
			
			List list=query.list();
			return list;
		}catch(Exception e){
			System.out.println(" login fail");
			e.printStackTrace();
			return null;
		}finally{                                         //�ر�session
			session.close();
		}
		
	}
	
	public void updatePassword(login LG){
		Session session=null;
		Transaction transaction=null;
		try{
			
			session=sessionFactory.openSession();
			//����id��ȡҪ�޸ĵ��û�����
			
				transaction=session.beginTransaction();
				session.update(LG);
				transaction.commit();
	
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally{//�ر�session
			session.close();
		}	
	}
}
