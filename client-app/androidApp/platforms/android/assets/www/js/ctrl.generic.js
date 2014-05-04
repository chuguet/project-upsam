var generic = {
	'appInitialized' : false,
	'initialize' : function(methodToExecute) {
		if (typeof app + "" != "undefined" && ! this.appInitialized){
			app.initialize();
			this.appInitialized = true;
		}
		
		var that = this;
    	var divUsername = $("div#username");
    	var user = generic.getObject("usuario");
    	
    	if (divUsername.length > 0){
    		//No estamos en login.html
    		if (user != null){
    			divUsername.html(user.nombre + "&nbsp;" + user.apellidos);
    		}
	    	else{
	    		generic.changePage("login.html");
	    		return;
	    	}
    	}
    	
    	
    	if (methodToExecute && methodToExecute != null){
    		methodToExecute.apply(this, null);
    	}
    	//$("body").show();
    	that.processSpeech();     
    	that.processDatebox();
	},
	
	'processSpeech' : function() {
		$(".txt-speech").each(function (index) {
			var that = $(this);
			var id = $(this).attr('id');
			var button = $( "<div id='btnSpeech-" + id + "' title='Escritura por voz' data-icon='microphone' class='ui-btn-icon-textbox ui-btn-icon-right ui-icon-microphone'>&nbsp;</div>");
			
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
			var button = $( "<div id='btnDate-" + id + "' title='Seleccionar Fecha' data-icon='calendar' class='ui-btn-icon-textbox ui-btn-icon-right ui-icon-calendar'>&nbsp;</div>" );
			button.bind('click', function() {
				generic.handleDates(that);
			});
			that.bind('click', function() {
				generic.handleDates(this);
			});
			
			$(this).parent().append(button);
		});
	},
	
	'handleDates' : function(currentField, options) {
        event.stopPropagation();
        //var currentField = $(elm);
        var opts = options || {};
        var minVal = opts.min || 0;
        var maxVal = opts.max || 0;

        var myNewDate = Date.parse(currentField.val()) || new Date();
        if(typeof myNewDate === "number") {
            myNewDate = new Date (myNewDate);
        }

        window.plugins.datePicker.show({
            date : myNewDate,
            mode : 'date',
            minDate: Date.parse(minVal),
            maxDate: Date.parse(maxVal)
        }, function(returnDate) {
            if(returnDate !== "") {
                currentField.val(generic.getFormattedDate(returnDate));
            }
            currentField.blur();
        });
    },
	
	'changePage' : function(uri, parameters){
		var uriWithParameters = uri;
		if (parameters != null){
			uriWithParameters += "?";
			var count = 1;
			for(var name in parameters) {
				if (count > 1)
					uriWithParameters += "&";
				uriWithParameters += name + "=" + parameters[name];
				count++;
			}
		}
		$.mobile.changePage(uriWithParameters, { transition: "slide"});
		//document.location.href = uriWithParameters;
		//$.mobile.changePage(uri, { dataUrl : uriWithParameters, data : parameters, reloadPage : true, changeHash : true });
	},
	
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
	
	'alert' : function(title, message, resultCallback) {
		if (navigator && navigator.notification){
			navigator.notification.alert(message, resultCallback, title);
		}
		else{
			$("<div class='ui-loader ui-overlay-shadow ui-body-e ui-corner-all'><h3>" + message + "</h3></div>")
			.css({ "display": "block",
				"font-size" : "0.8em", 
				"opacity": 1, 
				"position": "fixed",
				"padding": "6px",
				"background-color" : "#ddd",
				"text-align": "justify",
				"width": "300px",
				"left": ($(window).width() - 314)/2,
				"top": $(window).height()/2 })
			.appendTo( $.mobile.pageContainer ).delay( 1500 )
			.fadeOut( 600, function(){
				$(this).remove();
				if (resultCallback != null){
					resultCallback();
				}
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
	},
	'unlogin' : function(){
		generic.deleteValue("usuario");
		generic.changePage("login.html");
	},
	'getActualDate' : function(){
		var today = new Date();
		var dd = today.getDate() <10 ? '0' + today.getDate() : today.getDate();
		var mm = today.getMonth() + 1 < 10 ? '0' + (today.getMonth() + 1) : today.getMonth() + 1;
		var yyyy = today.getFullYear();
		var curHour = today.getHours();
        var curMinute = today.getMinutes() < 10 ? "0" + today.getMinutes() : today.getMinutes();
        var curSeconds = today.getSeconds() < 10 ? "0" + today.getSeconds() : today.getSeconds();
	
		today = dd + '/' + mm + '/' + yyyy + " " + curHour + ":" + curMinute + ":" + curSeconds;
		return today;
	},
	'validateDate' : function(date){
	    var data = date.split("/");
	    // using ISO 8601 Date String
	    if (data.length == 3) {
		    if (Date.parse(data[2] + "-" + data[1] + "-" + data[0]) === NaN) {
		        return false;
		    }
	    }
	    else{
	    	return false;
	    }

	    return true;
	},
	'getFormattedDate' : function(fecha){
		var data = fecha.split("/");
		var dd = data[2] <10 ? '0' + data[2] : data[2];
		var mm = data[1] <10 ? '0' + data[1] : data[1];
		var yyyy = data[0];
		return dd + "/" + mm + "/" + yyyy;
	}
};