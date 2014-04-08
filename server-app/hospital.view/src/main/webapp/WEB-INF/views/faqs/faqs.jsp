<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>FAQs</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="format-detection" content="telephone=no" />
		<meta name="viewport" content="user-scalable=no, initial-scale=1, maximum-scale=1, minimum-scale=1, width=device-width, height=device-height, target-densitydpi=device-dpi" />

		<link type="text/css" rel="stylesheet" href="../css/jquery.mobile-1.4.1.min.css">


		<script type="text/javascript" src="../js/index.js"></script>
		<script type="text/javascript" src='../js/jquery-1.9.1.min.js'></script>
		<script type="text/javascript" src='../js/jquery.mobile-1.4.1.min.js'></script>
        <script type="text/javascript" src="../js/FAQs/faqs.js"></script>

        <title>FAQs</title>

        <style type="text/css">
            .hide {
                display: none;
            }
            .padding {
                padding: 3px;
            }
            .halfWidth{
                width: 45%;
            }
        </style>
</head>
<body>

	<div data-role="page" data-theme="a" id="page1">
			<div data-role="header" >
				<h2>FAQs</h2>
				<a href="../home.html" data-icon="home" data-iconpos="notext" data-direction="reverse">Home</a>
			</div>
			<div id="header">
				<h3>Hoy es ${fecha}</h3>
				<h1>Aplicaci&oacute;n de Hospital</h1>
			</div>
			<div data-role="content">
                <div class="ui-field-contain">
                    <a href="#" class="halfWidth ui-btn ui-corner-all ui-btn-inline ui-icon-search ui-btn-icon-left showSearch">Buscador</a>
                    <a href="#" class="halfWidth ui-btn ui-corner-all ui-btn-inline ui-icon-plus ui-btn-icon-left showCreate">Crear</a>
                </div>
                <div class="searchPanel hide">
    				<div style="float:left; width: 25%">
                        <img src="../img/human_body.gif" width="313" height="598" border="0" usemap="#map" />
                            <map name="map">
                            <area shape="rect" coords="52,101,250,154"  href="#" class="mapzone" info="@hombro" />
                            <area shape="rect" coords="68,250,243,327"  href="#" class="mapzone" info="@cadera" />
                            <area shape="rect" coords="64,379,240,443"  href="#" class="mapzone" info="@rodilla" />
                            <area shape="rect" coords="53,526,259,590"  href="#" class="mapzone" info="@pie" />
                       </map>
    		        </div>

                    <div style="float:left; width: 74%">
                        <p><b>Escribe una pregunta o busca por contenido, puedes usar la imagen para filtrar</b></p>
                        <div class="ui-field-contain" style="width:100%;float:left;">
                            <div style="float:left;width: 85%">
                                <input placeholder="Usa @ para buscar por @tag" type="search" id="searchInput" name="searchInput" class="searchInput"/>
                            </div>
                            <div style="float:right">
                                <a href="#" class="ui-btn ui-corner-all ui-btn-inline ui-icon-search ui-btn-icon-left showSearch">Buscar</a>
                            </div>
                        </div>
                        <div class="questions_answers" class="hide">
                            <div class="ui-field-contain">
                                <ul data-role="listview" data-inset="true" data-divider-theme="a">
                                    <li data-role="list-divider">Hombro</li>
                                    <li><a href="#">Pregunta 1</a>
                                        <div id="answersContainer1" style="margin-left:5px;">
                                            <div class="ui-field-contain">
                                                20-03-2014 17:47&nbsp;&nbsp;Respuesta 1.........................................
                                            </div>
                                            <div class="ui-field-contain">
                                                12-03-2014 14:42&nbsp;&nbsp;Respuesta 2.........................................
                                            </div>
                                            <div class="ui-field-contain">
                                                10-02-2014 17:30&nbsp;&nbsp;Respuesta 3.........................................
                                            </div>
                                            <div class="ui-field-contain">
                                                20-01-2014 09:13&nbsp;&nbsp;Respuesta 4.........................................
                                            </div>
                                            <div class="ui-field-contain">
                                                09-01-2014 10:24&nbsp;&nbsp;Respuesta 5.........................................
                                            </div>
                                        </div>
                                        <div class="ui-field-contain" style="margin-left:5px;">
                                            <a href="#" class="ui-btn ui-mini ui-btn-inline ui-icon-eye ui-btn-icon-left"  style="width: 20%;">Ver mÃ¡s</a>
                                            <a href="#" class="ui-btn ui-mini ui-btn-inline ui-icon-plus ui-btn-icon-left"  style="width: 20%;">Responder</a>
                                        </div>
                                        <div class="ui-field-contain" style="margin-left:5px;margin-right:5px;">
                                            <textarea name="addinfo" id="info" maxlength="1000" placeholder="Escriba su respuesta..."></textarea>
                                        </div>
                                    </li>
                                    <li><a href="#">Pregunta 2</a></li>
                                    <li data-role="list-divider">Cadera</li>
                                    <li><a href="#">Pregunta 1</a></li>
                                    <li><a href="#">Pregunta 2</a></li>
                                    <li data-role="list-divider">Rodilla</li>
                                    <li><a href="#">Pregunta 1</a></li>
                                    <li><a href="#">Pregunta 2</a></li>
                                    <li data-role="list-divider">Pie</li>
                                    <li><a href="#">Pregunta 1</a></li>
                                    <li><a href="#">Pregunta 2</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="ui-field-contain creationPanel hide">
                    <p style="text-align:center;">
                        <b>Crea una pregunta con su respuesta o Ãºnicamente formula tu pregunta. Puedes aÃ±adir etiquetas para que sea mÃ¡s fÃ¡cil encontrarla.</b>
                    </p>

                    <div class="ui-field-contain">
                        <label for="section">SecciÃ³n</label>
                        <select name="section">
                            <option>Hombro</option>
                            <option>Cadera</option>
                            <option>Rodilla</option>
                            <option>Pie</option>
                        </select>
                    </div>

                    <div class="ui-field-contain">
                        <label for="section">*TÃ­tulo - Pregunta</label>
                        <input type="text" id="title" name="title" class="txt-speech" maxlength="200"/>
                    </div>

                    <div class="ui-field-contain">
                        <label for="section">Respuesta</label>
                        <textarea name="addinfo" id="info" maxlength="1000"></textarea>
                    </div>

                    <div class="ui-field-contain">
                        <label for="section">Etiquetas</label>
                        <input placeholder="AÃ±ade tus etiquetas separadas por comas" maxlength="200"/>
                    </div>

                    <div class="ui-field-contain" style="text-align:center;">
                        <a href="#" class="ui-btn ui-btn-inline ui-icon-plus ui-btn-icon-left"  style="width: 20%;">Guardar</a>
                    </div>

                </div>

			</div>
			<div data-role="footer">
				<h4>&copy; Copyright Info or Site URL</h4>
			</div>
		</div>


</body>
</html>