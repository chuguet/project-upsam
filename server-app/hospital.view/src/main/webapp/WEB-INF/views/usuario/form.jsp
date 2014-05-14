<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">
	
	<c:if test="${operacion == 'edit'}">
		function showInformationIntoView(usuario){
			$('input[id=id]').val(usuario.id);
			$('input[id=nombre]').val(usuario.nombre);
			$('input[id=apellidos]').val(usuario.apellidos);
			$('input[id=email]').val(usuario.email);
			$('input[id=usuario]').val(usuario.user);
			if(usuario.rol=="Administrador"){
				$('#administrador').prop('checked', true).button("refresh");
			}else if (usuario.rol=="Usuario"){
				$('#user').prop('checked', true).button("refresh");
			}
		};
	</c:if>
</script>

<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="<c:url value="/home" />">Inicio</a></li>
			<li><a href="javascript:void" onclick="javascript:generic.getList('usuario');">Usuarios</a></li>
			<li>
			<c:choose>
				<c:when test="${operacion == 'new'}">Nuevo</c:when>
				<c:otherwise>Modificar</c:otherwise>
			</c:choose>
			</li>
		</ol>
	</div>
</div>


<form class="form-horizontal" role="form" action="javascript:usuario.getParams();">
	<input type="hidden" id="id" />
	
	<div class="form-group">
		<label for="nombre" class="col-sm-2 control-label">Nombre</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="nombre" placeholder="Nombre" required autofocus>
	    </div>
	</div>

	<div class="form-group">
		<label for="apellidos" class="col-sm-2 control-label">Apellidos</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="apellidos" placeholder="Apellidos" maxlength="200" required autofocus>
	    </div>
	</div>
	
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">Email</label>
	    <div class="col-sm-10">
	      <input type="email" class="form-control" id="email" placeholder="Email" maxlength="200" required>
	    </div>
	</div>
	
	<div class="form-group">
		<label for="usuario" class="col-sm-2 control-label">Usuario</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="usuario" placeholder="Usuario" maxlength="200" required>
	    </div>
	</div>
	
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Contrase&ntilde;a</label>
	    <div class="col-sm-10">
	      <input type="password" class="form-control" id="password" placeholder="Contrase&ntilde;a" maxlength="200" required>
	    </div>
	</div>
	<div class="form-group">
		<label for="usuario" class="col-sm-2 control-label">Tipo de usuario</label>
		<div class="col-sm-10">
			<div class="radio">
				<label>
			    	<input type="radio" name="rol" id="Administrador" checked/>
			    	Administrador
			  	</label>
			</div>
			<div class="radio">
		 		<label>
		   			<input type="radio" name="rol" id="Usuario" />
		   			M&eacute;dico
		 		</label>
			</div>
		</div>
	</div>
	
	<div class="botonera">
		<c:choose>
			<c:when test="${operacion == 'new'}">
				<button class="btn btn-default" id="btnSaveUsuario"><i class='fa fa-check fa-fw'></i>Guardar</button>
			</c:when>
			<c:otherwise>
				<button class="btn btn-default" id="btnSaveUsuario"><i class='fa fa-check fa-fw'></i>Modificar</button>
			</c:otherwise>
		</c:choose>
		<button class="btn btn-default" id="btnCancel" onclick="javascript:generic.getList('usuario');"><i class='fa fa-times fa-fw'></i>Cancelar</button>
	</div>
</form>