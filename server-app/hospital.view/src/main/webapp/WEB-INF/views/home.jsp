<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Administraci&oacute;n LAM</title>
		<meta name="description" content="description">
		<meta name="author" content="DevOOPS">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="resources/css/generic.css" rel="stylesheet" type='text/css'>
		<link href="resources/devoops/plugins/bootstrap/bootstrap.css" rel="stylesheet">
		<link href="resources/devoops/plugins/jquery-ui/jquery-ui.min.css" rel="stylesheet">
		<link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
		<link href='http://fonts.googleapis.com/css?family=Righteous' rel='stylesheet' type='text/css'>
		<link href="resources/devoops/plugins/fancybox/jquery.fancybox.css" rel="stylesheet">
		<link href="resources/devoops/plugins/fullcalendar/fullcalendar.css" rel="stylesheet">
		<link href="resources/devoops/plugins/xcharts/xcharts.min.css" rel="stylesheet">
		<link href="resources/devoops/plugins/select2/select2.css" rel="stylesheet">
		<link href="resources/devoops/css/style.css" rel="stylesheet">
		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
				<script src="http://getbootstrap.com/docs-assets/js/html5shiv.js"></script>
				<script src="http://getbootstrap.com/docs-assets/js/respond.min.js"></script>
		<![endif]-->
		
		<script src="resources/js/jquery-1.8.2.min.js" type="text/javascript"></script>
		<script src="resources/js/jquery-ui-1.9.1.min.js" type="text/javascript"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="resources/devoops/plugins/bootstrap/bootstrap.min.js"></script>
		<script src="resources/devoops/plugins/justified-gallery/jquery.justifiedgallery.min.js"></script>
		<script src="resources/devoops/plugins/tinymce/tinymce.min.js"></script>
		<script src="resources/devoops/plugins/tinymce/jquery.tinymce.min.js"></script>
		<!-- All functions for this theme + document.ready processing -->
		<script src="resources/devoops/js/devoops.js"></script>
		
		<script src="resources/js/generic.js" type="text/javascript"></script>
		
		<script src="resources/js/views/usuario.js" type="text/javascript"></script>
		<script src="resources/js/views/paciente.js" type="text/javascript"></script>
		<script src="resources/js/views/restriccion.js" type="text/javascript"></script>
		<script src="resources/js/views/sugerencia.js" type="text/javascript"></script>
		
		
		<script src="resources/js/jquery.fancytree.js" type="text/javascript"></script>
		<script src="resources/js/bootstrap-moment.js" type="text/javascript"></script>
		<script src="resources/js/bootstrap-datetimepicker.js" type="text/javascript"></script>
		<link href="resources/css/bootstrap-datetimepicker.css" rel="stylesheet">
		<link href="resources/css/jquery.ui.fancytree.css" rel="stylesheet">
		
		<script src="resources/js/plupload.full.min.js" type="text/javascript"></script>
		<script src="resources/js/jquery.ui.plupload.min.js" type="text/javascript"></script>
		<script src="resources/js/i18n/plupload.locale-es.js" type="text/javascript"></script>
		<script src="resources/js/jquery.plupload.queue.min.js" type="text/javascript"></script>
		<link href="resources/css/jquery.ui.plupload.css" rel="stylesheet" type="text/css">
		<link href="resources/css/jquery.plupload.queue.css" rel="stylesheet" type="text/css">
	</head>
	<body class="home">
	<!--Start Header-->
	<div id="screensaver">
		<canvas id="canvas"></canvas>
		<i class="fa fa-lock" id="screen_unlock"></i>
	</div>
	<div id="modalbox">
		<div class="devoops-modal">
			<div class="devoops-modal-header">
				<div class="modal-header-name">
					<span>Basic table</span>
				</div>
				<div class="box-icons">
					<a class="close-link">
						<i class="fa fa-times"></i>
					</a>
				</div>
			</div>
			<div class="devoops-modal-inner">
			</div>
			<div class="devoops-modal-bottom">
			</div>
		</div>
	</div>
	<header class="navbar">
		<div class="container-fluid expanded-panel">
			<div class="row">
				<div id="logo" class="col-xs-12 col-sm-2">
					Admin LAM
				</div>
				<div id="top-panel" class="col-xs-12 col-sm-10">
					<div class="row">
						<div class="col-xs-8 col-sm-4">
							<a href="#" class="show-sidebar">
							  <i class="fa fa-bars"></i>
							</a>
						</div>
						<div class="col-xs-4 col-sm-8 top-panel-right">
							<ul class="nav navbar-nav pull-right panel-menu">
								<li class="dropdown">
									<a href="#" class="dropdown-toggle account" data-toggle="dropdown">
										<div class="avatar">
											<img src="resources/devoops/img/avatar.jpg" class="img-rounded" alt="avatar" />
										</div>
										<i class="fa fa-angle-down pull-right"></i>
										<div class="user-mini pull-right">
											<span class="welcome">Bienvenido,</span>
											<span>${nombre} ${apellidos}</span>
										</div>
									</a>
									<ul class="dropdown-menu">
										<li>
											<a href="<c:url value="/j_spring_security_logout" />">
												<i class="fa fa-power-off"></i>
												<span class="hidden-sm text">Logout</span>
											</a>
										</li>
									</ul>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!--End Header-->
	<!--Start Container-->
	<div id="main" class="container-fluid">
		<div class="row">
			<div id="sidebar-left" class="col-xs-2 col-sm-2">
				<ul class="nav main-menu">
					
					<sec:authorize ifAnyGranted="ROLE_ADMIN">
					<li>
						<a href="javascript:void" onclick="javascript:generic.getList('usuario');" class="active">
							<i class="fa fa-user"></i>
							<span class="hidden-xs">Usuarios</span>
						</a>
					</li>
					<li>
						<a href="javascript:void" onclick="javascript:generic.getList('restriccion');" class="active">
							<i class="fa fa-ban"></i>
							<span class="hidden-xs">Restricciones</span>
						</a>
					</li>
					<li>
						<a href="javascript:void" onclick="javascript:generic.getList('sugerencia');" class="active">
							<i class="fa fa-comment-o"></i>
							<span class="hidden-xs">Sugerencias</span>
						</a>
					</li>
					</sec:authorize>
					<sec:authorize ifAnyGranted="ROLE_USER">
					<li>
						<a href="javascript:void" onclick="javascript:generic.getList('paciente');" class="active">
							<i class="fa fa-male"></i>
							<span class="hidden-xs">Pacientes</span>
						</a>
					</li>
					</sec:authorize>
				</ul>
			</div>
			<!--Start Content-->
			<div id="content" class="col-xs-12 col-sm-10">
				<div class="preloader" style="display:none">
					<img src="resources/devoops/img/devoops_getdata.gif" class="devoops-getdata" alt="preloader"/>
				</div>
				<div id="ajax-content"><img src="resources/imgs/home.jpeg" alt="imagen home" style="position: absolute;top:80px;left: 50%;margin-left: -320px;"/></div>
			</div>
			<!--End Content-->
		</div>
	</div>
	</body>
</html>