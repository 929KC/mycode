<template>
	<div class="todo-header">
	  <input type="text" placeholder="请输入你的任务名称，按回车键确认" v-model="newTitle" @keydown.enter="getNewTodo"/>
	</div>
</template>

<script>
	import {nanoid} from 'nanoid'
	
	export default {
		name:'TodoHeader',
		data(){
			return{
				newTitle:''
			}
		},
		methods:{
			getNewTodo(){
				//生成一个新的todo对象  let 局部变量 var 通用变量
				let todoObj = {id:nanoid(),title:this.newTitle,done:false}
				this.$emit('NewTodo',todoObj)
				this.newTitle=''
			}
		}
	}
</script>

<style scoped>
	/*header*/
	.todo-header input {
	  width: 560px;
	  height: 28px;
	  font-size: 14px;
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  padding: 4px 7px;
	}
	
	.todo-header input:focus {
	  outline: none;
	  border-color: rgba(82, 168, 236, 0.8);
	  box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px rgba(82, 168, 236, 0.6);
	}
</style>
