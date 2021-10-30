<%-- 
    파일이름: sql401.jsp
    Created on : 2021. 10. 10, 오후 11:53:16
    학번: 2016214378 이름: 박민우
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.mycompany.sql401_web_1.*"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>StudentList</h1>
        <UL><li>학번:2016214378 이름: 박민우
        </UL>
        <table border="1">     
           <%
            List<StudentBean>list = new ArrayList();
            String sql="select * from student";
            StudentDao sd = new StudentDao();
            StudentBean sb = null;
            //title
            StudentTitleBean stb2= sd.makeStudentTitle(sql);
            out.print("<tr><td>"+stb2.getIdTitle()+"<td>");
            out.print("<td>"+stb2.getNameTitle()+"<td>");
            out.print("<td>"+stb2.getDeptNameTitle()+"<td>");
            out.print("<td>"+stb2.getTotCredTitle()+"<td><tr>");
            //contents
            list =sd.makeListAllStudents(sql);
            Iterator<StudentBean> it = list.iterator();
            while(it.hasNext()){
                sb = (StudentBean)it.next();
                out.print("<tr><td>"+sb.getId()+"</td>");
                out.print("<td>"+sb.getName()+"</td>");
                out.print("<td>"+sb.getDeptName()+"</td>");
                out.print("<td align='right'>"+sb.getTotCred()+"</td></tr>");
            }
            %>
        </table>
    </body>
</html>
