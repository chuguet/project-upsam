<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">
	<c:if test="${operacion == 'edit'}">
		function showInformationIntoView(regla) {
			$('input[id=id]').val(regla.id);
			$('#mensaje').val(regla.mensaje);
			$('#descripcion').val(regla.descripcion);
		};
	</c:if>
	restriccion.formatForm("${operacion}");
</script>

<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="<c:url value="/home" />">Inicio</a></li>
			<li><a href="javascript:void" onclick="javascript:generic.getList('restriccion');">Restricciones</a></li>
			<li>
			<c:choose>
				<c:when test="${operacion == 'new'}">Nueva</c:when>
				<c:otherwise>Modificar</c:otherwise>
			</c:choose>
			</li>
		</ol>
	</div>
</div>

<form class="form-horizontal" role="form" action="javascript:restriccion.getParams();">
	<input type="hidden" id="id" />
	
	<div class="form-group">
		<label for="descripcion" class="col-sm-2 control-label">Descripci&oacute;n</label>
	    <div class="col-sm-10">
	    	<textarea id="descripcion" cols="50" rows="4" class="text ui-widget-content ui-corner-all" />
	    </div>
	</div>

	<div class="form-group">
		<label for="mensaje" class="col-sm-2 control-label">Mensaje</label>
	    <div class="col-sm-10">
			<textarea id="mensaje" cols="50" rows="4" class="text ui-widget-content ui-corner-all" />
	    </div>
	</div>
	
	<label for="treeRellenados" class="tree">Campos rellenados</label>
		<div id="treeRellenados" class="tree"></div>
		<label for="treeSugeridos" class="tree">Campos sugeridos</label>
		<div id="treeSugeridos" class="tree"></div>
	
	<div class="botonera">
		<c:choose>
			<c:when test="${operacion == 'new'}">
				<button class="btn btn-default" id="btnSave" type="submit"><i class='fa fa-check fa-fw'></i>Guardar</button>
			</c:when>
			<c:otherwise>
				<button class="btn btn-default" id="btnSave" type="submit"><i class='fa fa-check fa-fw'></i>Modificar</button>
			</c:otherwise>
		</c:choose>
		<button class="btn btn-default" id="btnCancel" onclick="javascript:generic.getList('restriccion');"><i class='fa fa-times fa-fw'></i>Cancelar</button>
	</div>
</form>