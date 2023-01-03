<template>
  <div>
      <School 
      :getSchoolName = "getSchoolName"
      />
      <hr>
      <!-- v-on绑定事件,当触发teacherName,
        会调用getStudentName,
        同时可以接收到触发函数的参数 
        teacherName事件名
        getStudentName回调名
      -->
      <Teacher v-on:teacherName="getStudentName"/>
  </div>
</template>

<script>
import School from "./components/School.vue"
import Teacher from "./components/Teacher.vue"


export default {
    name:"App",
    components:{ Teacher, School },
    methods:{
      getSchoolName(name){
          console.log(name);
      },
      getStudentName(name){
        console.log(name);
      }
    }
}
</script>

<style>

</style>