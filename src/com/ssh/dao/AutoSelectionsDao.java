package com.ssh.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AutoSelectionsDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public AutoSelectionsDao(){
		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
public String queryContent(String EShql){
		
		Session session=null;
		try{
			
			session=sessionFactory.openSession();
			//����id��ȡҪ�޸ĵ��û�����
			String hql=EShql;
					
			Query sqlquery = session.createQuery(hql);
			//List<Object[]> testList=sqlquery.list();
			 String list=sqlquery.list().toString();
			//��������
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
		}finally{//�ر�session
			session.close();
		}	
	}
public boolean updateEduSe(String EShql){
	Session session=null;
	try{
		
		session=sessionFactory.openSession();
		//����id��ȡҪ�޸ĵ��û�����
		System.out.println("HQL is"+EShql);
		String hql=EShql;
				
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
