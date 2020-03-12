package com.ssh.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssh.model.AD_login;
import com.ssh.model.ScoreCombination;
import com.ssh.model.educationTable;
import com.ssh.model.rowcol;

public class RowcolDao {

	@Autowired
	SessionFactory sessionFactory;
	
	
	public RowcolDao(){
		
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<educationTable> getTable(){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from educationTable";
			 Query query=session.createQuery(hql);
			 List<educationTable> list=query.list();
			 List eduList=new ArrayList();
			for(int i=0;i<list.size();i++){
				eduList.add(list.get(i).getName());
			}
			 if(eduList.size()>0){
				 return eduList;
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
	
	public List<rowcol> getCombination(){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from rowcol";
			 Query query=session.createQuery(hql);
			 List<rowcol> list=query.list();
			 return list;
			 
		 }catch(Exception e){
			 System.out.println("Education Table Fail");
			 e.printStackTrace();
			 return null;
		 }finally{
			 session.close();
		 }
	 }
	
	public List<ScoreCombination> getCombinationB(){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from ScoreCombination";
			 Query query=session.createQuery(hql);
			 List<ScoreCombination> list=query.list();
			 return list;
			 
		 }catch(Exception e){
			 System.out.println("Education Table Fail");
			 e.printStackTrace();
			 return null;
		 }finally{
			 session.close();
		 }
	 }
	
	
	public int insertOne(List AddCombination){
		int num=0;
		//得到session
		for(int i=0;i<AddCombination.size();i++){
			System.out.println("DAO"+AddCombination.get(i));
		}
		Session session=null;
		Transaction transaction=null;
		try{
			
			session=sessionFactory.openSession();
			
			
			
			for(int i=0;i<AddCombination.size();i=i+2){
				transaction=session.beginTransaction();
				System.out.println(AddCombination.get(i).toString()+AddCombination.get(i+1).toString());
				rowcol r1=new rowcol();
				
				r1.setIncluding(AddCombination.get(i+1).toString());
				num=Integer.parseInt(session.save(r1).toString());
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
	
	public int insertOneB(List AddCombination){
		int num=0;
		//得到session
		for(int i=0;i<AddCombination.size();i++){
			System.out.println("DAO"+AddCombination.get(i));
		}
		Session session=null;
		Transaction transaction=null;
		try{
			
			session=sessionFactory.openSession();
			
			
			
			for(int i=0;i<AddCombination.size();i=i+2){
				transaction=session.beginTransaction();
				System.out.println(AddCombination.get(i).toString()+AddCombination.get(i+1).toString());
				ScoreCombination SC1=new ScoreCombination();
				
				SC1.setIncluding(AddCombination.get(i+1).toString());
				num=Integer.parseInt(session.save(SC1).toString());
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
	
	public void deleteCombinationById(int ID){
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession(); //得到session对象
			transaction=session.beginTransaction();
			rowcol RC=(rowcol) session.load(rowcol.class,ID);
			session.delete(RC);
			transaction.commit(); //写入数据库，
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
			ScoreCombination SC=(ScoreCombination) session.load(ScoreCombination.class,ID);
			session.delete(SC);
			transaction.commit(); //写入数据库，
		}catch (Exception e) {
			e.printStackTrace();
		}finally{//关闭session
			session.close();
		}
	}
	
	public void updaterowcol(List saveList){
		Session session=null;
		Transaction transaction=null;
		try{
			
			session=sessionFactory.openSession();
			
			for(int i=0;i<saveList.size();i=i+2){
				transaction=session.beginTransaction();
				rowcol r1=new rowcol();
				r1.setID(Integer.parseInt((String) saveList.get(i)));
				r1.setIncluding((String) saveList.get(i+1));
				session.update(r1);
				transaction.commit();
			
			
			
			
			
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally{//关闭session
			session.close();
		}	
	}
	public void updaterowcolB(List saveList){
		Session session=null;
		Transaction transaction=null;
		try{
			
			session=sessionFactory.openSession();
			//根据id获取要修改的用户数据
			for(int i=0;i<saveList.size();i=i+2){
				transaction=session.beginTransaction();
				ScoreCombination SC1=new ScoreCombination();
				SC1.setID(Integer.parseInt((String) saveList.get(i)));
				SC1.setIncluding((String) saveList.get(i+1));
				session.update(SC1);
				transaction.commit();
			
			
			
			
			
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally{//关闭session
			session.close();
		}	
	}
	public List<rowcol> getInculdingByIDA(int ID){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from rowcol where ID=? ";
			Query query=session.createQuery(hql);
			query.setParameter(0, ID);
			
			List list=query.list();
			if(list.size()>0){
				return list;
			}else{
				return null;
			}
		}catch(Exception e){
			System.out.println(" login fail");
			e.printStackTrace();
			return null;
		}finally{                                         //关闭session
			session.close();
		}
		
	}
	public List<ScoreCombination> getInculdingByIDB(int ID){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from ScoreCombination where ID=? ";
			Query query=session.createQuery(hql);
			query.setParameter(0, ID);
			
			List list=query.list();
			if(list.size()>0){
				return list;
			}else{
				return null;
			}
		}catch(Exception e){
			System.out.println(" login fail");
			e.printStackTrace();
			return null;
		}finally{                                         //关闭session
			session.close();
		}
		
	}
	public List<educationTable> getContentByID(String ID){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from educationTable where name=? ";
			Query query=session.createQuery(hql);
			query.setParameter(0, ID);
			
			List list=query.list();
			if(list.size()>0){
				return list;
			}else{
				return null;
			}
		}catch(Exception e){
			System.out.println(" login fail");
			e.printStackTrace();
			return null;
		}finally{                                         //关闭session
			session.close();
		}
		
	}
}
