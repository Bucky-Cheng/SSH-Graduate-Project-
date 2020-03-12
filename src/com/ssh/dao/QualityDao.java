package com.ssh.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssh.model.NoticeTable;
import com.ssh.model.Quality;

public class QualityDao {

	@Autowired
	SessionFactory sessionFactory;
	public QualityDao(){
		
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Quality> getQualityByType(String Type){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from Quality where Type=?";
			 Query query=session.createQuery(hql);
			
				 query.setParameter(0,Type);
				
			 List<Quality> list=query.list();
			 
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
	
	
	 public boolean updateQuality(String EShql){
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
	 
	 public List<Quality> queryContent(String EShql){
			
			Session session=null;
			try{
				
				session=sessionFactory.openSession();
				
				String hql=EShql;
						
				Query sqlquery = session.createQuery(hql);
				List<Quality> QL=new ArrayList();
				 QL=sqlquery.list();
				
			
			return QL;	
				
			}catch (Exception e) {
				e.printStackTrace();
				return null;
			}finally{//关闭session
				session.close();
			}	
		}
}
