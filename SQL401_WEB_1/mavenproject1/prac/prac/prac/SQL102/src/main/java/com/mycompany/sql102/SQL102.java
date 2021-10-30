package com.mycompany.sql102;

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
public class SQL102 {
String sql="select * from student";
String sqlh="모든 학생을 찾으세요.";
StudentDao sd = new StudentDao();


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
 
    System.out.format(" 학번: 2016214378 이름: 박민우 날짜: 2021.10.07\n");
    System.out.format(" 질의102: "+sqlh+"\n");
    System.out.format(" sql_102: "+sql+"\n");
    System.out.format(" 실행 결과: \n\n");
 
 StudentTitleBean stb = sd.makeStudentTitle(sql);
 printStudentTitle(stb);
 
StudentBean sb=null;
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

StudentBean sb = null;
list = sd.makeListAllStudents(sql);
Iterator it = list.iterator();
    try {
        output = new Formatter("e:/sql_100/sql_101.txt");
        output.format("\n 파일이름: sql-101.txt(font:letter gothic std)\n");
        output.format(" 학번: 1223445 이름: 김동국 날짜: 2021.09.17\n");
        output.format(" 질의101: "+sqlh+"\n");
        output.format(" sql_101: "+sql+"\n");
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
 //학생 자료 입력
 public StudentBean getStudentData(){
 StudentBean sb = new StudentBean();
 Scanner scan = new Scanner(System.in);
 String id;
 int totCred;
    System.out.println("학번: ");
    id = scan.next();
 //System.out.println("입력된 학번: "+id+" "+id.length());
sb.setId(id);
    System.out.println("이름: ");
sb.setName(scan.next());
    System.out.println("학과이름: ");
sb.setDeptName(scan.next());
    System.out.println("학점: ");
sb.setTotCred(scan.nextInt());
return sb;
}
//입력된 값 출력
public void printStudentBean(StudentBean sb){
    System.out.println("입력된 학번: "+sb.getId());
    System.out.println("입력된 이름: "+sb.getName());
    System.out.println("입력된 학과이름: "+sb.getDeptName());
    System.out.println("입력된 학점: "+sb.getTotCred());
 }
// 삽입 절차
public void insertion(){ 
StudentBean sb = getStudentData(); //학생 자료 입력
printStudentBean(sb); //입력된 학생 자료의 표준 출력
printAllStudent(); //삽입 전 학생 관계 내용
int n = sd.insertAStudent(sb); //학생 관계에 삽입
if (n==1) System.out.println("inserted successfully");
else System.out.println("insert failure");
printAllStudent(); //삽입 후 학생 관계 내용
}

 public static void main(String[] args) {
 SQL102 sql_102 = new SQL102();
 //sql_101.printAllStudent();
 //sql_101.writeAllStudent();
sql_102.insertion();
    }
}
