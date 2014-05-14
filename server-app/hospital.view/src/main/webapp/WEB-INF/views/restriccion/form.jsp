<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">
	<c:if test="${operacion == 'edit'}">
		function showInformationIntoView(regla) {
			$('input[id=id]').val(regla.id);
			$('#mensaje').val(regla.mensaje);
			$('#titulo').val(regla.titulo);
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
		<label for="titulo" class="col-sm-2 control-label">T&iacute;tulo</label>
	    <div class="col-sm-10">
	    	<input type="text" class="form-control" id="titulo" placeholder="T&iacute;tulo" maxlength="200" required>
	    </div>
	</div>

	<div class="form-group">
		<label for="mensaje" class="col-sm-2 control-label">Mensaje</label>
	    <div class="col-sm-10">
			<textarea id="mensaje" rows="4" class="text ui-widget-content ui-corner-all" style="width:100%"></textarea>
	    </div>
	</div>
	
	<div class="form-group">
		<label for="treeRellenados" class="col-sm-2 control-label">Campos rellenados</label>
		<div class="col-sm-10">
			<div id="treeRellenados" class="tree"></div>
		 </div>
	</div>
	
	<div class="form-group">
		<label for="treeSugeridos" class="col-sm-2 control-label">Campos sugeridos</label>
		<div class="col-sm-10">
			<div id="treeSugeridos" class="tree"></div>
		 </div>
	</div>
	
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