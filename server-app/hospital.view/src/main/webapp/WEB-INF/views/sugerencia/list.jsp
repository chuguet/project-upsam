<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="<c:url value="/home" />">Inicio</a></li>
			<li>Sugerencias</li>
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-xs-12">
		<div class="box">
			<div class="box-header">
				<div class="box-name">
					<span>Listado de sugerencias del sistema</span>
				</div>
				<div class="box-icons">
					<a class="expand-link">
						<i class="fa fa-expand"></i>
					</a>
				</div>
				<div class="no-move"></div>
				
			</div>
			<div class="box-content" style="padding:10px 15px 0px 31px">
					<button id='btnAlta' class='btn btn-default'><i class='fa fa-plus fa-fw'></i>Nuevo</button>
					<button id="btnEditar" class="btn btn-default disabled"><i class="fa fa-pencil fa-fw"></i>Modificar</button>
					<button id="btnEliminar" class="btn btn-default disabled"><i class="fa fa-trash-o fa-fw"></i>Eliminar</button>
				</div>
			<div class="box-content no-padding">
				<table class="table table-bordered table-striped table-hover table-heading table-datatable" id="datatable-1">
					<thead>
						<tr>
							<th>T&iacute;tulo</th>
							<th>Mensaje</th>
						</tr>
					</thead>
					
					<tbody></tbody>
					
					<tfoot>
						<tr>
							<th>T&iacute;tulo</th>
							<th>Mensaje</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	function showInformationIntoView(information){
		for (var i = 0; i < information.length; i++){
			$("table.table tbody").append("<tr onclick='sugerencia.selectRow(this);'><td><input type='hidden' id='id" + i + "' value='" + information[i].id + "' />" + information[i].titulo + "</td><td>" + information[i].mensaje + "</td></tr>");
		}

		generic.processTable("sugerencia");
	};
</script>