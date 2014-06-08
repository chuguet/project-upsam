<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">
	<c:choose>
		<c:when test="${operacion == 'edit'}">
			function showInformationIntoView(regla) {
				sugerencia.formatForm(regla);
			};
		</c:when>
		<c:otherwise>
			sugerencia.formatForm(null);
		</c:otherwise>
	</c:choose>
</script>

<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="<c:url value="/home" />">Inicio</a></li>
			<li><a href="javascript:void" onclick="javascript:generic.getList('sugerencia');">Sugerencias</a></li>
			<li>
			<c:choose>
				<c:when test="${operacion == 'new'}">Nueva</c:when>
				<c:otherwise>Modificar</c:otherwise>
			</c:choose>
			</li>
		</ol>
	</div>
</div>

<form class="form-horizontal" role="form" action="javascript:sugerencia.getParams();">
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
	
	<div id="form-operacion" class="form-group">
		<label for="operacion" class="col-sm-2 control-label">Operacion</label>
		<div class="row" id="operacion">
			<div class="col-sm-2">
				<select class="form-control">
				  <option value="-1">Elija una operaci&oacute;n</option>
				  <option value="0">Igual</option>
				  <option value="1">Mayor</option>
				  <option value="2">Mayor igual</option>
				  <option value="3">Menor</option>
				  <option value="4">Menor igual</option>
				</select>
			</div>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="valor" placeholder="Valor" maxlength="200">
			</div>
		 </div>
	</div>
	
	<div class="form-group">
		<label for="tree" class="col-sm-2 control-label">Campos</label>
		<div class="col-sm-10">
			<div id="tree" class="fancytree-radio"></div>
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
		<a class="btn btn-default" id="btnCancel" onclick="javascript:generic.getList('sugerencia');"><i class='fa fa-times fa-fw'></i>Cancelar</a>
	</div>
</form>