package com.ssh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssh.model.EduScore;
import com.ssh.model.researchScore;
import com.ssh.model.serveScore;

public class SerScoreDao {



	@Autowired
	SessionFactory sessionFactory;
	public SerScoreDao(){
		
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<serveScore> getEdu(){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from serveTable";
			 Query query=session.createQuery(hql);
			 List<serveScore> list=query.list();
			 
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
	public List<serveScore> getTable(){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from serveScore";
			 Query query=session.createQuery(hql);
			 List<serveScore> list=query.list();
			
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
	public String queryScore(String EShql){
		
		Session session=null;
		try{
			
			session=sessionFactory.openSession();
			//根据id获取要修改的用户数据
			String hql=EShql;
					
			Query sqlquery = session.createQuery(hql);
			//List<Object[]> testList=sqlquery.list();
			 String list=sqlquery.list().toString();
			//更新数据
			//for(Object[] object:testList){
				//for(int i=0;i<object.length;i++){
				//	System.out.println((String)object[i]);
				//}
			//}
		System.out.println("===============================================");	
		System.out.println(list);
		System.out.println("===============================================");
		return list;	
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//关闭session
			session.close();
		}	
	}
public List<Object[]> queryScoreS(String EShql){
		
		Session session=null;
		try{
			
			session=sessionFactory.openSession();
			//根据id获取要修改的用户数据
			String hql=EShql;
					
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
