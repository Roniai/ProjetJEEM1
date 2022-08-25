<%@include file="WEB-INF/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Médecin</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/monstyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
	<div class="card">
		<div class="card-header">
		Liste des Médecins
		</div>
		<div class="card-body">
			<form>
				<a href="ajouterMedecin.do" class="btn btn-primary" style="float:right;margin-bottom:15px">
				+ Ajouter</a>
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
					<td>
						<c:if test="${m.grade=='P'}"><c:out value="Professeur"></c:out></c:if>
						<c:if test="${m.grade=='D'}"><c:out value="Docteur"></c:out></c:if>
						<c:if test="${m.grade=='MI'}"><c:out value="Médecin Interne"></c:out></c:if>
						<c:if test="${m.grade=='E'}"><c:out value="Etudiant"></c:out></c:if>
					</td>
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
</html>