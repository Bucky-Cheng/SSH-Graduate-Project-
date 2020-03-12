package com.ssh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssh.model.TeacherInfo;
import com.ssh.model.TeacherQS;

public class TeacherQSDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public TeacherQSDao(){
		
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<TeacherQS> getTableByTID(String TID){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from TeacherQS where TeacherID='"+TID+"'";
			 Query query=session.createQuery(hql);
			
			
			 List<TeacherQS> list=query.list();
			 
			
			 if(list.size()>0){
				 return list;
			 }else{
				 return null;
			 }
			 
		 }catch(Exception e){
			 System.out.println("TeacherInfo Table Fail");
			 e.printStackTrace();
			 return null;
		 }finally{
			 session.close();
		 }
	 }
	
	public void updateNoticeID(TeacherQS TQ){
		Session session=null;
		Transaction transaction=null;
		try{
			
			session=sessionFactory.openSession();
			//根据id获取要修改的用户数据
			
				transaction=session.beginTransaction();
				
				
				
				session.update(TQ);
				transaction.commit();
			
			
			
			
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally{//关闭session
			session.close();
		}	
	}
}
