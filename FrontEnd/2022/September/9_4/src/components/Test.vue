<template>
	<div>
		<button @click="isShow = !isShow">显示/隐藏</button>
		<transition-group  appear>
			<h1 v-show="isShow" key="1">你好啊！</h1>
			<h1 v-show="!isShow" key="2">Hello World</h1>
		</transition-group>
	</div>
</template>

<script>
	export default {
		name:'Test',
		data() {
			return {
				isShow:true
			}
		},
	}
</script>

<style scoped>
	h1{
		background-color: skyblue;
	}
	.v-enter,.v-leave-to{
		transform:translateX(-100%)
	}
	.todov-enter-to,.v-leave{
		transform:translateX(0px);
	}
	.v-enter-active,.v-leave-active{
		transition: 0.5s linear;
	}


</style>