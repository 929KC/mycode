var video = document.getElementById("myvideo");
var playPause = document.getElementById("playPause");
var playx2 = document.getElementById("playx2");
var curTime=document.getElementById("curTime");
var totalTime=document.getElementById("totalTime");
var volrange=document.getElementById("volRange");

//自定义变量
var isplay = false; //视频是否播放标记
var isx2 = false;

//自定义方法
//换算事件的方法
function FormatTime(time){//time单位是秒
	var hour=Math.floor(time/3600);
	var minute=Math.floor(time%3600/60);
	var seconds=Math.floor(time%60);
	hour=hour<10?"0"+hour:hour;
	minute=minute<10?"0"+minute:minute;
	seconds=seconds<10?"0"+seconds:seconds;
	return hour+":"+minute+":"+seconds;
}

//按钮的事件
//播放 暂停
playPause.onclick = function() {
	if (!isplay) {
		video.play();
		playPause.className = "fa fa-pause";
		isplay = true;
	} else {
		video.pause();
		playPause.className = "fa fa-play";
		isplay = false;
	}
}
//2倍速
playx2.onclick = function() {
	if (!isx2) {
		video.playbackRate = 2;
		playx2.className = "x2ok";
		isx2 = true;
	} else {
		video.playbackRate = 1;
		playx2.className = "x1ok";
		isx2 = false;
	}
}

//音量改变事件
volrange.onchange=function(){
	video.volume=volrange/value/10;
}


//视频可播放事件 ------放置总时长
video.addEventListener("canplay",function(){
	video.volume=0.5;
	totalTime.innerText=FormatTime(video.duration);
	});
//视频播放时长改变事件
video.addEventListener("timeupdate",function(){
	curTime.innerText=FormatTime(video.currentTime);
});
