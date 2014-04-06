var generic = {
	'initialize' : function(methodToExecute) {
		if (typeof app + "" != "undefined"){
			app.initialize();
		}
		
		var that = this;	
		$(document).bind("pagebeforecreate",function(event){
			generic.loading();
		}); 

		
		$(document).bind("pageinit", function() {
	    	that.processSpeech();     
	    	that.processDatebox();
	    	
	    	if (methodToExecute && methodToExecute != null){
	    		methodToExecute.apply(this, null);
	    	}
	    	else{
	    		generic.noLoading();
	    	}
	    });
	},
	
	'processSpeech' : function() {
		$(".txt-speech").each(function (index) {
			var that = $(this);
			var id = $(this).attr('id');
			var button = $( "<button id='btnSpeech-" + id + "' title='Escritura por voz' data-icon='microphone' class='ui-btn-icon-textbox ui-btn-icon-right ui-icon-microphone'>&nbsp;</button>" );
			button.bind('click', function() {
				$.mobile.loading( 'show', {
					text: 'Grabando',
					textVisible: true,
					theme: "b",
					textonly: false
				});
				var speech = new SpeechRecognition(
					function(){
						$.mobile.loading('hide');
					}, 
					function onResult(x){
						that.val(x['results'][0][0]['transcript']);
					}
				);
				speech.start();
			});
			
			$(this).parent().append(button);
		});
	},
	
	'processDatebox' : function() {
		$(".txt-date").each(function (index) {
			var that = $(this);
			var id = $(this).attr('id');
			var button = $( "<button id='btnDate-" + id + "' title='Seleccionar Fecha' data-icon='calendar' class='ui-btn-icon-textbox ui-btn-icon-right ui-icon-calendar'>&nbsp;</button>" );
			button.bind('click', function() {
				app.getCalendar(that)
			});
			that.bind('click', function() {
				app.getCalendar(this)
			});
			
			$(this).parent().append(button);
		});
	},
	
	'changePage' : function(uri, parameters){
		var uriWithParameters = uri;
		if (parameters != null){
			uriWithParameters += "?";
			var count = 1;
			for(var name in parameters) {
				if (count > 1)
					action += "&";
				uriWithParameters += name + "=" + parameters[name];
				count++;
			}
		}
		$.mobile.changePage(uri, { dataUrl : uriWithParameters, data : parameters, reloadPage : true, changeHash : true });
	},
	/*
	'getURLParameter' : function(sParam) {
	    var sPageURL = window.location.search.substring(1);
	    var sURLVariables = sPageURL.split('&');
	    for (var i = 0; i < sURLVariables.length; i++) {
	        var sParameterName = sURLVariables[i].split('=');
	        if (sParameterName[0] == sParam) {
	            return sParameterName[1];
	        }
	    }
	},
	*/
	'getURLParameter' : function(name){
	    var results = new RegExp('[\\?&amp;]' + name + '=([^&amp;#]*)').exec(window.location.href);
	    return results[1] || 0;
	},
	'loading' : function(){
		$.mobile.loading( 'show', {
			text: 'Cargando',
			textVisible: true,
			theme: "b",
			textonly: false
		});
	},
	'noLoading': function(){
		$.mobile.loading( 'hide');
	}
};