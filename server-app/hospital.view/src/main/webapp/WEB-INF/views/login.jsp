<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
		<title>Hospital Ni&ntilde;o de Jes&uacute;s</title>
		<meta charset="utf-8">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<meta name="description" content="Pantalla de acceso al sistema" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		
		<link href="resources/css/generic.css" rel="stylesheet" type="text/css" />
		<link href="resources/css/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css">
		
		<script src="resources/js/bootstrap.js" type="text/javascript"></script>
		<script src="resources/js/jquery-1.8.2.min.js" type="text/javascript"></script>
		<script src="resources/js/jquery-ui-1.9.1.min.js" type="text/javascript"></script>
		<script src="resources/js/generic.js" type="text/javascript"></script>
	</head>
	
	<body class="login" onload='document.f.j_username.focus();'>
		<div class="container">
			<div class="account-wall">
				<form name='f' id='f' action="<c:url value='j_spring_security_check' />" method='POST' class="form-signin" role="form">
					<h2 class="form-signin-heading">Acceso de usuarios</h2>
			        <input type="text" name="j_username" value="" class="form-control" placeholder="Usuario" required autofocus>
			        <input type="password" name="j_password" class="form-control" placeholder="Contrase&ntilde;a" required>
			        <button class="btn btn-lg btn-primary btn-block" type="submit">Aceptar</button>
				</form>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		<c:if test="${not empty error}">;
		jAlert('${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}', 'Error');
		</c:if>;
		<c:if test="${noAccess}">;
		jAlert('No tiene acceso a la administraci&oacute;n del sistema',
				'Acceso prohibido');
		</c:if>;
		$('input[type=submit]').button();
		$('input[type=reset]').button();
	</script>
</html>