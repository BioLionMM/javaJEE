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
	<p>Il y a <c:out value="${lengthLivres}" /> livres.</p>
	<c:forEach items="${listLivres}" var="livre" >
		<p><c:out value="${livre.titre}" /> de <c:out value="${livre.auteur.prenom}"/>  <c:out value="${livre.auteur.nom}"/></p>
		
		<a href = "<c:url value = "/DetailsLivre"> <c:param name="id" value="${livre.id }" /> </c:url>" >
			<input name="btn" type="submit" value="Details"/>
		</a>
		
		<a href = "<c:url value = "/ModifierLivre"> <c:param name="id" value="${livre.id }" /> </c:url>" >
			<input name="btn" type="submit" value="Modifier"/>
		</a>
		
		
		<a href = "<c:url value = "/SupprimerLivre"> <c:param name="id" value="${livre.id }" /> </c:url>" >
			<input name="btn" type="submit" value="Supprimer"/>
		</a>
		
	</c:forEach>
	
	<a href = "<c:url value = "/AjouterLivre"/>">
			<input name="btn" type="submit" value="AjouterLivre"/>
		</a>
		
</body>
</html>