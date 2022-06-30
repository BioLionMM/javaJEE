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
	<form method="post" action="<c:url value = "/AjouterLivre"/>">
	
	  <label for="titre">Nom </label>
	  <input type="text" id="titre" name="titre">
	  
	  <label for="auteur-select">Auteur:</label>
		<select name="auteurId" id="auteur-select">
		    <option value="">${livre.auteur.nom} ${livre.auteur.prenom}</option>
		    <c:forEach items="${listAuteurs}" var="auteur" >
			    <option value=<c:out value="${auteur.id}"/>><c:out value="${auteur.nom}"/> <c:out value="${auteur.prenom }"/></option>
			 </c:forEach>
		</select>
	  
	  <label for="nbPages">Nombre de pages</label>
	  <input type="text" id="nbPages" name="nbPages">
	  
	  <label for="categorie">Categorie </label>
	  <input type="text" id="categorie" name="categorie">
	  
	   <input type="submit" value="Ajouter" /> 
	   <input type="reset" value="reset" />
			
	</form>
</body>
</html>