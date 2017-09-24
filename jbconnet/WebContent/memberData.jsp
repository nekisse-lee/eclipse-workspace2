<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%!
   	Connection connection;
    Statement statement;
    ResultSet resultSet;
    
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/member2";
    String uid = "root";
    String upw = "dltjsgh";
    String query = "select * from member2";
   	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
try{
	Class.forName(driver);   // com.mysql.jdbc.Driver
	connection = DriverManager.getConnection(url, uid, upw);  //jdbc:mysql://localhost:3306/member
	statement = connection.createStatement();   
	resultSet = statement.executeQuery(query);//select * from member2
	
	while(resultSet.next()){
		String id = resultSet.getString("id");
		String pw = resultSet.getString("pw");
		String name = resultSet.getString("name");
		String phone = resultSet.getString("phone");
		
		out.println("아이디 : " + 	id + ", 비밀번호 : " + pw + ", 이름 : " + name + ", 전화번호: " + phone+ "<br/> ");
	}
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		if(resultSet != null) resultSet.close();
		if(statement != null) resultSet.close();
		if(connection != null) resultSet.close();
	}catch(Exception e2){
		e2.printStackTrace();
	}
}
%>

</body>
</html>