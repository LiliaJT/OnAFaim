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
			<td>Libellé</td>
			<td>Prix</td>
			<td>Taille</td>
			<td>Type</td>
			<td></td>
		</tr>
		
		<c:forEach items="${listC}" var="produit">
			<tr>
				<td>${produit.libelle}</td>
				<td>${produit.prix}</td>
				<td>${produit.taille}</td>
				<td>${produit.type}</td>
				<td><button onClick="modifierProduit()">Modifier</button></td>
				<td id="lienEnvoyer" style="display:none"><a href="">Envoyer</a></td>
			</tr>
		
		
		</c:forEach>
	</table>
	

</body>
</html>


<script>
	
	function modifierProduit() {
		lienEnvoyer.style.display="inline";
	}

</script>