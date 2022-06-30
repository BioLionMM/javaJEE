<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajout Auteur</title>
</head>
<body>
	<c:import url = "/WEB-INF/menu.jsp"/>
	<form method="post" action="<c:url value = "/AjouterAuteur"/>">
	
	  <label for="nom">Nom </label>
	  <input type="text" id="nom" name="nom">
	  
	  <label for="prenom">Prenom </label>
	  <input type="text" id="prenom" name="prenom">
	  
	  <label for="telephone">Telephone </label>
	  <input type="text" id="telephone" name="telephone">
	  
	  <label for="email">Email </label>
	  <input type="text" id="email" name="email">
	  
	   <input type="submit" value="Ajouter" /> 
	   <input type="reset" value="reset" />
			
	</form>
</body>
</html>