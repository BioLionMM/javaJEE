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
    <p>Il y a <c:out value="${lengthAuteurs}" /> auteurs.</p>
	<c:forEach items="${listAuteurs}" var="auteur" >
		<p><c:out value="${auteur.nom }" /> <c:out value="${auteur.prenom}"/></p>
		
		<a href = "<c:url value = "/DetailsAuteur"> <c:param name="id" value="${auteur.id }" /> </c:url>" >
			<input name="btn" type="submit" value="Details"/>
		</a>
		
		<a href = "<c:url value = "/ModifierAuteur"> <c:param name="id" value="${auteur.id }" /> </c:url>" >
			<input name="btn" type="submit" value="Modifier"/>
		</a>
		
		<a href = "<c:url value = "/SupprimerAuteur"> <c:param name="id" value="${auteur.id }" /> </c:url>" >
			<input name="btn" type="submit" value="Supprimer"/>
		</a>
		
        <br />
	</c:forEach>
	
	<a href = "<c:url value = "/AjouterAuteur"/>">
			<input name="btn" type="submit" value="AjouterAuteur"/>
		</a>
</body>
</html>