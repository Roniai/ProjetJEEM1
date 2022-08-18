<%@include file="WEB-INF/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Visiter</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
	<div class="card">
		<div class="card-header">
		Liste des Visites
		</div>
		<div class="card-body">
			<form>
				<button class="btn btn-primary" style="float:right;background: rgb(0,139,139)">
				<a href="ajouterVisiter.do" style="color:white;text-decoration:none">+ Ajouter</a></button>
			</form>
			<table class="table table-striped">
				<tr>
					<th>Codemed</th>
					<th>Codepat</th>
					<th>Date</th>
					<th>Modifier</th>
					<th>Suppression</th>
				</tr>
				<c:forEach items="${model.visiters}" var="v">
				<tr>	
					<td>${v.codemed}</td>
					<td>${v.codepat}</td>
					<td>${v.date}</td>
					<td><a href="modifierVisiter.do?id=${v.id}"><img src="images/edit.png" width="40" style="margin-bottom:-10px;"></a></td>
					<td><a onclick="return confirm('Etes-vous sûr de supprimer cette visite?')" href="supprimerVisiter.do?id=${v.id}">
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