<%@include file="WEB-INF/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>Formulaire d'ajout</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container" style="width:500px">
	<div class="card">
		<div class="card-header">
		Ajout d'un nouveau médecin
		</div>
		<div class="card-body">
			<form action="saveMedecin.do" method="post">
			<div class="form-group">
				<label class="control-label">Code : </label>
				<input type="text" name="codemed" class="form-control" autocomplete="off"/>
			</div>
			<div class="form-group">
				<label class="control-label">Nom : </label>
				<input type="text" name="nom" class="form-control" autocomplete="off"/>
			</div>	
			<div class="form-group">
				<label class="control-label">Prenoms : </label>
				<input type="text" name="prenom" class="form-control" autocomplete="off"/>
			</div>
			<div class="form-group">
				<label class="control-label">Grade : </label>
                <select  name="grade" class="form-control" style="height: 40px;">
	                <option value="Professeur">Professeur</option>
	                <option value="Docteur">Docteur</option>
	                <option value="Médecin Interne">Médecin Interne</option>
	                <option value="Etudiant">Etudiant</option>
                </select>
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