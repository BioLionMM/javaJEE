<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<link rel="stylesheet" href="inc/styleGeneral.css">
<head>
<meta charset="ISO-8859-1">
<title>Details Auteur</title>
</head>
<body>
	<c:import url = "/WEB-INF/menu.jsp"/>
	<p>Completez l'url avec "?id=" et l'id de l'auteur cherché.</p>
	<h3>Infos:</h3>
	<p>Nom=<c:out value="${auteur.nom}" /> <c:out value="${auteur.prenom }" /></p>
	<h4>Contact:</h4>
	<p>Email= <c:out value="${auteur.email}" /></p>
	<p>Telephone= <c:out value="${auteur.telephone}" /></p>

</body>
</html>