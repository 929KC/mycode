<template>
	<li>
	  <label>
	    <input type="checkbox" :checked="todo.done" @click="sel"/>
	    <span>{{todo.title}}</span>
	  </label>
	  <button class="btn btn-danger" @click="del">删除</button>
	</li>
</template>

<script>
	export default {
		name:'TodoItem',
		props:['todo'],
		methods:{
			del(){
				console.log(this.todo);
				this.$emit("delById",this.todo.id);
			},
			sel(){
				this.$emit("selById",this.todo.id);
			}
		}
	}
</script>

<style scoped>
	/*item*/
	li {
	  list-style: none;
	  height: 36px;
	  line-height: 36px;
	  padding: 0 5px;
	  border-bottom: 1px solid #ddd;
	}
	
	li label {
	  float: left;
	  cursor: pointer;
	}
	
	li label li input {
	  vertical-align: middle;
	  margin-right: 6px;
	  position: relative;
	  top: -1px;
	}
	
	li button {
	  float: right;
	  display: none;
	  margin-top: 3px;
	}
	
	li:before {
	  content: initial;
	}
	
	li:last-child {
	  border-bottom: none;
	}
	li:hover{
		background-color: #eeeeee;
	}
	li:hover button{
		display: block;
	}
</style>
