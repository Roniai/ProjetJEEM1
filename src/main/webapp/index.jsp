<%@include file="WEB-INF/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Medecin</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
	<div class="card">
		<div class="card-header">
		Liste des Medecins
		</div>
		<div class="card-body">
			<form>
				<button class="btn btn-primary" style="float:right;background: rgb(0,139,139)">
				<a href="ajouterMedecin.do" style="color:white;text-decoration:none">+ Ajouter</a></button>
			</form>
			<table class="table table-striped">
				<tr>
					<th>Codemed</th>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Grade</th>
					<th>Modifier</th>
					<th>Suppression</th>
				</tr>
				<c:forEach items="${model.medecins}" var="m">
				<tr>
					<td>${m.codemed}</td>
					<td>${m.nom}</td>
					<td>${m.prenom}</td>
					<td>${m.grade}</td>
					<td><a href="modifierMedecin.do?codemed=${m.codemed}"><img src="images/edit.png" width="40" style="margin-bottom:-10px;"></a></td>
					<td><a onclick="return confirm('Etes-vous sûr de supprimer ce medecin?')" href="supprimerMedecin.do?codemed=${m.codemed}">
					<img src="images/delete.png" width="50" style="margin:-10px 0px"></a></td>
				</tr>
				</c:forEach> 
			</table>
		</div>
	
	</div>
</div>

</body>
</html>