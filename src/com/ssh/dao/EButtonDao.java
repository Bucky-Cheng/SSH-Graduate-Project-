package com.ssh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssh.model.EButton;
import com.ssh.model.TeacherInfo;

public class EButtonDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public EButtonDao(){
		
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<EButton> getTable(){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from EButton";
			 Query query=session.createQuery(hql);
			
			
			 List<EButton> list=query.list();
			 
			
			 if(list.size()>0){
				 return list;
			 }else{
				 return null;
			 }
			 
		 }catch(Exception e){
			 System.out.println("Education Table Fail");
			 e.printStackTrace();
			 return null;
		 }finally{
			 session.close();
		 }
	 }
	public void updateE(EButton EB){
		Session session=null;
		Transaction transaction=null;
		try{
			
			session=sessionFactory.openSession();
			//根据id获取要修改的用户数据
			
				transaction=session.beginTransaction();
				
				
				
				session.update(EB);
				transaction.commit();
			
			
			
			
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally{//关闭session
			session.close();
		}	
	}
}
