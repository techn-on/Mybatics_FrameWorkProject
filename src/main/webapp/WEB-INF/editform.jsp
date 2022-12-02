<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.spring.board.BoardDAO, com.spring.board.BoardVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>

<h1>Edit Form</h1>
<form:form commandName ="boardVO" method="post" action="../editok">
	<form:hidden path="seq">
<table id ="edit">
	<tr><td>Category</td><td><form:input path="category"/> </td></tr>
	<tr><td>Title:</td><td><form :input path ="title"/></td></tr>
<tr><td>Writer:</td><td><form:input path="writer" /></td></tr>
<tr><td>Content:</td><form:textarea cols="50" rows="5" path="content"></form:textarea> </td></tr>
</table>
	<input type ="submit" value="edit"/>
<input type="button" value="Cancel" onclick="history.back()"/></td></tr>
	</form:hidden>
</form:form>

</body>
</html>