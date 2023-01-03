//获取html中控件
var audio = document.getElementById("myaudio");
var playPause = document.getElementById("playPause")
var prev = document.getElementById("prev");
var next = document.getElementById("next");
var songImg = document.getElementById("song-img");
var songname = document.getElementById("song-name");
var artist = document.getElementById("artist");
var shuffle = document.getElementById("shuffle");
var repeat = document.getElementById("repeat");
var curProc = document.getElementById("cur-process");
var curTime = document.getElementById("current-time");
var totletime = document.getElementById("totle-time");
var procBar = document.getElementById("process-bar");

//定义控制变量、初始化
var ispaly = false;

var songList = [{
		name: "光亮",
		artist: "周深",
		img: "imgs/01guangliang.jpg",
		src: "res/mp3_1.mp3"
	},
	{
		name: "河山大好",
		artist: "许嵩",
		img: "imgs/02heshan.jpg",
		src: "res/mp3_2.mp3"
	},
	{
		name: "青印",
		artist: "张德",
		img: "imgs/03qingyin.jpg",
		src: "res/mp3_3.mp3"
	},
	{
		name: "桃花诺",
		artist: "GEM 邓紫棋",
		img: "imgs/04taohua.jpg",
		src: "res/mp3_4.mp3"
	},
	{
		name: "理想",
		artist: "那英国等群星",
		img: "imgs/05lixiang.jpg",
		src: "res/mp3_5.mp3"
	}
];
var i = 0;

function FormatTime(time) {
	var minute = Math.floor(time / 60);
	var seconds = Math.floor(time % 60);
	minute = minute < 10 ? "0" + minute : minute;
	seconds = seconds < 10 ? "0" + seconds : seconds;
	return minute + ":" + seconds;
}

function playMusic() {
	if (!ispaly) {
		audio.play();
		playPause.className = "fa fa-pause";
		ispaly = true;
	} else {
		audio.pause();
		playPause.className = "fa fa-play";
		ispaly = false;
	}
}

function setsong(n) {
	songImg.src = songList[n].img;
	songname.innerText = songList[n].name;
	artist.innerText = songList[n].artist;
	audio.src = songList[n].src;
}

window.onload = function() {
	setsong(0)
}

playPause.onclick = function() {
	playMusic()
}
//上一首
prev.onclick = function() {
	i--;
	if (i < 0) {
		i = songList.length - 1
	}
	setsong(i);
	ispaly = false;
	playMusic();
}
//下一首
next.onclick = function() {
	i++;
	if (i >= songList.length) {
		i = 0;
	}
	setsong(i);
	ispaly = false;
	playMusic();
}

//随机播放
shuffle.onclick = function() {
	//i是一个0-songList.length-1随机数
	var rand = Math.floor(Math.random() * songList.length);
	setsong(rand);
	ispaly = false;
	playMusic();
}

//单曲循环
repeat.onclick = function() {
	if (!audio.repeat) {
		audio.repeat = true;
		repeat.style.color = "#2887e3"
	} else {
		audio.repeat = false;
		repeat.style.color = "#949494"
	}
}
//
audio.addEventListener('canplay', function() {
	//获取总时长
	var t = audio.duration;
	totletime.innerText = FormatTime(t);
});
audio.addEventListener("timeupdate", function() {
	var d = audio.duration;
	var t = audio.currentTime;
	curTime.innerText = FormatTime(t)
	curProc.style.width = t / d * 100 + "%";
});
//进度条点击事件
procBar.onclick = function(e) {
	//进度条的总长度
	var totalWidth = procBar.offsetWidth;
	//手指点的位置到进度提艾顶端的长度
	var x = e.clientX;
	var start = procBar.getBoundingClientRect().left;
	var sleng = x - start;
	curProc.style.width = sleng / totalWidth * 100 + "%";
	audio.currentTime = audio.duration * (sleng / totalWidth);
}
