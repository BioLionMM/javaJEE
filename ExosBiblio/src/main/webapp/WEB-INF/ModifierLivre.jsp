<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier Livre</title>
</head>
<body>

	<c:import url = "/WEB-INF/menu.jsp"/>
	<form method="post" action="<c:url value = "/ModifierLivre"><c:param name="id" value="${livre.id}"/></c:url>">
	
	  <label for="titre">Titre</label>
	  <input type="text" id="titre" name="titre" value="<c:out value="${livre.titre}"/>">
	  
	  <label for="auteur-select">Auteur:</label>
		<select name="auteurId" id="auteur-select">
		    <option value="">--Choisissez un auteur--</option>
		    <c:forEach items="${listAuteurs}" var="auteur" >
			    <option value=<c:out value="${auteur.id}"/>><c:out value="${auteur.nom}"/> <c:out value="${auteur.prenom }"/></option>
			 </c:forEach>
		</select>
	  
	  <label for="nbPages">Nombre de pages </label>
	  <input type="text" id="nbPages" name="nbPages" value="<c:out value="${livre.nbPages}"/>">
	  
	  <label for="categorie">categorie</label>
	  <input type="text" id="categorie" name="categorie" value="<c:out value="${livre.categorie}"/>">
	  
	   <input type="submit" value="Modifier" /> 
	   <input type="reset" value="reset" />
			
	</form>

</body>
</html>