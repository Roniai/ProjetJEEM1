<%@include file="WEB-INF/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>Formulaire de modification</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container" style="width:500px">
	<div class="card">
		<div class="card-header">
		Modification de la visite
		</div>
		<div class="card-body">
			<form action="updateMedecin.do" method="post">
			<div class="form-group">
				<label class="control-label">Code du Médecin : </label>
				<input type="text" name="codemed" class="form-control" autocomplete="off"/>
			</div>
			<div class="form-group">
				<label class="control-label">Code du Patient : </label>
				<input type="text" name="codepat" class="form-control" autocomplete="off"/>
			</div>
			<div class="form-group">
				<label class="control-label">Date : </label>
				<input type="text" name="date" class="form-control" autocomplete="off"/>
			</div>
			<div>
				<button type="submit" class="btn btn-primary" style="background: rgb(0,139,139)">Modifier</button>
			</div>			
			</form>
		</div>
	
	</div>
</div>
</body>
</html>