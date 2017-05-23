<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="timestamps.models.Entity"%>
<%@ page import="timestamps.dao.impl.EntityDAOImpl"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/resources/style.css"/>"
	type="text/css" media="screen">
</head>
<body>


	<table>
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Address</td>

		</tr>
		<c:forEach var="entity" items="${entList}">

			<tr>
				<td>${entity.getID()}</td>
				<td>${entity.getName()}</td>
				<td>${entity.getAddress()}</td>
				<td><form method="get" action="/timestamps-web-ui/deletesensor">
						<input type="hidden" name="id" value="${entity.getID()}">
						<button type="submit">Удалить устройство</button>
					</form></td>
			</tr>
		</c:forEach>
	</table>

	<form method="get" action="/timestamps-web-ui/addsensor">

		<input type="text" name="name"> <select size="3">
			<c:forEach var="group" items="${groups}">
				<option value="${group.getID()}">${group.getAddress()}</option>
			</c:forEach>
		</select>
		<button type="submit">Добавить устройство</button>
	</form>


</body>
</html>