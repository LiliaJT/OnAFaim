<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Bienvenue dans la gestion des clients</h1>

	
	<h2>Liste des clients</h2>
	
	<table border>
		<tr>
			<td>Id</td>
			<td>Nom</td>
			<td>Email</td>
			<td>Etat du compte</td>
			<td>Check</td>
			<td>Pas Check</td>
		</tr>
		
		<c:forEach items="${listC}" var="compte">
			<tr>
				<td>${compte.idCompte}</td>
				<td>${compte.nom}</td>
				<td>${compte.email}</td>
				<td>${compte.compteEtat}</td>
				<td><a href="gererClient?validation=valided&id=${compte.idCompte}" id="lienValided">Check</a></td>
				<td><a href="gererClient?validation=notvalided&id=${compte.idCompte}" id="lienNotValided">Supprimer</a></td>
			</tr>
		
		
		</c:forEach>
	</table>
	
	




</body>
</html>
