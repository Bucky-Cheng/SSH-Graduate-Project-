package com.ssh.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssh.model.NoticeTable;
import com.ssh.model.ScoreCombination;
import com.ssh.model.TeacherInfo;
import com.ssh.model.educationTable;

public class TeacherMDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public TeacherMDao(){
		
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<TeacherInfo> getTable(String department){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from TeacherInfo where Department='"+department+"'";
			 Query query=session.createQuery(hql);
			
			
			 List<TeacherInfo> list=query.list();
			 
			
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
	
	public List<TeacherInfo> getTableByTID(String TID){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from TeacherInfo where TeacherID='"+TID+"'";
			 Query query=session.createQuery(hql);
			
			
			 List<TeacherInfo> list=query.list();
			 
			
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
	
	public List<TeacherInfo> getTableByPro(String Programme){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from TeacherInfo where Programme='"+Programme+"'";
			 Query query=session.createQuery(hql);
			
			
			 List<TeacherInfo> list=query.list();
			 
			
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
	
	public void updateNoticeID(TeacherInfo TI){
		Session session=null;
		Transaction transaction=null;
		try{
			
			session=sessionFactory.openSession();
			//����id��ȡҪ�޸ĵ��û�����
			
				transaction=session.beginTransaction();
				
				
				
				session.update(TI);
				transaction.commit();
			
			
			
			
			
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally{//�ر�session
			session.close();
		}	
	}
	
	public List<TeacherInfo> getTableByName(String Name){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from TeacherInfo where TeacherName='"+Name+"'";
			 Query query=session.createQuery(hql);
			
			
			 List<TeacherInfo> list=query.list();
			 
			
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
	
	public List<TeacherInfo> getT(){
		 Session session=null;
		 try{
			 session=sessionFactory.openSession();
			 String hql="from TeacherInfo";
			 Query query=session.createQuery(hql);
			
			
			 List<TeacherInfo> list=query.list();
			 
			
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
	
	public void deleteCombinationAById(int ID){
		Session session=null;
		Transaction transaction=null;
		try{
			session=sessionFactory.openSession(); //�õ�session����
			transaction=session.beginTransaction();
			TeacherInfo SC=(TeacherInfo) session.load(TeacherInfo.class,ID);
			session.delete(SC);
			transaction.commit(); //д�����ݿ⣬
		}catch (Exception e) {
			e.printStackTrace();
		}finally{//�ر�session
			session.close();
		}
	}
	
public String queryID(String EShql){
		
		Session session=null;
		try{
			
			session=sessionFactory.openSession();
			//����id��ȡҪ�޸ĵ��û�����
			String hql=EShql;
					
			Query sqlquery = session.createQuery(hql);
			//List<Object[]> testList=sqlquery.list();
			 String list=sqlquery.list().toString();
			//��������
			 System.out.println("SIZE:"+list.length());
		System.out.println("Enter the for"+list);
			//for(Object[] object:testList){
				
				//for(int i=0;i<object.length;i++){
					//System.out.println("data:"+(String)object[i]);
			//	}
			//}
			
		return list;	
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{//�ر�session
			session.close();
		}	
}
public int insertOne(TeacherInfo ET){
	int num=0;
	//�õ�session
	
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
	}finally{//�ر�session
		session.close();
	}
	return num;
}

public boolean updateTeacherInfo(String TIhql){
	Session session=null;
	try{
		
		session=sessionFactory.openSession();
		//����id��ȡҪ�޸ĵ��û�����
		System.out.println("HQL is"+TIhql);
		String hql=TIhql;
				
		Query sqlquery = session.createQuery(hql);
		
		//��������
		
		
		sqlquery.executeUpdate(); 
		return true;
		
	}catch (Exception e) {
		e.printStackTrace();
		return false;
	}finally{//�ر�session
		session.close();
	}	
}

}
