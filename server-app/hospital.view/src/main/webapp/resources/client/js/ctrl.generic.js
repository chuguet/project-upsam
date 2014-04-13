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
	    	
	    	var divUsername = $("div#username");
	    	var user = generic.getObject("usuario");
	    	
	    	if (divUsername.length > 0){
	    		//No estamos en login.html
	    		if (user != null){
	    			divUsername.html(user.nombre + "&nbsp;" + user.apellidos);
	    		}
		    	else{
		    		generic.changePage("login.html");
		    	}
	    	}
	    	else{
	    		//Estamos en login.html
	    		if (user != null){
	    			generic.changePage("home.html");
	    		}
	    	}
	    	
	    	
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
			$(this).parent().css("position", "relative");
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
		document.location.href=uriWithParameters;
		//$.mobile.changePage(uri, { dataUrl : uriWithParameters, data : parameters, reloadPage : true, changeHash : true });
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
	    if (results == null){
	    	return null;
	    }
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
	},
	'alert' : function(title, message) {
		console.log(message);
		if (navigator && navigator.notification){
			navigator.notification.alert(message, null, title);
		}
		else{
			$("<div class='ui-loader ui-overlay-shadow ui-body-e ui-corner-all'><h3>" + message + "</h3></div>")
			.css({ display: "block", 
				opacity: 0.90, 
				position: "fixed",
				padding: "7px",
				"text-align": "center",
				width: "270px",
				left: ($(window).width() - 284)/2,
				top: $(window).height()/2 })
			.appendTo( $.mobile.pageContainer ).delay( 1500 )
			.fadeOut( 600, function(){
				$(this).remove();
			});
		}
	},
	'setValue' : function(key, value){
		localStorage.setItem(key, value);
	},
	'getValue' : function(key){
		return localStorage[key];
	},
	'deleteValue' : function(key){
		localStorage.removeItem(key);
	},
	'setObject' : function(key, value) {
		localStorage.setItem(key, JSON.stringify(value));
	},
	'getObject' : function(key) {
	    var value = localStorage.getItem(key);
	    return value && JSON.parse(value);
	}
};