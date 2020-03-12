package com.ssh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssh.model.administor;
import com.ssh.model.educationTable;

public class administorDao {

	@Autowired
	SessionFactory sessionFactory;
	public administorDao(){
		
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	 public List<administor> getTable(){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from administor";
			 Query query=session.createQuery(hql);
			 List list=query.list();
			 if(list.size()>0){
				 return list;
			 }else{
				 return null;
			 }
		 }catch(Exception e){
			 System.out.println("administor Table Fail");
			 e.printStackTrace();
			 return null;
		 }finally{
			 session.close();
		 }
	 }
}
