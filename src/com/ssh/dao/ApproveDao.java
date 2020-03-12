package com.ssh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssh.model.Approve;
import com.ssh.model.Decline;

public class ApproveDao {
	
	@Autowired
	SessionFactory sessionFactory;
	public ApproveDao(){
		
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Approve> getApprove(){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from Approve";
			 Query query=session.createQuery(hql);
			 List<Approve> list=query.list();
			 
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
	
	public List<Approve> getApproveByTID(String TID){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from Approve where TeacherID=?";
			 Query query=session.createQuery(hql);
			 query.setParameter(0,TID);
			 List<Approve> list=query.list();
			 
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
	
	public List<Approve> getApproveByMID(String MID){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from Approve where ManagerID=?";
			 Query query=session.createQuery(hql);
			 query.setParameter(0,MID);
			 List<Approve> list=query.list();
			 
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
	
	public void updateDecline(Approve AP){
		Session session=null;
		Transaction transaction=null;
		try{
			
			session=sessionFactory.openSession();
			//根据id获取要修改的用户数据
			
				transaction=session.beginTransaction();
				session.update(AP);
				transaction.commit();
	
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally{//关闭session
			session.close();
		}	
	}
	
	public int insertOne(Approve AP){
		int num=0;
		//得到session
		
		Session session=null;
		Transaction transaction=null;
		try{
			
			session=sessionFactory.openSession();
			
			
			
			
				transaction=session.beginTransaction();
				
				
				
				num=Integer.parseInt(session.save(AP).toString());
				transaction.commit(); 
			
			
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{//关闭session
			session.close();
		}
		return num;
	}
	
	public void deleteApproveAById(Approve AP){
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession(); //得到session对象
			transaction=session.beginTransaction();
			
			session.delete(AP);
			transaction.commit(); //写入数据库，
		}catch (Exception e) {
			e.printStackTrace();
		}finally{//关闭session
			session.close();
		}
	}
}
