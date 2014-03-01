$(document).ready(function(){

	app.initialize();

    function FaqPanelsInteractor(){
        var elements = ['creationPanel', 'searchPanel', 'showSearch', 'showCreate']
        var self = {};

        self.init = function(){
            initElementsByCssClass(self, elements);
            listenOnClickEvent(self._showCreate, self._creationPanel);
            listenOnClickEvent(self._showSearch, self._searchPanel);
        };

        function listenOnClickEvent(link, panel){
            link.click(function(event){
                event.preventDefault();
                showWhenShouldBe(panel);
            });
        }

        function showWhenShouldBe(panel){
            if(hasToBeVisible(panel)){
                hidePanels();
                panel.show();
                return;
            }
            hidePanels();
        }

        function hasToBeVisible(element){
            return (element.css('display') == 'none');
        }

        function hidePanels(){
            self._searchPanel.hide();
            self._creationPanel.hide();
        }

        self.init();

        return self;
    }

	function SearchEngineInteractor(){
        var self = {};
        var imageMapWidget = new ImageMapFilterWidget();
        var questionsAndAnswersWidget = new QuestionsAndAnswersWidget();

        imageMapWidget.init(questionsAndAnswersWidget.handler);

        return self;
	}

    function QuestionsAndAnswersWidget(){
        var elements = ['questions_answers', 'faqAnswer'];
        var self = {};

        function init(){
            initElementsByCssClass(self, elements);
        };

        self.handler = function handler(answerText){
            if(hasToBeVisible())
                showAnswer(answerText);
        };

        function hasToBeVisible(){
            return self._questions_answers.hasClass("hide");
        }

        function showAnswer(answerText){
            self._questions_answers.removeClass("hide");
            self._faqAnswer.text(answerText);
        }

        init();

        return self;
    }

    function ImageMapFilterWidget(){
        var elements = [ "mapzone"];
        var self = {};

        self.init = function (handler){
            initElementsByCssClass(self, elements);
            listenImageMapEvents(handler);

            return self;
        };

        function listenImageMapEvents(handler){
            self._mapzone.click(function(event){
                event.preventDefault();
                handler($(this));
            });
        }

        return self;
    }

    function initElementsByCssClass(container, elements){
        $.each(elements, function (index, element_id) {
            container["_"+element_id] = $("."+element_id);
        });
    }

    function initInteractors(){
        new SearchEngineInteractor();
        new FaqPanelsInteractor();
    }

    initInteractors();
});