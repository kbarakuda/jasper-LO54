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
	href="https://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

<!--<link
	href="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/build/css/bootstrap-datetimepicker.css"
	rel="stylesheet">-->

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
<!--<script
	src="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/src/js/bootstrap-datetimepicker.js"></script>-->

<link type="text/css" rel="stylesheet" href="inc/style.css" />
<link rel="stylesheet" href="inc/jquery.datetimepicker.min.css" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>

	<div class="container">
		<!-- Page header -->
		<div class="row">
			<div class="col-md-12 ">
				<h2 id="header_" class="text-center" style="color: red">		
				<a href="http://localhost:8080/jasper/home" style="color: red; text-decoration:none;">INSCRIPTION A DES FORMATIONS TROP COOL</a></h2>
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
					<c:otherwise>
						<h4 class="text-center">Bienvenue sur notre site
							d'inscription aux formations en lignes</h4>
					</c:otherwise>
				</c:choose>

			</div>
		</div>

		<div class="row">
			<div class="col-md-12 ">
				<h5>Liste des formations :</h5>
			</div>
		</div>


		<form action="http://localhost:8080/jasper/home" id="myForm"
			class="row" name="searchForm" method="get">
			<div class="col-lg-3">
				<input id="recherche" type="text" name="searchTerm"
					class="form-control" placeholder="Search for..."
					value="${param.searchTerm}">
			</div>
			<div class="col-lg-3">
				<div class="dropdown">
					<select name="lieuFormation" class="form-control">
						<option value="">Lieu de formation (Tous)</option>
						<c:forEach var="lieuFormation"
							items="${requestScope.listLieuFormation}">
							<c:choose>
								<c:when test="${lieuFormation==param.lieuFormation}">
						            <option selected value="${lieuFormation}">${lieuFormation}</option>
						         </c:when>
								 <c:otherwise>
						            <option value="${lieuFormation}">${lieuFormation}</option>
						         </c:otherwise>
							</c:choose>					
						</c:forEach>
					</select>
				</div>
			</div>
			<div class='col-lg-3'>
				<div class="form-group">
					<div class='input-group date'>
						<input id='datetimepicker' name='date' type='text'
							class="form-control" placeholder="Ex: 12/07/2017 " value="${param.date}" /> 
							<span class="input-group-addon"> 
								<label for="datetimepicker"><span class="glyphicon glyphicon-calendar"></span></label>
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
									<a href="http://localhost:8080/jasper/home?generatePDF=${courseSession.id}" target="_blank"> To PDF</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</div>
		<div class="row">
			<div class="col-lg-2"></div>
			<button type="submit" form="subForm" class="btn btn-primary col-lg-6">
				S'inscrire <span class="glyphicon glyphicon-send"> </span>
			</button>
		</div>

		<footer class="footer"> <!--  <p>&copy; </p> --> </footer>
	</div>




	<script src="inc/jquery.datetimepicker.full.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#datetimepicker').datetimepicker({
				format : 'd/m/Y H:i'
			});

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
				select : function(a, b) {
					$(this).val(b.item.value);
					$("#myForm").submit()
				}
			});

		});
	</script>

</body>
</html>