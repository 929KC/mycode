<template>
	<div class="todo-footer">
	  <label>
	    <input type="checkbox" v-model="isAll"/>
	  </label>
	  <span>
	    <span>已完成{{donetal}}</span> / 全部{{total}}
	  </span>
	  <button class="btn btn-danger">清除已完成任务</button>
	</div>
</template>

<script>
	export default {
		name:'TodoFooter',
		props:["todos"],
		computed:{
			total(){
				return this.todos.length;
			},
			donetal(){
				let n = 0;
				this.todos.forEach((todo)=>{
					if(todo.done){
						n++;
					}
				})
				return n
			},
			isAll:{
				get(){
					return this.total == this.donetal && this.total>0
				},
				set(value){
					this.$emit("selAll",value)
				}
			}
		}
		// ,
		// methods:{
		// 	selAll(e){
		// 		this.$emit("selAll",e.target.checked)
		// 	}
		// }
	}
</script>

<style scoped>
	/*footer*/
	.todo-footer {
	  height: 40px;
	  line-height: 40px;
	  padding-left: 6px;
	  margin-top: 5px;
	}
	
	.todo-footer label {
	  display: inline-block;
	  margin-right: 20px;
	  cursor: pointer;
	}
	
	.todo-footer label input {
	  position: relative;
	  top: -1px;
	  vertical-align: middle;
	  margin-right: 5px;
	}
	
	.todo-footer button {
	  float: right;
	  margin-top: 5px;
	}
</style>
