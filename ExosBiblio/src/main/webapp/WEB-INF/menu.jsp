<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="inc/styleNavBar.css">

<ul>
	<li><a href = "<c:url value = "/"/>">Accueil</a></li>
	<li><a href = "<c:url value = "/ListeAuteurs"/>">Auteurs </a></li>
	<li><a href = "<c:url value = "/DetailsAuteur"/>">DetailsAuteur</a></li>
	<li><a href = "<c:url value = "/ListeLivres"/>">Livres</a></li>
	<li><a href = "<c:url value = "/DetailsLivre"/>">DetailsLivre</a></li>
</ul>