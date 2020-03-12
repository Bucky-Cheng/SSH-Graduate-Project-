package com.ssh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssh.model.TeacherFile;
import com.ssh.model.educationTable;
import com.ssh.model.rowcol;

public class TeacherFileDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public TeacherFileDao(){
		
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<TeacherFile> getTable(){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from TeacherFile";
			 Query query=session.createQuery(hql);
			 List<TeacherFile> list=query.list();
			
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
	
	public List<TeacherFile> getTableByTID(String TID){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from TeacherFile where TeacherID=?";
			 Query query=session.createQuery(hql);
			 query.setParameter(0,TID);
			 List<TeacherFile> list=query.list();
			
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
	
	public void updateEdu(TeacherFile TF){
		Session session=null;
		Transaction transaction=null;
		try{
			
			session=sessionFactory.openSession();
			
			
				transaction=session.beginTransaction();
				
				
				session.update(TF);
				transaction.commit();
			
			
			
			
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally{//关闭session
			session.close();
		}	
	}
	 public boolean updateEduScore(String EShql){
			Session session=null;
			try{
				
				session=sessionFactory.openSession();
				//根据id获取要修改的用户数据
				System.out.println("HQL is"+EShql);
				String hql=EShql;
						
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
}
