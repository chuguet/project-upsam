$(document).ready(function(){

	 app.initialize();

     function FaqNavigatorInteractor(){

        var self = {};
        var creationPanel = $(".creationPanel");
        var searchPanel = $(".searchPanel");
        var showSearch = $("#showSearch");
        var showCreate = $("#showCreate");

        function showWhenShouldBe(panel){
            if(hasToBeVisible(panel)){
                hidePanels();
                panel.show();
            }
            else{
                hidePanels();
            }
        }

        function hasToBeVisible(element){
            return (element.css('display') == 'none');
        }

        function hidePanels(){
            searchPanel.hide();
            creationPanel.hide();
        }

        function listenOnClickEvent(link, panel){
            link.click(function(event){
                event.preventDefault();
                showWhenShouldBe(panel);
            });
        }

        self.init = function(){
            listenOnClickEvent(showCreate, creationPanel);
            listenOnClickEvent(showSearch, searchPanel);
        }

        return self;
     }

	 function HumanBodyInteractor(){

		 var self = {};
		 var mapzone = $(".mapzone");
		 var questions_answers_container = $(".questions_answers");
         var question = $(".respuesta");

		 self._currentZone;

         function refreshContentByHumanBody(){
            questions_answers_container.removeClass("hide");
            question.text(self._currentZone.attr("info"));
         }

         function applyVisualEffectImage(){
           self._currentZone.maphilight({ stroke: false, fillColor: 'red', fillOpacity: 1 });
         }

		 var handler = function (){
			 refreshContentByHumanBody();
		     applyVisualEffectImage();
		 };

		 self.init = function (){
			 listenImageMapEvents(handler);
		 };

		 function listenImageMapEvents(handler){
			 mapzone.click(function(event){
				 event.preventDefault();
                 self._currentZone = $(this);
				 handler();
			 });
		 }

		 return self;
	 }

    function initInteractors(){
        new HumanBodyInteractor().init();
        new FaqNavigatorInteractor().init();
    }

    initInteractors();
});