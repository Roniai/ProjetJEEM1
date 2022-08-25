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
		Modification du patient
		</div>
		<div class="card-body">
			<form action="updatePatient.do" method="post">
			<input type="hidden" name="codepat_old" value="${patient.codepat}"/>
			<div class="form-group">
				<label class="control-label">Code : </label>
				<input type="text" name="codepat_new" class="form-control" value="${patient.codepat}" autocomplete="off"/>
			</div>
			<div class="form-group">
				<label class="control-label">Nom : </label>
				<input type="text" name="nom" class="form-control" value="${patient.nom}" autocomplete="off"/>
			</div>	
			<div class="form-group">
				<label class="control-label">Prenoms : </label>
				<input type="text" name="prenom" class="form-control" value="${patient.prenom}" autocomplete="off"/>
			</div>	
			<div class="form-group">
				<label class="control-label">Sexe : </label>
                <select  name="sexe" class="form-control" style="height: 40px;">
	                <option value="M" <c:if test="${patient.sexe=='M'}">selected</c:if> >Masculin</option>
	                <option value="F" <c:if test="${patient.sexe=='F'}">selected</c:if> >F�minin</option>
                </select>
			</div>
			<div class="form-group">
				<label class="control-label">Adresse : </label>
				<input type="text" name="adresse" class="form-control" value="${patient.adresse}" autocomplete="off"/>
			</div>	
			<div style="margin-top:20px">
				<button type="submit" class="btn btn-primary">Modifier</button>
				<a href="patient.do?motCle=" class="btn btn-primary">Annuler</a>
			</div>
			</form>
		</div>
	
	</div>
</div>
</body>
</html>