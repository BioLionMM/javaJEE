<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html>
<link rel="stylesheet" href="inc/styleGeneral.css">
<head>
<meta charset="ISO-8859-1">
<title>Details Livre</title>
</head>
<body>
	<c:import url = "/WEB-INF/menu.jsp"/>
	<p>Completez l'url avec "?id=" et l'id du livre cherché.</p>
	<h3>Infos:</h3>
	<p>Titre=<c:out value="${livre.titre}" /> <br/>Auteur: <c:out value="${livre.auteur.prenom }" /> <c:out value="${livre.auteur.nom }" /></p>
	<h4>Details:</h4>
	<p>Categorie: <c:out value="${livre.categorie}" />
	<p>Nombre de pages: <c:out value="${livre.nbPages}" />
</body>
</html>