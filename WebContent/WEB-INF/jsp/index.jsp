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
</head>
<body>
	<link rel="stylesheet" href="<c:url value="/resources/style.css"/>"
		type="text/css" media="screen">
	<div class="table_header">
		<div class="table_item">Name</div>
		<div class="table_item">Address</div>
	</div>
	<c:forEach var="entity" items="${entList}">
		<div class="table_row">
			<div class="table_item">${entity.getName()}</div>
			<div class="table_item">${entity.getAddress()}</div>
		</div>
	</c:forEach>

</body>
</html>