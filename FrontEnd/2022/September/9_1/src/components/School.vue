<template>
  <div>
    <h1>学校名称:{{schoolName}}</h1>
    <h1>学校地址:{{address}}</h1>
    <button @click="sendSchoolName()">向App传递学校名字</button>
    
  </div>
</template>

<script>
export default {
    name:"School",
    props:["getSchoolName"],
    data() {
      return {
        schoolName:"B站大学",
        address:"哔哩哔哩"
      }
    },
    methods:{
      sendSchoolName(){
        this.getSchoolName(this.schoolName)
      }
    }
  
}
</script>

<style>

</style>
