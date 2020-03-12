package com.ssh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssh.model.Decline;
import com.ssh.model.NoticeTable;
import com.ssh.model.TeacherInfo;
import com.ssh.model.rowcol;

public class DeclineDao {

	@Autowired
	SessionFactory sessionFactory;
	public DeclineDao(){
		
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Decline> getDecline(){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from Decline";
			 Query query=session.createQuery(hql);
			 List<Decline> list=query.list();
			 
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
	
	public List<Decline> getDeclineByID(int ID){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from Decline where ID=?";
			 Query query=session.createQuery(hql);
			
				 query.setParameter(0,ID);
				
			 List<Decline> list=query.list();
			 
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
	
	public List<Decline> getDeclineByTID(String TID){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from Decline where TeacherID=?";
			 Query query=session.createQuery(hql);
			 query.setParameter(0,TID);
			 List<Decline> list=query.list();
			 
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
	
	public List<Decline> getDeclineByMID(String MID){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from Decline where ManagerID=?";
			 Query query=session.createQuery(hql);
			 query.setParameter(0,MID);
			 List<Decline> list=query.list();
			 
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
	
	public void updateDecline(Decline DC){
		Session session=null;
		Transaction transaction=null;
		try{
			
			session=sessionFactory.openSession();
			//����id��ȡҪ�޸ĵ��û�����
			
				transaction=session.beginTransaction();
				session.update(DC);
				transaction.commit();
	
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally{//�ر�session
			session.close();
		}	
	}
	
	public int insertOne(Decline DC){
		int num=0;
		//�õ�session
		
		Session session=null;
		Transaction transaction=null;
		try{
			
			session=sessionFactory.openSession();
			
			
			
			
				transaction=session.beginTransaction();
				
				
				
				num=Integer.parseInt(session.save(DC).toString());
				transaction.commit(); 
			
			
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{//�ر�session
			session.close();
		}
		return num;
	}
	
	public void deleteDeclineById(int ID){
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession(); //�õ�session����
			transaction=session.beginTransaction();
			Decline SC=(Decline) session.load(Decline.class,ID);
			session.delete(SC);
			transaction.commit(); //д�����ݿ⣬
		}catch (Exception e) {
			e.printStackTrace();
		}finally{//�ر�session
			session.close();
		}
	}
	
	public List<Decline> getDecline(String Type,String TeacherID){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from Decline where DeclineName='"+Type+"' and TeacherID='"+TeacherID+"'";
			 System.out.println(hql);
			 Query query=session.createQuery(hql);
			
				 
			 List<Decline> list=query.list();
			 
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
}
