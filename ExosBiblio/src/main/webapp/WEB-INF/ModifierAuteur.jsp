<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier l'auteur</title>
</head>
<body>
	<c:import url = "/WEB-INF/menu.jsp"/>
	<form method="post" action="<c:url value = "/ModifierAuteur"><c:param name="id" value="${auteur.id}"/></c:url>">
	
	  <label for="nom">Nom</label>
	  <input type="text" id="nom" name="nom" value="<c:out value="${auteur.nom}"/>">
	  
	  <label for="prenom">Prenom</label>
	  <input type="text" id="prenom" name="prenom" value="<c:out value="${auteur.prenom}"/>">
	  
	  <label for="telephone">Telephone </label>
	  <input type="text" id="telephone" name="telephone" value="<c:out value="${auteur.telephone}"/>">
	  
	  <label for="email">Email</label>
	  <input type="text" id="email" name="email" value="<c:out value="${auteur.email}"/>">
	  
	   <input type="submit" value="Modifier" /> 
	   <input type="reset" value="reset" />
			
	</form>
</body>
</html>