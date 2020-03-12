package com.ssh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssh.model.ChartNum;
import com.ssh.model.ManagerInfo;
import com.ssh.model.rowcol;

public class ChartDao {

	@Autowired
	SessionFactory sessionFactory;
	public ChartDao(){
		
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<ChartNum> getNum(){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from ChartNum";
			 Query query=session.createQuery(hql);
			 List<ChartNum> list=query.list();
			 
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
	
	public void updaterowcol(ChartNum CR){
		Session session=null;
		Transaction transaction=null;
		try{
			
			session=sessionFactory.openSession();
			//根据id获取要修改的用户数据
			
				transaction=session.beginTransaction();
				
				session.update(CR);
				transaction.commit();
			
			
			
			
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally{//关闭session
			session.close();
		}	
	}
}
