package com.DBHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class DBHelper {

	static final String url="jdbc:mysql://localhost:3306/evaluation _s?characterEncoding=utf-8";
	static final String name="com.mysql.jdbc.Driver";
	static final String user="root";
	static final String password="zbj088097";
	public static Connection conn=null;
	
	
	public static Connection DBconn(){
		try{
			Class.forName(name);
			conn=DriverManager.getConnection(url,user,password);
			System.out.println("aaa");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	//姓名搜索
	public static List<String> queryTeacherByName(String name){
		try{
			List<String> list=new ArrayList<String>();
			String sql="select * from teacherinfo where TeacherName LIKE '%"+name+"%'";
			Connection conn1=DBconn();
			Statement stmt=conn1.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				
				list.add(rs.getString(2));
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			
			return null;
		}
	}
	//工号搜索
	public static List<String> queryTeacherByID(String ID){
		try{
			List<String> list=new ArrayList<String>();
			String sql="select * from teacherinfo where TeacherID LIKE '%"+ID+"%'";
			Connection conn1=DBconn();
			Statement stmt=conn1.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				
				list.add(rs.getString(2));
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			
			return null;
		}
	}
	//类别查询
	public static List<String> queryTeacherByDepartment(String Department){
		try{
			List<String> list=new ArrayList<String>();
			String sql="select * from teacherinfo where Department LIKE '%"+Department+"%'";
			Connection conn1=DBconn();
			Statement stmt=conn1.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				
				list.add(rs.getString(2));
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			
			return null;
		}
	}
	//部门查询
	public static List<String> queryTeacherByProgramme(String Programme){
		try{
			List<String> list=new ArrayList<String>();
			String sql="select * from teacherinfo where Programme LIKE '%"+Programme+"%'";
			Connection conn1=DBconn();
			Statement stmt=conn1.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				
				list.add(rs.getString(2));
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			
			return null;
		}
	}
}
