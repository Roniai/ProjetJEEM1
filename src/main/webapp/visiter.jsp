<%@include file="WEB-INF/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Visiter</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/monstyle.css" rel="stylesheet" type="text/css" />
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
				<a href="ajouterVisiter.do" class="btn btn-primary" style="float:right;margin-bottom:15px">
				+ Ajouter</a>
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
					<td>${v.id.codemed}</td>
					<td>${v.id.codepat}</td>
					<td>${sdf.format(v.date)}</td>
					<td><a href="modifierVisiter.do?codemed=${v.id.codemed}&codepat=${v.id.codepat}"><img src="images/edit.png" width="40" style="margin-bottom:-10px;"></a></td>
					<td><a onclick="return confirm('Etes-vous sûr de supprimer cette visite?')" href="supprimerVisiter.do?codemed=${v.id.codemed}&codepat=${v.id.codepat}">
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