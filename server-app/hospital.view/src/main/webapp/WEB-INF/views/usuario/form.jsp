<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">
	usuario.formatForm();
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
<fieldset>
	<legend>
	<c:choose>
		<c:when test="${operacion == 'new'}">Alta de Usuario</c:when>
		<c:otherwise>Edici&oacute;n de Usuario</c:otherwise>
	</c:choose>
	</legend>
	<input type="hidden" id="id" />
	<p>
		<label for="nombre">Nombre:</label>
		<input id="nombre" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
	</p>
	<p>
		<label for="apellidos">Apellidos:</label>
		<input id="apellidos" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
	</p>
	<p>
		<label for="email">Email:</label>
		<input id="email" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
	</p>
	<p>
		<label for="usuario">Usuario:</label>
		<input id="usuario" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
	</p>
	<p>
		<label for="pwd">Contrase&ntilde;a:</label>
		<input id="pwd" type="password" maxlength="200" class="text ui-widget-content ui-corner-all" />
	</p>
	<p>
		<div id="rol">
			<label for="rol">Rol:</label>
			<label for="administrador">Admin</label>
		    <input type="radio" id="administrador" name="rol" value="Administrador"/>
			<label for="user">Usuario</label>
		    <input type="radio" id="user" name="rol" value="Usuario"/>
		</div>
	</p>
	<div class="botonera">
		<c:choose>
			<c:when test="${operacion == 'new'}">
				<input type="button" id="btnSaveUsuario" value="Guardar" />
			</c:when>
			<c:otherwise>
				<input type="button" id="btnSaveUsuario" value="Modificar" />
			</c:otherwise>
		</c:choose>
		<input type="button" id="btnCancel" value="Cancelar" />
	</div>
</fieldset>