<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%
String userID=request.getParameter("userID");
String userPassword=request.getParameter("userPassword");

Class.forName("oracle.jdbc.driver.OracleDriver");
Connection myConn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db1813558", "ss2");
Statement stmt = myConn.createStatement();
String mySQL="select s_id from students where s_id='" + userID + "'and s_pwd='" + userPassword + "'";
ResultSet rs = stmt.executeQuery(mySQL);
if(rs.next()){
	session.setAttribute("user", userID);
	response.sendRedirect("main.jsp");
}
else
	response.sendRedirect("login.jsp");
		

stmt.close();
myConn.close();
%>
