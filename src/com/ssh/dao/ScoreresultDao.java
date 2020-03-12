package com.ssh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssh.model.EduScore;
import com.ssh.model.Scoreresult;
import com.ssh.model.TeacherQS;

public class ScoreresultDao {

	@Autowired
	SessionFactory sessionFactory;
	public ScoreresultDao(){
		
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Scoreresult> getTable(){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from Scoreresult";
			 Query query=session.createQuery(hql);
			 List<Scoreresult> list=query.list();
			 
			 if(list.size()>0){
				 return list;
			 }else{
				 return null;
			 }
			 
		 }catch(Exception e){
			 System.out.println("EduScore Table Fail");
			 e.printStackTrace();
			 return null;
		 }finally{
			 session.close();
		 }
	 }
	
public List<Object[]> queryScore(String hql){
		
		Session session=null;
		try{
			
			session=sessionFactory.openSession();
			//根据id获取要修改的用户数据
			
			
			Query sqlquery = session.createQuery(hql);
			List<Object[]> testList=sqlquery.list();
			 //String list=sqlquery.list().toString();
			//更新数据
			for(Object[] object:testList){
				for(int i=0;i<object.length;i++){
					System.out.println((String)object[i]);
				}
			}
		System.out.println("===============================================");	
		//System.out.println(list);
		System.out.println("===============================================");
		//return list;	
			return testList;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}	
	}

public void updateNoticeID(Scoreresult SS){
	Session session=null;
	Transaction transaction=null;
	try{
		
		session=sessionFactory.openSession();
		//根据id获取要修改的用户数据
		
			transaction=session.beginTransaction();
			
			
			
			session.update(SS);
			transaction.commit();
		
		
		
		
		
		
		
		
	}catch (Exception e) {
		e.printStackTrace();
		
	}finally{//关闭session
		session.close();
	}	
}

public List<Scoreresult> getTableByTID(String TID){
	 Session session=null;
	 try{
		 session=sessionFactory.openSession();
		 String hql="from Scoreresult where TeacherID='"+TID+"'";
		 Query query=session.createQuery(hql);
		
		
		 List<Scoreresult> list=query.list();
		 
		
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
}
