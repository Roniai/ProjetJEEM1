<%@include file="WEB-INF/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Patient</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/monstyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
	<div class="card">
		<div class="card-header">
		Liste des Patients
		</div>
		<div class="card-body">
			<form action="patient.do" method="get" style="margin-bottom:10px">
				<input class="form-control" type="text" name="motCle" value="${model.motCle}" style="width:200px;display:inline-block;margin-top:-5px" autocomplete="off"/>
				<button type="submit" class="btn btn-primary" style="margin-bottom:4px">Chercher</button>
				<a href="ajouterPatient.do" class="btn btn-primary" style="float:right;">
				+ Ajouter</a>
			</form>
			<table class="table table-striped">
				<tr>
					<th>Codepat</th>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Sexe</th>
					<th>Adresse</th>
					<th>Modifier</th>
					<th>Suppression</th>
				</tr>
				<c:forEach items="${model.patients}" var="p">
				<tr>	
					<td>${p.codepat}</td>
					<td>${p.nom}</td>
					<td>${p.prenom}</td>
					<td>
						<c:if test="${p.sexe=='M'}"><c:out value="Masculin"></c:out></c:if>
						<c:if test="${p.sexe=='F'}"><c:out value="F�minin"></c:out></c:if>
					</td>
					<td>${p.adresse}</td>
					<td><a href="modifierPatient.do?id=${p.id}"><img src="images/edit.png" width="40" style="margin-bottom:-10px;"></a></td>
					<td><a onclick="return confirm('Etes-vous s�r de supprimer ce patient?')" href="supprimerPatient.do?id=${p.id}">
					<img src="images/delete.png" width="50" style="margin:-10px 0px"></a></td>
				</tr>
				</c:forEach>
			</table>
		</div>
	
	</div>
</div>

</body>
</html>
</html>