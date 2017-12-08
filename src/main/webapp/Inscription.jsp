<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'un client</title>
        
        <!--  <link href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet" />-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    	<link type="text/css" rel="stylesheet" href="inc/style.css" />
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    </head>
    <body>
       
    <div class="container">
    	<!-- Page header -->
    	<div class="row">
    		<div class="col-md-12 "> <h2 id="header_" class="text-center" style="color:red">INSCRIPTION A DES FORMATIONS TROP COOL</h2></div>
    		<hr class="divider"></hr> 		
    	</div>
    	
    	<div class="row">
    		<div class="col-md-12 "><h4 class="text-center">Remplissez le formulaire d'inscription à la formation : </h4></div>
    	</div>
    	
    	<div class="row">
    		<div class="col-md-8">
	    		<form action="http://localhost:8080/jasper/home?couseSessionId=<c:out value="${courseSession.id}" />" method="post">	    
	    		  <div class="form-group">
				    <label for="lastName">Nom</label>
				    <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Votre nom" required />
				  </div>
				  <div class="form-group">
				    <label for="firstName">Prénom</label>
				    <input type="text" class="form-control" id="firstName" name="firstName"  placeholder="Votre prénom" required />
				  </div>
				  <div class="form-group">
				    <label for="address">Adresse</label>
				    <input type="text" class="form-control" id="address" name="address" placeholder="Votre adresses" required />
				  </div>
				  <div class="form-group">
				    <label for="phone">Téléphone</label>
				    <input type="text" class="form-control" id="phone" name="phone" placeholder="N° de Tel" required />
				  </div>
				  <div class="form-group">
				    <label for="email">Email</label>
				    <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="Une adresse email" required />
				    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
				  </div>
				  <input type="submit" class="btn btn-primary" value="Valider mon inscription" />
				</form>
    		</div>
    		<div class="col-md-4">
    			<div id="accordion" role="tablist">
				  <div class="card">
				    <div class="card-header" role="tab" id="headingOne">
				      <h5 class="mb-0">
				        <a data-toggle="collapse" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
				          Formation sélectionnée : <c:out value="${courseSession.course.code}" />
				        </a>
				      </h5>
				    </div>
				
				    <div id="collapseOne" class="collapse show" role="tabpanel" aria-labelledby="headingOne" data-parent="#accordion">
				      <div class="card-body">
				        Titre : <c:out value="${courseSession.course.title}" /><br/>
				        Date : <fmt:formatDate pattern = "dd-MM-yyyy H:m" value = "${courseSession.startDate}" /><br/>
				        Lieu :  <c:out value="${courseSession.location.city}" />
				      </div>
				    </div>
				  </div>
				
				</div>
    		</div>

    	</div>
    		
      <footer class="footer">
        <!--  <p>&copy; </p> -->
      </footer>
    </div>
        
        
        
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
    </body>
</html>