package com.ssh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssh.model.educationTable;
import com.ssh.model.researchTable;
import com.ssh.model.scorecombinationRea;

public class researchTableDao {



	@Autowired
	SessionFactory sessionFactory;
	
	public researchTableDao(){
		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	 public List<researchTable> getTable(){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from researchTable";
			 Query query=session.createQuery(hql);
			 List<researchTable> list=query.list();
			 System.out.println(list.get(0).getName());
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
	 
	 public List<researchTable> getTableByName(String Name){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from researchTable where name='"+Name+"'";
			 Query query=session.createQuery(hql);
			 List<researchTable> list=query.list();
			 System.out.println(list.get(0).getName());
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
				
				 String list=sqlquery.list().toString();
				//更新数据
				
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
	 public boolean updateEduTable(String name,String content){
			Session session=null;
			try{
				
				session=sessionFactory.openSession();
				//根据id获取要修改的用户数据
				String hql=("update researchTable e set e.content=? where name =?");  
				Query sqlquery = session.createQuery(hql);
				
				//更新数据
				sqlquery.setParameter(0, content);
				sqlquery.setParameter(1, name);
				
				sqlquery.executeUpdate(); 
				return true;
				
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}finally{//关闭session
				session.close();
			}	
		}
	 public boolean updateEduScore(String name,String Score){
			Session session=null;
			try{
				
				session=sessionFactory.openSession();
				//根据id获取要修改的用户数据
				String hql=("update researchTable e set e.score=? where name =?");  
				Query sqlquery = session.createQuery(hql);
				
				//更新数据
				sqlquery.setParameter(0, Score);
				sqlquery.setParameter(1, name);
				
				sqlquery.executeUpdate(); 
				return true;
				
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}finally{//关闭session
				session.close();
			}	
		}
	 public boolean updateEduScoreA(String name,String Score){
			Session session=null;
			try{
				
				session=sessionFactory.openSession();
				//根据id获取要修改的用户数据
				String hql=("update researchTable e set e.AllScore=? where name =?");  
				Query sqlquery = session.createQuery(hql);
				
				//更新数据
				sqlquery.setParameter(0, Score);
				sqlquery.setParameter(1, name);
				
				sqlquery.executeUpdate(); 
				return true;
				
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}finally{//关闭session
				session.close();
			}	
		}
		public int insertOneB(List<researchTable> AddCombination){
			int num=0;
			//得到session
			
			Session session=null;
			Transaction transaction=null;
			try{
				
				session=sessionFactory.openSession();
				
				
				
				for(int i=0;i<AddCombination.size();i++){
					transaction=session.beginTransaction();
					
					
					num=Integer.parseInt(session.save(AddCombination.get(i)).toString());
					transaction.commit(); 
				}
				
				
				
				
				
			}catch (Exception e) {
				e.printStackTrace();
				num=0;
			}finally{//关闭session
				session.close();
			}
			return num;
		}
		public int insertOne(researchTable ET){
			int num=0;
			//得到session
			
			Session session=null;
			Transaction transaction=null;
			try{
				
				session=sessionFactory.openSession();
				
				
				
				
					transaction=session.beginTransaction();
					
					
					num=Integer.parseInt(session.save(ET).toString());
					transaction.commit(); 
				
				
				
				
				
				
			}catch (Exception e) {
				e.printStackTrace();
				num=0;
			}finally{//关闭session
				session.close();
			}
			return num;
		}
		public void deleteContent(String name){
			Session session=null;
			try{
				
				session=sessionFactory.openSession();
				
				
				Transaction trans=session.beginTransaction();
				
				String hql="delete from researchTable e where e.name=?";

				Query sqlquery=session.createQuery(hql);
				sqlquery.setParameter(0, name);
				int ret=sqlquery.executeUpdate();

				trans.commit();
				System.out.println("delete complete");
				
				
			}catch (Exception e) {
				e.printStackTrace();
				
			}finally{//关闭session
				session.close();
			}	
		}
		
		public void deleteCombinationAById(int ID){
			Session session=null;
			Transaction transaction=null;
			try{
				session=sessionFactory.openSession(); //得到session对象
				transaction=session.beginTransaction();
				researchTable SC=(researchTable) session.load(researchTable.class,ID);
				session.delete(SC);
				transaction.commit(); //写入数据库，
			}catch (Exception e) {
				e.printStackTrace();
			}finally{//关闭session
				session.close();
			}
		}

}
