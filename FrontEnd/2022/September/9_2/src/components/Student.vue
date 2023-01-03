<template>
  <div>
    <h1>{{studentName}}</h1>
    <h1>{{age}}</h1>
  </div>
</template>

<script>

import pubsub from "pubsub-js"
export default {
  name:"School",
  data() {
    return {
      studentName:"叶秋涵",
      age:19
    }
  },
  mounted(){
  //  this.$bus.$on("receiveSchoolName",(data)=>{
  //     console.log("学校名字",data)
  //  })
  //接收订阅消息
  this.pubId = pubsub.subscribe("receiveSchoolName",(messsage,schoolName)=>{
      console.log(messsage,schoolName)
     })
  },
  beforeDestroy(){
    pubsub.unsubscribe(this.pubId)
  }

}
</script>

<style>

</style>