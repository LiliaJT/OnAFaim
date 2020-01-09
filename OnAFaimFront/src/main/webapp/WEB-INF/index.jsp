<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="index.css">
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

	<meta charset="ISO-8859-1">
	<title>OnAFaim</title>
</head>

<body>

	<div id="header" class="row">
		<div class="col-12"></div>
		<p id="nomSite">On A Faim</p>
		<button id="btnConnect" onClick=connect()>Connexion</button>
		<button id="btnCreer" onClick=inscription()>S'inscire</button>
	</div> 

	<div id="content" class="row">
			<div id="menu" class="col-2">
				<ul>
					<li><a href="index.html">Menu</a></li>
					<li><a href="index.html">Carte des sandwichs</a></li>
					<li><a href="index.html">Carte des viennoiseries</a></li>
					<li><a href="index.html">Carte des gâteaux</a></li>
					<li><a href="index.html">Carte des boissons</a></li>	
				</ul>
			</div>
			<div class="col-8">
				<div id="text">
					
				</div>
			</div>
			<div class="col-2"></div>
	</div> 

	<div id="footer" class="row">
		<div class="col-12"></div>
		<p>© 2019-2020 AJC Ingenierie - SOPRA</p>
	</div> 




</body>
</html>


<script>

function connect()
{
}

function inscription()
{
}

</script>