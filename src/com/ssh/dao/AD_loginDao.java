package com.ssh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Transaction;
import com.ssh.model.AD_login;
import com.ssh.model.login;

public class AD_loginDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public AD_loginDao(){
		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean checkpassword(AD_login login){
		Session session=null;
		try{
			session=sessionFactory.openSession();
			String hql="from AD_login where AD_ID=? and password=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, login.getAD_ID());
			query.setParameter(1, login.getPassword());
			List list=query.list();
			if(list.size()>0){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			System.out.println(" login fail");
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}
		
	}
	
	public int updatepassword(String AD_ID,String oldpwd,String newpwd){
		int flag=0;
		//得到session
		Session session=null;
		Transaction transaction=null;
		session=sessionFactory.openSession();
		try{
			
			//hql语句,Customer代表是models里的实体类,userName和password代表实体类的属性
			String queryString="from AD_login where AD_ID=? and password=?";
			//创建查询
			Query queryObject=session.createQuery(queryString);
			queryObject.setParameter(0, AD_ID);
			queryObject.setParameter(1, oldpwd);
			//执行查询获得的结果,list中的每一个元素代表一个Users的对象
			List<AD_login> list=queryObject.list();
			if(list.size()==0){
				flag=0;//旧密码错误
			}else{
				AD_login admin=list.get(0); //找到要修改密码的用户对象
				admin.setPassword(newpwd);
				transaction=session.beginTransaction();
				session.update(admin);//在缓存中保存数据，受影响行数
				transaction.commit();//写入数据库表
				flag=1;
			}
			return flag;
		}catch (Exception e) {
			e.printStackTrace();
			return 2;
		}finally{
			session.close();
		}
	}
}
