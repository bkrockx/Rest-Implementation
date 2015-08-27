<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body bgcolor="#777d6a">
<center>

<h1>Add New Chapter</h1>

<c:url var="Url" value="/chapter/add?id=${bookId}" />

<form:form modelAttribute="chapterAttribute"  method="POST" action="${Url}">
	
	
	<table>
	
		<tr>
			<td>bookId:</td>
			<td><input type="text" value="${bookId}" />
		</tr>
		
		<tr>
			<td><form:label path="chapterId"></form:label></td>
			<td><form:input path="chapterId" type="hidden"/></td>
		</tr>

		<tr>
			<td><form:label path="chapterName">ChapterName:</form:label></td>
			<td><form:input path="chapterName"/></td>
		</tr>
		
	</table>
	
	<input type="submit" value="Save" />
</form:form>

</center>
</body>
</html>