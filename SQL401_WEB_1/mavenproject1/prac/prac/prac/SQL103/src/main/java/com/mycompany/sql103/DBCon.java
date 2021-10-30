/**
 * @프로그램:DBon.java DB연결
 * @author:학번:2016214378 이름:박민우
 * @날짜: 2021.10.09
 * 질의401:
 * sql-401:
 */
package com.mycompany.sql103;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 public class DBCon {
 Connection conn=null;
 Statement stmt=null;
 PreparedStatement pstmt=null;
 ResultSet rs=null;
 String user="c##min", passwd="5425"; //dalma Oracle 서버 id, pw
 String Drv= "oracle.jdbc.OracleDriver";
 String Url= "jdbc:oracle:thin:@localhost:1521:XE";
 //String Drv = "com.mysql.cj.jdbc.Driver";
 //String Url = "jdbc:mysql://localhost:3306/univ";
 //String sql="select * from student";
 
 /**
 * @param 없음. 반환값 Connection 객체
 */
 public Connection getCon(){
 try {
 Class.forName(Drv);
 conn = DriverManager.getConnection(Url, user,passwd);
 // stmt = conn.createStatement();
 // rs = stmt.executeQuery(sql);
 }catch(ClassNotFoundException ex){
 System.out.println("CNF Err1:"+ex.getException());
 }catch(SQLException ex){
    System.out.println("SQL Err2:"+ex.getSQLState());
 }
 return conn;
}
 
 public PreparedStatement getPstmt(String sql){
 try {
 Class.forName(Drv);
 conn = DriverManager.getConnection(Url,user,passwd);
 pstmt = conn.prepareStatement(sql);
 //rs = stmt.executeQuery(sql);
 }catch(ClassNotFoundException ex){
 System.out.println("Err1:"+ex.getException());
 }catch(SQLException ex){
 System.out.println("Err2:"+ex.getErrorCode());
 }
 return pstmt;
 }
 
 public ResultSet getRS(String sql){
 try {
 Class.forName(Drv);
 conn = DriverManager.getConnection(Url,user,passwd);
 stmt = conn.createStatement();
 rs = stmt.executeQuery(sql);
 }catch(ClassNotFoundException ex){
 System.out.println("Err1: CNFE");
 }catch(SQLException ex){
 System.out.println("Err2:"+ex.getSQLState());
 }
 return rs;
 }
 }

