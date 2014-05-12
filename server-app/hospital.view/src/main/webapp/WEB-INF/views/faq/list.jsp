<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fieldset id="parent">
	<legend>Listado de Reglas</legend>
	<div class="botonera">
		<input type="button" id="btnAlta" value="Alta" />
		<input type="button" id="btnEditar" value="Editar" />
	</div>
	<table id="lista"></table>
	<div id=paginadorLista></div>
</fieldset>

<script type="text/javascript">
faq.formatList();
function showInformationIntoView(information){
	$("#lista").setGridParam({
		data : information
	}).trigger("reloadGrid");
	$(window).bind('resize', function() {
		$('#lista').setGridWidth($('.ui-jqgrid').parent().innerWidth() - 30);
	}).trigger('resize');
};
</script>