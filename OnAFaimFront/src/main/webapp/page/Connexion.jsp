<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html lang="fr">
	<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="../style/styleConnexion.css">
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>


<head>
		<meta charset="UTF-8">
		<title>OnAFaim_Connexion</title>
		<link rel="icon" type="image/png" href="image/logo_Onafaim_1.png">
</head>

<body>
	<div id="header" class="row">
    	<div class="col-12">
        	<p id="nomSite">On a faim</p>
   		</div>
   	</div>
<div id="content" class="row">
	<div class="col-12">
		<h1 style:"text-align:center">Connexion</h1>
		<div id="menuConnect">
			<form class="px-4 py-3">
				<div class="form-group">
					<label for="exampleDropdownFormEmail1">Nom</label>
					<input type="email" class="form-control" id="exampleDropdownFormEmail1" placeholder="Saisir votre nom">
				</div>
				<div class="form-group">
					<label for="exampleDropdownFormPassword1">Password</label>
					<input type="password" class="form-control" id="exampleDropdownFormPassword1" placeholder="Saisir votre password">
				</div>
				<div class="form-check">
					<input type="checkbox" class="form-check-input" id="dropdownCheck">
					<label class="form-check-label" for="dropdownCheck">Remember me</label>
				</div>
				<button id="btnSubmit" type="submit" class="btn btn-secondary">Connexion</button>
			</form>
		<div class="dropdown-divider"></div>
			<a class="dropdown-item" href="#">Forgot password?</a>
		</div>
	</div>
</div>

	<div id="footer" class="row">
            <div class="col-12">
                <p style="padding-top:15px" >©️ 2019-2020 Formation AJC Ingenierie - SOPRA</p>
            </div>
    </div>


</body>


</html> 

<script>
menuConnect.style.display="block";
menuConnect.style.margin="auto";
menuConnect.style.maxWidth="30%";

</script>