<template>
  <!-- 自定义事件作用:子向父组件提供数据 -->
<div id="root">
  <div class="todo-container">
    <div class="todo-wrap">
     <Top @addTodo="addTodo"/>
        <!-- 将todos传递给List -->
      <List :todos="todos"/>
      <MyFooter
      :todos = "todos"
      @checkAllTodo = "checkAllTodo"
      @clearAllTodo = "clearAllTodo"
      />
    </div>
  </div>
</div>
</template>

<script>

import Top from "./components/Top.vue"
import MyFooter from "./components/MyFooter.vue";
import List from "./components/List.vue"

export default {
    name:"App",
    components:{ Top, List, MyFooter },
    methods:{
        addTodo(todoObj){
            this.todos.unshift(todoObj)//向数组前头添加一个对象
        },
        checkTodo(id){
          this.todos.forEach((todo)=>{
            if (todo.id==id) todo.done = !todo.done
          })
        },
        updateTodo(id){
          this.todos.forEach((todo)=>{
            if (todo.id==id) todo.title = !todo.title
          })
        },
        deleteTodo(id){
          //使用过滤器进行列表的删除 
          this.todos = this.todos.filter(todo =>todo.id!==id)
        },
        checkAllTodo(done){
            this.todos.forEach((todo)=>{
              todo.done = done
            })
        },
        clearAllTodo(){
       this.todos = this.todos.filter((todo)=>{
            return !todo.done
          })
        }
    },
    data() {
        return {
        //     todos:[
        //     {id:"001",title:"抽烟",done:true},
        //     {id:"002",title:"喝酒",done:true},
        //     {id:"003",title:"开车",done:true}
        // ]
        todos:JSON.parse(localStorage.getItem("todos"))||[]
        }
    },
    watch:{
     todos:{
      deep:true,
      handler(value){
        localStorage.setItem("todos",JSON.stringify(value))
      } 
     }
    },
    mounted(){
      //绑定事件
      this.$bus.$on("checkTodo",this.checkTodo)
      this.$bus.$on("deleteTodo",this.deleteTodo)
      this.$bus.$on("updateTodo",this.updateTodo)
    },
    beforeDestroy(){
      this.$bus.$off("checkTodo")
      this.$bus.$off("deleteTodo")
      this.$bus.$off("updateTodo")
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


.btn-edit {
  color: #fff;
  background-color: skyblue;
  border: 1px solid skyblue;
  margin-right:6px;
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