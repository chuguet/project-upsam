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
	faq.formatForm("${operacion}");
</script>
	<fieldset>
		<legend>
			<c:choose>
				<c:when test="${operacion == 'new'}">Alta de Regla</c:when>
				<c:otherwise>Edici&oacute;n de Regla</c:otherwise>
			</c:choose>
		</legend>
		<input type="hidden" id="id" />
		<label for="treeRellenados" class="tree">Campos rellenados</label>
		<div id="treeRellenados" class="tree"></div>
		<label for="treeSugeridos" class="tree">Campos sugeridos</label>
		<div id="treeSugeridos" class="tree"></div>
		<div class="containerTextTree">
			<div class="textTree">Descripci&oacute;n
				<textarea id="descripcion" cols="50" rows="9" class="text ui-widget-content ui-corner-all" />
			</div>
			<div class="textTree">Mensaje
				<textarea id="mensaje" cols="50" rows="3" class="text ui-widget-content ui-corner-all" />
			</div>
		</div>
		<div class="botonera">
			<c:choose>
				<c:when test="${operacion == 'new'}">
					<input type="button" id="btnSaveRegla" value="Guardar" />
				</c:when>
				<c:otherwise>
					<input type="button" id="btnSaveRegla" value="Modificar" />
				</c:otherwise>
			</c:choose>
			<input type="button" id="btnCancel" value="Cancelar" />
		</div>
	</fieldset>
