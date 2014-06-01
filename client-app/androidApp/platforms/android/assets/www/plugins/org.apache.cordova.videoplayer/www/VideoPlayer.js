cordova.define("org.apache.cordova.videoplayer.VideoPlayer", function(require, exports, module) {

	var exec = require("cordova/exec");

	function VideoPlayer() {
		this.url = null;
	}

	VideoPlayer.prototype.play = function(url) {
		exec(null, null, "VideoPlayer", "playVideo", [url]);
	};

	module.exports = new VideoPlayer();
});