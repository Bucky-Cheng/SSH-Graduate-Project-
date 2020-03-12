package com.ssh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssh.model.ManagerInfo;
import com.ssh.model.NoticeTable;
import com.ssh.model.ScoreCombination;
import com.ssh.model.TeacherInfo;

public class NoticeTableDao {

	@Autowired
	SessionFactory sessionFactory;
	public NoticeTableDao(){
		
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<NoticeTable> getNotice(){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from NoticeTable";
			 Query query=session.createQuery(hql);
			 List<NoticeTable> list=query.list();
			 
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
	
	public List<NoticeTable> getTeacherNotice(String Type){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from NoticeTable where Type=? or Type='全体教职工'";
			 Query query=session.createQuery(hql);
			
				 query.setParameter(0,Type);
				
			 List<NoticeTable> list=query.list();
			 
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
	
	public List<NoticeTable> getTeacherNoticeByID(int ID){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from NoticeTable where ID=?";
			 Query query=session.createQuery(hql);
			
				 query.setParameter(0,ID);
				
			 List<NoticeTable> list=query.list();
			 
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
	
	
	
	public void updateNoticeID(NoticeTable NT){
		Session session=null;
		Transaction transaction=null;
		try{
			
			session=sessionFactory.openSession();
			//����id��ȡҪ�޸ĵ��û�����
			
				transaction=session.beginTransaction();
				session.update(NT);
				transaction.commit();
	
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally{//�ر�session
			session.close();
		}	
	}
	
	
	
	public int insertOne(NoticeTable NT){
		int num=0;
		//�õ�session
		
		Session session=null;
		Transaction transaction=null;
		try{
			
			session=sessionFactory.openSession();
			
			
			
			
				transaction=session.beginTransaction();
				
				
				num=Integer.parseInt(session.save(NT).toString());
				transaction.commit(); 
			
			
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			num=0;
		}finally{//�ر�session
			session.close();
		}
		return num;
	}
	
	public void deleteNoticeById(int ID){
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession(); //�õ�session����
			transaction=session.beginTransaction();
			NoticeTable SC=(NoticeTable) session.load(NoticeTable.class,ID);
			session.delete(SC);
			transaction.commit(); //д�����ݿ⣬
		}catch (Exception e) {
			e.printStackTrace();
		}finally{//�ر�session
			session.close();
		}
	}
}
