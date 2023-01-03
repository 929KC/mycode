<template>
  <div id="app">
    <div class="todo-container">
      <div class="todo-wrap">
        <TodoHeader @NewTodo="addTodo"></TodoHeader>
        <TodoList :todos="todos" @del="delById" @sel="selById"></TodoList>
        <TodoFooter :todos="todos" @selAll="selall"></TodoFooter>
      </div>
    </div>
  </div>
</template>

<script>
import TodoHeader from './components/TodoHeader.vue'
import TodoList from './components/TodoList.vue'
import TodoFooter from './components/TodoFooter.vue'

export default {
  name: 'app',
  components: {
   TodoHeader,TodoList,TodoFooter
  },
  data(){
  	return{
  		todos:[
  			{id:'001',title:'吃饭',done:false},
  			{id:'002',title:'睡觉',done:true},
  			{id:'003',title:'打豆豆',done:false}
  		]
  	}
  },
  methods:{
	  addTodo(todo){
		 console.log("新的todo----",todo)
		 // this.todos.push(todo)  //将数据添加到数组的后面
		 this.todos.unshift(todo)  //将数据添加到数组的前面
	  },
	  delById(val){
		  this.todos = this.todos.filter((todo)=>{
			  return todo.id != val
		  })
	  },
	  selById(id){
		  this.todos.forEach((todo)=>{
				if(todo.id == id){
					todo.done = !todo.done;
					console.log(todo);
				}
		  })
	  },
	  selall(flag){
		  this.todos.forEach((todo)=>{
		  	todo.done = flag;
		  })
	  }
  }
}
</script>

<style>
	/*base*/
	body {
	  background: #fff;
	}

	.btn {
	  display: inline-block;
	  padding: 4px 12px;
	  margin-bottom: 0;
	  font-size: 14px;
	  line-height: 20px;
	  text-align: center;
	  vertical-align: middle;
	  cursor: pointer;
	  box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.2), 0 1px 2px rgba(0, 0, 0, 0.05);
	  border-radius: 4px;
	}

	.btn-danger {
	  color: #fff;
	  background-color: #da4f49;
	  border: 1px solid #bd362f;
	}

	.btn-danger:hover {
	  color: #fff;
	  background-color: #bd362f;
	}

	.btn:focus {
	  outline: none;
	}

	.todo-container {
	  width: 600px;
	  margin: 0 auto;
	}
	.todo-container .todo-wrap {
	  padding: 10px;
	  border: 1px solid #ddd;
	  border-radius: 5px;
	}

	

	
	

	

</style>
