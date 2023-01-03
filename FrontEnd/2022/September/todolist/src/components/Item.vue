<template>
          <li>
          <label>
            <input type="checkbox" :checked="todo.done" @click="handleCheck(todo.id)"/>
            <span v-show="!todo.isEdit">{{todo.title}}</span>
            <input type="text" 
            :value="todo.title" 
            v-show="todo.isEdit"
            @blur="handBlur(todo,$event)"
            ref = "inputTitle" 
            >
          </label>
          <button class="btn btn-danger" @click="handDelete(todo.id)">删除</button>
          <button 
          class="btn btn-edit"
           @click="handEdit(todo)"
           v-show="!todo.isEdit"
           > 编辑</button>
        </li>
</template>

<script>
export default {
    name:"Item",
    //声明接收todo对象
    props:["todo"],
    methods:{
        handleCheck(id){
            //this.checkTodo(id)
            this.$bus.$emit("checkTodo",id)
        },
        handDelete(id){
            // if (confirm("确定要删除吗吗?")) {
            //   //this.deleteTodo(id)
            //   this.$emit("deleteTodo",id)
            // }
            this.$bus.$emit("deleteTodo",id)
        },
        handEdit(todo){
          if (todo.hasOwnProperty("isEdit")){
              todo.isEdit = true
          }else{
            //console.log("todo身上没有isEdit");
            this.$set(todo,"isEdit",true)
          }
          this.$nextTick(function(){
            this.$refs.inputTitle.focus()//下次解析DOM后调用
          })
        },
        handBlur(todo,e){
            todo.isEdit = false
            if (!e.target.value.trim()){
             alert("输入框不能为空")
            }else{
              this.$bus.$emit("updateTodo",todo.id,e.target.value)
            }
        }
    }
}
</script>

<style>
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
  background-color: #ddd;
}
li:hover botton{
  display:block;
}
</style>