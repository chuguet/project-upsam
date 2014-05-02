/*
requirejs.config({
   paths: {
	   'cordova' : '../../cordova', 
	   'index' : '../index', 
	   'jquery' : '../jquery/jquery-1.9.1.min', 
	   'jmobile' : '../jquery/jquery.mobile-1.4.1', 
	   'generic' : '../ctrl.generic', 
	   'server' : '../server', 
	   'jqplot' : '../jquery/jquery.jqplot', 
	   'pointLabels' : '../jquery/jqplot.pointLabels'
    }, 

    // Use shim for plugins that does not support ADM
    shim: {
        'generic': ['jquery'],
        'jmobile': ['jquery'],
        'server': ['jquery'],
        'jqplot': ['jquery'],
        'pointLabels': ['jquery', 'jqplot']
    },
    enforceDefine: true
});
*/


define([
		"../../cordova", "../index", "../jquery/jquery-1.9.1.min", "../jquery/jquery.mobile-1.4.1", "../ctrl.generic", "../server", "../jquery/jquery.jqplot" 
], function($) {
	generic.initialize();
	grafica.recuperar();
});

var grafica = {
		'anglesDTO' : null,
		'recuperar' : function(){
			var idPaciente = generic.getURLParameter("idPaciente");
			var idExploracion = generic.getURLParameter("idExploracion");
			var idGrafica = generic.getURLParameter("idGrafica");
            server.get("pacientemovil/" + idPaciente + "/exploracion/" + idExploracion + "/ficheroEMT/" + idGrafica, null, grafica.recuperarCallback);
            $("#angleType").change( function(){
            	var value = this.value;
            	grafica.mostrar("aR" + value, "aL" + value);
            });
		},
		
		'recuperarCallback' : function(parameters){ 
			var numero = generic.getURLParameter("num");
			$("#numeroGrafica").html("Gr&aacute;fica  " + numero);
			grafica.anglesDTO = parameters.tablaDatos.anglesDTO;
			grafica.mostrar("aRAFE.M", "aLAFE.M");
		},
		
		'mostrar' : function(firstGraphic, secondGraphic){
			generic.loading();
			var line1 = grafica.recoverPoints(firstGraphic, "firstGraphic");
			var line2 = grafica.recoverPoints(secondGraphic, "secondGraphic");
			
			if (line1 != null){
			 	var size = line1.length * 50;
			 	$("#chart1").children().remove();
			  	$("#chart1").width(size);
			  	$.jqplot.config.enablePlugins = true;
			  	var plot1 = $.jqplot('chart1', [line1, line2], {
					seriesDefaults: { 
						showMarker:false,
						pointLabels: { show:true, formatString: "%#.3f", edgeTolerance : -10 } 
				  	}
			  	});
			}
			generic.noLoading();
		},
		
		'recoverPoints' : function(angleName, labelId){
			var maxim = -10000;
			var minim = 10000;
			for (var i = 0; i < grafica.anglesDTO.length; i++){
				if (grafica.anglesDTO[i].name == angleName){
					var points = [];
					for (var j = 0; j < grafica.anglesDTO[i].pointsDTO.length; j++){
						var value = parseFloat(grafica.anglesDTO[i].pointsDTO[j].c);
						if (value > maxim) {
							maxim = value;
						}
						if (value < minim){
							minim = value;
						}
						points.push([j, value]);
					}
					$("#" + labelId).html("<b>" + angleName + "</b>&nbsp;&nbsp;[Min: " + minim + " - Max: " + maxim + "]");
					return points;
				}
			}
			return null;
		}
};

			
			