package com.ssh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssh.model.EduScore;
import com.ssh.model.ManagerInfo;
import com.ssh.model.TeacherInfo;

public class ManagerInfoDao {

	@Autowired
	SessionFactory sessionFactory;
	public ManagerInfoDao(){
		
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<ManagerInfo> getManager(){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from ManagerInfo";
			 Query query=session.createQuery(hql);
			 List<ManagerInfo> list=query.list();
			 
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
	
	public List<ManagerInfo> getManagerByName(String Name){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from ManagerInfo  where Manager=?";
			 Query query=session.createQuery(hql);
			 query.setParameter(0,Name);
			 List<ManagerInfo> list=query.list();
			 
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
	
	public List<ManagerInfo> getManager(String DepartmentHql){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql=DepartmentHql;
			 Query query=session.createQuery(hql);
			 
			 List<ManagerInfo> list=query.list();
			 
			 if(list.size()>0){
				 return list;
			 }else{
				 return null;
			 }
			 
		 }catch(Exception e){
			 System.out.println("ManagerInfo Table Fail");
			 e.printStackTrace();
			 return null;
		 }finally{
			 session.close();
		 }
	 }
	public int insertOne(ManagerInfo MI){
		int num=0;
		//得到session
		
		Session session=null;
		Transaction transaction=null;
		try{
			
			session=sessionFactory.openSession();
			
			
			
			
				transaction=session.beginTransaction();
				
				
				num=Integer.parseInt(session.save(MI).toString());
				transaction.commit(); 
			
			
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{//关闭session
			session.close();
		}
		return num;
	}
	
	public boolean updateTeacherInfo(String MIhql){
		Session session=null;
		try{
			
			session=sessionFactory.openSession();
			//根据id获取要修改的用户数据
			System.out.println("HQL is"+MIhql);
			String hql=MIhql;
					
			Query sqlquery = session.createQuery(hql);
			
			//更新数据
			
			
			sqlquery.executeUpdate(); 
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{//关闭session
			session.close();
		}	
	}
	
	public void deleteById(int ID){
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession(); //得到session对象
			transaction=session.beginTransaction();
			ManagerInfo SC=(ManagerInfo) session.load(ManagerInfo.class,ID);
			session.delete(SC);
			transaction.commit(); //写入数据库，
		}catch (Exception e) {
			e.printStackTrace();
		}finally{//关闭session
			session.close();
		}
	}
}
