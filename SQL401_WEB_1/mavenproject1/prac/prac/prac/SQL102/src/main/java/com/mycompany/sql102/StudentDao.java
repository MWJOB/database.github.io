/**
 * @프로그램:StudentDao.java
 * @author:학번:2016214378 이름:박민우
 * @날짜: 2021.10.09
 * 질의401:
 * sql-401:
 */

package com.mycompany.sql102;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    Connection con;
    ResultSet rs;
    PreparedStatement pstmt=null;
    Statement stmt=null;
    String sql;
    DBCon dbc = new DBCon();
 
 // 모든 학생 투플 검색 후 리스트를 만들어서 반환 '18.11.01
 //sql = select * from student;
 public List makeListAllStudents(String sql){
    List list = new ArrayList();
        try {
            rs = dbc.getRS(sql);
            while(rs.next()){
                 StudentBean sb = new StudentBean();
                 sb.setId(rs.getString(1));
                 sb.setName(rs.getString(2));
                 sb.setDeptName(rs.getString(3));
                 sb.setTotCred(rs.getInt(4));
                list.add(sb);
         }
     }catch(SQLException e){
 System.out.println("SQL State: "+e.getSQLState());
    }
    return list;
}
public StudentTitleBean makeStudentTitle(String sql){
    ResultSetMetaData rsmd;
    pstmt = dbc.getPstmt(sql);
    StudentTitleBean stb = new StudentTitleBean();
    try {
        rs = pstmt.executeQuery();
        rsmd = rs.getMetaData();
        stb.setIdTitle(rsmd.getColumnName(1));
        stb.setNameTitle(rsmd.getColumnName(2));
        stb.setDeptNameTitle(rsmd.getColumnName(3));
        stb.setTotCredTitle(rsmd.getColumnName(4));
    }catch(SQLException ex){
        System.out.println("SQL State: "+ex.getSQLState());
        }
    return stb;
    }
    //한 학생 삽입
    public int insertAStudent(StudentBean sb){
int n=0;
String sql="insert into student values(?,?,?,?)";
//System.out.println(sb.getId()+": "+sb.getName());
try {
pstmt = dbc.getPstmt(sql);
pstmt.setString(1, sb.getId());
pstmt.setString(2, sb.getName());
pstmt.setString(3, sb.getDeptName());
pstmt.setInt(4, sb.getTotCred());

n = pstmt.executeUpdate();
} catch (SQLException ex){
System.out.println("SQL insert SQLState: "+ex.getSQLState());
}
return n;
    }
}