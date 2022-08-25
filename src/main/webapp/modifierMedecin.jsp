<%@include file="WEB-INF/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>Formulaire de modification</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/monstyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container" style="width:500px">
	<div class="card">
		<div class="card-header">
		Modification du médecin
		</div>
		<div class="card-body">
			<form action="updateMedecin.do" method="post">
			<input type="hidden" name="codemed_old" value="${medecin.codemed}"/>
			<div class="form-group">
				<label class="control-label">Code : </label>
				<input type="text" name="codemed_new" class="form-control" value="${medecin.codemed}" autocomplete="off"/>
			</div>
			<div class="form-group">
				<label class="control-label">Nom : </label>
				<input type="text" name="nom" class="form-control" value="${medecin.nom}" autocomplete="off"/>
			</div>	
			<div class="form-group">
				<label class="control-label">Prenoms : </label>
				<input type="text" name="prenom" class="form-control" value="${medecin.prenom}" autocomplete="off"/>
			</div>	
			<div class="form-group">
				<label class="control-label">Grade : </label>
                <select name="grade" class="form-control" style="height: 40px;">
	                <option value="P" <c:if test="${medecin.grade=='P'}">selected</c:if> >Professeur</option>
	                <option value="D" <c:if test="${medecin.grade=='D'}">selected</c:if> >Docteur</option>
	                <option value="MI" <c:if test="${medecin.grade=='MI'}">selected</c:if> >Médecin Interne</option>
	                <option value="E" <c:if test="${medecin.grade=='E'}">selected</c:if> >Etudiant</option>
                </select>
			</div>
			<div style="margin-top:20px">
				<button type="submit" class="btn btn-primary">Modifier</button>
				<a href="medecin.do" class="btn btn-primary">Annuler</a>
			</div>
			</form>
		</div>
	
	</div>
</div>
</body>
</html>