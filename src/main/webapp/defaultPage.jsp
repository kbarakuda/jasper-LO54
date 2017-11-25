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
    		<div class="col-md-12 "><h4 class="text-center"> Bienvenue sur notre site d'inscription aux formations en lignes </h4></div>
    	</div>
    	
    	<div class="row">
    		<div class="col-md-12 "><h5>Liste des formations :</h5></div>
    	</div>
    	
    	<div class="row">
    	 <div class="col-lg-6">
		    <div class="input-group">
		      <input type="text" class="form-control" placeholder="Search for...">
		      <span class="input-group-btn">
		        <button class="btn btn-default" type="button">Go!</button>
		      </span>
		    </div>
		  </div>
		  
		  <div class="col-lg-4">
		  	<div class="dropdown">
			  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
			    Lieu de formation
			    <span class="caret"></span>
			  </button>
			  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
			    <li><a href="#">Action</a></li>
			    <li><a href="#">Another action</a></li>
			    <li><a href="#">Something else here</a></li>
			  </ul>
			</div>
		  </div>
    	</div>
    	
    	<div id="listeFormation" class="row">
    		<table class="table table-hover">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">Nom de la formation</th>
			      <th scope="col">Date de session</th>
			      <th scope="col">Lieu de formation</th>
			      <th scope="col">Liste des inscrits</th>
			    </tr>
			  </thead>
			  <tbody>
		  	<%
		  		for(int i=0;i<5;i++){
		  	%>
			    <tr>
			      <td scope="row"><input name="formation" type="radio" /></td>
			      <td scope="row">LO54</td>
			      <td>24-11-2017</td>
			      <td>Otto</td>
			      <td><img class="icon-pdf" alt="icon-pdf" src="https://cdn4.iconfinder.com/data/icons/small-n-flat/24/file-pdf-128.png"> <a href="#"> To PDF</a></td>
			    </tr>
		    <% } %>
			  </tbody>
			</table>
			
			
    	</div>
    	
    	<div class="row"> 			
				<input type="button" class="btn btn-primary pull-right" value="S'inscrire" />						
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