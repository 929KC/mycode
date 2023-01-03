<template>
  <div>
    <h1>老师姓名:{{name}}</h1>
    <h1>老师年龄:{{age}}</h1>
    <button @click="sendTeacherName()">向App传递老师名字</button>
    <button @click="unblind">销毁绑定事件</button>
  </div>
</template>

<script>
  
export default {
    name:"Teacher",
    data() {
      return {
        teacherName:"叶秋涵",
        age:19
      }
    },
    methods:{
      sendTeacherName(){
        this.$emit("teacherName",this.teacherName)
      },
      unblind(){
        this.$off("teacherName")
      }
    }
}
</script>

<style>

</style>