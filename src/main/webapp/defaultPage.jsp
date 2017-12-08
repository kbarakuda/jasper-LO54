<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Création d'un client</title>

<!--  <link href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css" rel="stylesheet" />-->
<link rel="stylesheet" type="text/css"
	href="https://code.jquery.com/ui/1.12.0/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link
	href="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/build/css/bootstrap-datetimepicker.css"
	rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
<script type="text/javascript"
	src="//code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript"
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment-with-locales.js"></script>
<script
	src="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/src/js/bootstrap-datetimepicker.js"></script>

<link type="text/css" rel="stylesheet" href="inc/style.css" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>

	<div class="container">
		<!-- Page header -->
		<div class="row">
			<div class="col-md-12 ">
				<h2 id="header_" class="text-center" style="color: red">INSCRIPTION
					A DES FORMATIONS TROP COOL</h2>
			</div>
			<hr class="divider"></hr>
		</div>

		<div class="row">
			<div class="col-md-12 ">
				<c:choose>
					<c:when test="${param.save==1}">
						<div class="alert alert-success alert-dismissable">
						    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
						    <strong>Success!</strong> Vous avez été inscrit  
						  </div>
					</c:when>
    				<c:otherwise><h4 class="text-center">Bienvenue sur notre site d'inscription aux formations en lignes</h4></c:otherwise>
				</c:choose>

			</div>
		</div>

		<div class="row">
			<div class="col-md-12 ">
				<h5>Liste des formations :</h5>
			</div>
		</div>


		<form action="http://localhost:8080/jasper/home" id="myForm" class="row"
			name="searchForm" method="get">
			<div class="col-lg-4">
				<input id="recherche" type="text" name="searchTerm" class="form-control"
						placeholder="Search for..." value="${param.searchTerm}">
			</div>
			<div class="col-lg-2">
				<div class="dropdown">
					<button class="btn btn-default dropdown-toggle" type="button"
						id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="true">
						Lieu de formation <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
					</ul>
				</div>
			</div>
			<div class='col-lg-2'>
				<div class="form-group">
					<div class='input-group date' id='datetimepicker'>
						<input type='text' class="form-control" /> <span
							class="input-group-addon"> <span
							class="glyphicon glyphicon-calendar"></span>
						</span>
					</div>

				</div>
			</div>
			<div class="col-lg-2">
					<button type="submit" class="btn btn-primary">
				      <span class="glyphicon glyphicon-search"></span> Rechercher
				    </button>
			</div>
			</form>

			
			<div id="listeFormation" class="row">
			<form action="http://localhost:8080/jasper/registration" id="subForm">
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
						<c:forEach var="courseSession"
							items="${requestScope.listCourseSession}">
							<tr>
								<td scope="row"><input name="formation" required="required"
									type="radio" value="<c:out value="${courseSession.id}" />" /></td>
								<td scope="row"><c:out
										value="${courseSession.course.code += \" \" +=courseSession.course.title}" />
									<c:out value="" /></td>
								<td><fmt:formatDate pattern="dd-MM-yyyy H:m"
										value="${courseSession.startDate}" /></td>
								<td><c:out value="${courseSession.location.city}" /></td>
								<td><img class="icon-pdf" alt="icon-pdf"
									src="https://cdn4.iconfinder.com/data/icons/small-n-flat/24/file-pdf-128.png">
									<a href="#"> To PDF</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
			</div>
		<div class="row">
			<div class="col-lg-2">
				
			</div>
			<button type="submit" form="subForm" class="btn btn-primary col-lg-6">
			       S'inscrire <span class="glyphicon glyphicon-send"> </span>
			</button>		
		</div>
		
		<footer class="footer"> <!--  <p>&copy; </p> --> </footer>
	</div>





	<script type="text/javascript">
		$(document).ready(function() {
			$('#datetimepicker').datetimepicker();
			
			  $("#recherche").autocomplete({     
	                source : function(request, response) {
	                $.ajax({
	                        url : "http://localhost:8080/jasper/searchJSON",
	                        type : "GET",
	                        data : {
	                                term : request.term
	                        },
	                        dataType : "json",
	                        success : function(data) {
	                                response(data);
	                        }
			                });
			        },
			        select: function (a, b) {
			            $(this).val(b.item.value);
			            $("#myForm").submit()
			        }
			});
			
		});
	</script>

</body>
</html>