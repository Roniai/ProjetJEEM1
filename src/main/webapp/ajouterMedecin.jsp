<%@include file="WEB-INF/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>Forumulaire d'ajout</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container" style="width:500px;">
	<div class="card">
		<div class="card-header">
		Ajout d'un nouveau médecin
		</div>
		<div class="card-body">
			<form action="saveSite.do" method="post">
			<div class="form-group">
				<label class="control-label">Numéro : </label>
				<input type="text" name="numsite" class="form-control" autocomplete="off"/>
			</div>
			<div class="form-group">
				<label class="control-label">Nom : </label>
				<input type="text" name="nomsite" class="form-control" autocomplete="off"/>
			</div>	
			<div class="form-group">
				<label class="control-label">Lieu : </label>
				<input type="text" name="lieusite" class="form-control" autocomplete="off"/>
			</div>	
			<div class="form-group">
				<label class="control-label">Tarif journalier : </label>
				<input type="text" name="tarifsite" class="form-control" autocomplete="off"/>
			</div>	
			<div>
				<button type="submit" class="btn btn-primary" style="background: rgb(0,139,139)">Ajouter</button>
			</div>		
			</form>
		</div>
	
	</div>
</div>
</body>
</html>