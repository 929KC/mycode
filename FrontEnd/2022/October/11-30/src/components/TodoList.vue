<template>
	<ul class="todo-main">
	  <TodoItem v-for="todo in todos" :todo="todo" @delById="del" @selById="sel"></TodoItem>
	</ul>
</template>

<script>
	import TodoItem from './TodoItem.vue'
	export default {
		name:'TodoList',
		props:['todos'],
		components:{
			TodoItem
		},
		methods:{
			del(val){
				console.log(val);
				this.$emit("del",val);
			},
			sel(val){
				this.$emit("sel",val);
			}
		}
	}
</script>

<style scoped>
	/*main*/
	.todo-main {
	  margin-left: 0px;
	  border: 1px solid #ddd;
	  border-radius: 2px;
	  padding: 0px;
	}
	
	.todo-empty {
	  height: 40px;
	  line-height: 40px;
	  border: 1px solid #ddd;
	  border-radius: 2px;
	  padding-left: 5px;
	  margin-top: 10px;
	}
</style>
