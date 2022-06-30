<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<link rel="stylesheet" href="inc/styleGeneral.css">
<head>
<meta charset="ISO-8859-1">
<title>Liste auteurs</title>
</head>
<body>
	<c:import url = "/WEB-INF/menu.jsp"/>
    <p>Il y a ${lengthAuteurs} auteurs.</p>
	<c:forEach items="${listAuteurs}" var="auteur" >
		<p>${auteur.nom } ${auteur.prenom }</p>
		<c:out value="${param.btn}" />
		<a href="./src/main/java/servlets/SupprimerAuteur.java?id="+${auteur.id}>
			<input name="btn" type="submit" value="Supprimer"/>
		</a>
		
        <br />
	</c:forEach>
</body>
</html>