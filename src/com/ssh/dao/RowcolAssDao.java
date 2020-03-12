package com.ssh.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssh.model.assistantTable;
import com.ssh.model.researchTable;
import com.ssh.model.rowcolAss;
import com.ssh.model.rowcolRea;
import com.ssh.model.rowcolSer;
import com.ssh.model.scorecombinationAss;
import com.ssh.model.scorecombinationRea;
import com.ssh.model.scorecombinationSer;
import com.ssh.model.serveTable;

public class RowcolAssDao {



	@Autowired
	SessionFactory sessionFactory;
	
	
	public RowcolAssDao(){
		
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<assistantTable> getTable(){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from assistantTable";
			 Query query=session.createQuery(hql);
			 List<assistantTable> list=query.list();
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
	
	public List<rowcolAss> getCombination(){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from rowcolAss";
			 Query query=session.createQuery(hql);
			 List<rowcolAss> list=query.list();
			 return list;
			 
		 }catch(Exception e){
			 System.out.println("Education Table Fail");
			 e.printStackTrace();
			 return null;
		 }finally{
			 session.close();
		 }
	 }
	
	public List<scorecombinationAss> getCombinationB(){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from scorecombinationAss";
			 Query query=session.createQuery(hql);
			 List<scorecombinationAss> list=query.list();
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
				rowcolAss r1=new rowcolAss();
				
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
				scorecombinationAss SC1=new scorecombinationAss();
				
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
			rowcolAss RC=(rowcolAss) session.load(rowcolAss.class,ID);
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
			scorecombinationAss SC=(scorecombinationAss) session.load(scorecombinationAss.class,ID);
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
				rowcolAss r1=new rowcolAss();
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
				scorecombinationAss SC1=new scorecombinationAss();
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
	public List<rowcolAss> getInculdingByIDA(int ID){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from rowcolAss where ID=? ";
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
	public List<scorecombinationAss> getInculdingByIDB(int ID){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from scorecombinationAss where ID=? ";
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
	public List<assistantTable> getContentByID(String ID){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from assistantTable where name=? ";
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
