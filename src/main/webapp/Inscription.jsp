<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
    		<div class="col-md-12 "> <h2 id="header_" class="text-center">INSCRIPTION A DES FORMATIONS TROP COOL</h2></div>
    		<hr class="divider"></hr> 		
    	</div>
    	
    	<div class="row">
    		<div class="col-md-12 "><h4 class="text-center">Remplissez le formulaire d'inscription à la formation : </h4></div>
    	</div>
    	
    	<div class="row">
    		<div class="col-md-8">
	    		<form>
	    			
	    		  <div class="form-group">
				    <label for="exampleInputEmail1">Nom</label>
				    <input type="email" class="form-control" id="exampleInputEmail1"  placeholder="Votre nom" required />
				  </div>
				  <div class="form-group">
				    <label for="exampleInputEmail1">Prénom</label>
				    <input type="email" class="form-control" id="exampleInputEmail1"  placeholder="Votre prénom" required />
				  </div>
				  <div class="form-group">
				    <label for="exampleInputEmail1">Adresse</label>
				    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Votre adresses" required />
				  </div>
				  <div class="form-group">
				    <label for="exampleInputEmail1">Téléphone</label>
				    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="N° de Tel" required />
				  </div>
				  <div class="form-group">
				    <label for="exampleInputEmail1">Email</label>
				    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Une adresse email" required />
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
				          Formation sélectionnée
				        </a>
				      </h5>
				    </div>
				
				    <div id="collapseOne" class="collapse show" role="tabpanel" aria-labelledby="headingOne" data-parent="#accordion">
				      <div class="card-body">
				        Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 
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