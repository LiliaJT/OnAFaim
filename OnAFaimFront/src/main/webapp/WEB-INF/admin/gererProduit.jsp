<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Bienvenue dans la gestion des produits</h1>


	<h2>Liste des produits</h2>
	
	<table border>
		<tr>
			<td>Type</td>
			<td>Prix</td>
			<td>Taille</td>
			<td>Modifier</td>
		</tr>
		
		<c:forEach items="${listP}" var="produit">
			<tr>
				<td>${produit.type}</td>
				<td>${produit.prix}</td>
				<td>${produit.taille}</td>
				<td><a href="">Modifier</a></td>
	
			</tr>
		
		
		</c:forEach>
	</table>
	
	




</body>
</html>