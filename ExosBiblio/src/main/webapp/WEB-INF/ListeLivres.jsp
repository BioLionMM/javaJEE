<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="inc/styleGeneral.css">
<head>
<meta charset="ISO-8859-1">
<title>Liste de livres</title>
</head>
<body>
	<c:import url = "/WEB-INF/menu.jsp"/>
	<p>Il y a ${lengthLivres} livres.</p>
	<c:forEach items="${listLivres}" var="livre" >
		<p>${livre.titre } de ${livre.auteur.prenom} ${livre.auteur.nom}</p>
		<c:out value="${param.btn}" />
		<a href="./src/main/java/servlets/SupprimerLivre.java?id="${livre.id}+"">
			<input name="btn" type="submit" value="Supprimer"/>
		</a>
	</c:forEach>
</body>
</html>