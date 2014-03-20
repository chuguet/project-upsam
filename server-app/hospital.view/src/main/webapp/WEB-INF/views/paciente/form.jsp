<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">
	paciente.formatForm();
	
	<c:if test="${operacion == 'edit'}">
	function showInformationIntoView(p) {
		$('input[id=id]').val(p.id);
		$('input[id=nombre]').val(p.nombre);
		$('input[id=apellidos]').val(p.apellidos);
		$('input[id=email]').val(p.email);
		$('input[id=expediente]').val(p.expediente);
		paciente.prepareUploader(p.id);
	};

	</c:if>
</script>
	<fieldset>
		<legend>
			<c:choose>
				<c:when test="${operacion == 'new'}">Alta de Paciente</c:when>
				<c:otherwise>Edici&oacute;n de Paciente</c:otherwise>
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
			<label for="expediente">Expediente:</label>
			<input id="expediente" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
		</p>
		<c:choose><c:when test="${operacion == 'edit'}">
			<div id="uploader">
			    <p>Your browser doesn't have Flash, Silverlight or HTML5 support.</p>
			</div>
			 
		</c:when></c:choose>
		<div class="botonera">
			<c:choose>
				<c:when test="${operacion == 'new'}">
					<input type="button" id="btnSavePaciente" value="Guardar" />
				</c:when>
				<c:otherwise>
					<input type="button" id="btnSavePaciente" value="Modificar" />
				</c:otherwise>
			</c:choose>
			<input type="button" id="btnCancel" value="Cancelar" />
		</div>
	</fieldset>

