package com.ssh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssh.model.EvaluateNum;
import com.ssh.model.NoticeTable;

public class EvaluateNumDao {

	@Autowired
	SessionFactory sessionFactory;
	public EvaluateNumDao(){
		
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<EvaluateNum> getTable(){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from EvaluateNum";
			 Query query=session.createQuery(hql);
			 List<EvaluateNum> list=query.list();
			 
			 if(list.size()>0){
				 return list;
			 }else{
				 return null;
			 }
			 
		 }catch(Exception e){
			 System.out.println("");
			 e.printStackTrace();
			 return null;
		 }finally{
			 session.close();
		 }
	 }
}
