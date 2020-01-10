<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="style/index.css">
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

	<meta charset="UTF-8">
	<title>OnAFaim</title>
	<link rel="icon" type="image/png" href="image/logo_Onafaim_1.png">
</head>

<body>

	<img id="logo" src="image/logo_Onafaim_1.png" width="100" height="100"></div>
		
		
		<div id="header" class="row">
			<div class="col-10">
				<p id="nomSite">On a faim</p>
			</div>
				
			<div class="col-2">
				<c:choose>
				<c:when test= "${empty sessionScope.isConnectClient}"> 
					<button id="btnConnect" type="button" class="btn btn-light" onClick="btnConnect()">Connexion</button>
					<button id="btnSignOn" type="button" class="btn btn-light" onClick="btnSignOn()" >Inscription</button>
				</c:when>
				<c:when test= "${sessionScope.isConnectClient=='Y'}"> 
					<div class="btn-group">
  						<button id="btnMonCompte" type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    					Mon Compte
  						</button>
  					<div class="dropdown-menu">
    					<a class="dropdown-item" href="#">Paramètres</a>
    					<a class="dropdown-item" href="#">Mes Commandes</a>
    					<a class="dropdown-item" href="#">Mon Panier</a>
    					<a class="dropdown-item" href="#">Mes Devis</a>
   				 	<div class="dropdown-divider"></div>
    				<a class="dropdown-item" href="#">Deconnexion</a>
  				</div>
				</c:when>
				<c:when test= "${sessionScope.isConnectAdmin=='Y'}"> 
					<button id="btnSignOn" type="button" class="btn btn-light" onClick="btnSignOn()" >Déconnexion</button>
				</c:when>
			</c:choose>
			
			</div>
		</div> 
		
		
		<div id="content" class="row">
			<div id="menu" class="col-2">
					<ul>
						<li><a href="sandwichs.jps">Sandwichs</a></li>
						<li><a href="viennoiseries.jsp">Viennoiseries</a></li>
						<li><a href="gateaux.jsp">Gâteaux</a></li>
						<li><a href="boissons.jsp">Boisson</a></li>
						<li><a href="menu.jsp">Menus</a></li>
						<li><a href="devis.jsp">Devis</a></li>
					</ul>
			</div>
			<div class="col-8">
					<img id="imgIndex" src="image/boulangerie3.jpg" height="500">
			</div>
			<div id="panier" class="col-2">
				<c:choose>
					<c:when test= "${empty sessionScope.isConnect}"></c:when> 
					<c:when test= "${sessionScope.isConnectClient=='Y'}"> 
						<p id="monPanier">Panier</p> <br>
						<table>
							<tr>
								<td>Article</td>
								<td>Qte</td>
							</tr>
							
							<c:forEach items="${ sessionScope.lstProduits }" var="panier">	
								<tr>
									<td>${panier.produit.libelle}</td> 
									<td>${paniert.qte}</td>
									<td><a href="index?supprProd=supprimer&qte=${panier.qte}">X</a></td>
									<td></td> 
								</tr> 
							</c:forEach>
						</table>
						<br>
						
						<table>
							<tr>
									<td>nb Produits</td>
									<td></td> 
								</tr> <br>
								
								<tr>
									<td>Tot. €</td>
									<td></td> 
								</tr>
						</table>
					</c:when>
			</c:choose>
			</div>
		</div> 
		
		
		<div id="footer" class="row">
			<div class="col-12">
				<p style="padding-top:15px" >© 2019-2020 Formation AJC Ingenierie - SOPRA</p>
			</div>
		</div> 




</body>
</html>


<script>

function connect()
{
	location.href="page/connexion.html"
}

function inscription()
{
	location.href="page/inscription.html"
}

</script>