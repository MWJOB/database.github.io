package com.mycompany.sql401_web_1;

 import java.io.IOException;
 import java.util.Formatter;
 import java.util.Iterator;
 import java.util.List;
 import java.util.Scanner;
/**
 * @프로그램:StudentDao.java
 * @author:학번:2016214378 이름:박민우
 * @날짜: 2021.10.09
 * 질의: 모든 학생을 찾으세요.
 * sql-401:select*from student;
 */
public class SQL401 {
String sql="select * from student";
String sqlh="모든 학생을 찾으세요.";
 
 StudentDao sd = new StudentDao();
 StudentBean sb = new StudentBean();
 Scanner scan = new Scanner(System.in);
 
 //학생의 모든 속성 이름(제목) 출력
 public void printStudentTitle(StudentTitleBean stb){
 System.out.printf("%10s ", stb.getIdTitle());
 System.out.printf("%-20s", stb.getNameTitle());
 System.out.printf("%-20s", stb.getDeptNameTitle());
 System.out.printf("%10s\n", stb.getTotCredTitle());
 }
 // 표준 출력(화면)
 public void printAllStudent(){
 List<StudentBean> list;
 
 System.out.format(" 학번: 2016214378 이름: 박민우 날짜: 2021.10.04\n");
 System.out.format(" 질의401: "+sqlh+"\n");
 System.out.format(" sql_401: "+sql+"\n");
 System.out.format(" 실행 결과: \n\n");
StudentTitleBean stb = sd.makeStudentTitle(sql);
 printStudentTitle(stb);
 
 list = sd.makeListAllStudents(sql);
 Iterator it = list.iterator();
 
 while(it.hasNext()){
 sb = (StudentBean)it.next();
 System.out.format("%10s ", sb.getId());
 System.out.format("%-20s", sb.getName());
 System.out.format("%-20s", sb.getDeptName());
 System.out.format("%10d", sb.getTotCred());
 System.out.format("\n");
 }
 System.out.println();
 }
 
 //파일 출력
 public void writeAllStudent(){
 Formatter output;
 List<StudentBean> list;
 
 list = sd.makeListAllStudents(sql);
 Iterator it = list.iterator();
 try {
 output = new Formatter("D:\\데이터베이스\\sql_100\\sql_401.txt");
 output.format("\n 파일이름: sql-401.txt(font:letter gothic std)\n");
 output.format(" 학번: 2016214378 이름: 박민우 날짜: 2021.10.17\n");
 output.format(" 질의401: "+sqlh+"\n");
 output.format(" sql_401: "+sql+"\n");
 output.format(" 실행결과: \n\n");
 
 StudentTitleBean stb = sd.makeStudentTitle(sql);
 output.format("%10s ", stb.getIdTitle());
 output.format("%-20s", stb.getNameTitle());
 output.format("%-20s", stb.getDeptNameTitle());
 output.format("%10s\n", stb.getTotCredTitle());
 
 while(it.hasNext()){
    sb = (StudentBean)it.next();
 output.format("%10s ", sb.getId());
 output.format("%-20s", sb.getName());
 output.format("%-20s", sb.getDeptName());
 output.format("%10d", sb.getTotCred());
 output.format("\n");
 }
 output.close();
 System.out.println("\n파일에 쓰기 성공.");
 } catch (IOException e) {
 System.out.println("\n파일에 쓰기 오류.");
 }
 }
 
 public static void main(String[] args) {
 SQL401 sql_401 = new SQL401();
 sql_401.printAllStudent();
 sql_401.writeAllStudent();
    }
}


