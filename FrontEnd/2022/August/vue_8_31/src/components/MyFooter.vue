<template>
     <div class="todo-footer" v-show="total">
        <label>
          <input type="checkbox" :checked ="isAll" @click="checkAll"/>
        </label>
        <span>
          <span>已完成{{doneTotal}}</span> / 全部 {{total}}
        </span>
        <button class="btn btn-danger" @click="clear">清除已完成任务</button>
      </div>
</template>

<script>
export default {
    name:"MyFooter",
    props:["todos"],
    computed:{
      doneTotal(){
        let i = 0
        this.todos.forEach(element => {
          if (element.done) {
            i++
          }
        })
        return i
      },
      total(){
        return this.todos.length
      },
      isAll(){
        return this.doneTotal === this.total && this.total
      }
    },
    methods:{
      checkAll(event){
        //this.checkAllTodo(event.target.checked)
        this.$emit("checkAllTodo",event.target.checked)
      },
      clear(){
       this.$emit("clearAllTodo")
      }
    }
}
</script>

<style>
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