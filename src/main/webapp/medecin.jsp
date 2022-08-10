<%@include file="WEB-INF/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>M�decin</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
	<div class="card">
		<div class="card-header">
		Liste des M�decins
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
				<p>Un message</p>
				<tr>	
					<td>${m.codemed}</td>
					<td>${m.nom}</td>
					<td>${m.prenom}</td>
					<td>${m.grade}</td>
					<td><a href="modifierMedecin.do?id=${m.id}"><img src="images/edit.png" width="40" style="margin-bottom:-10px;"></a></td>
					<td><a onclick="return confirm('Etes-vous s�r de supprimer ce medecin?')" href="supprimerMedecin.do?id=${m.id}">
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