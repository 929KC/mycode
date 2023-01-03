<template>
  <div>
    <h1>{{schoolName}}</h1>
    <h1>{{address}}</h1>
    <button @click="sendSchoolName">向Student组件传递学校地址</button>
  </div>
</template>

<script>
import pubsub from "pubsub-js"
export default {
  name:"School",
  data() {
    return {
      schoolName:"B站大学",
      address:"哔哩哔哩"
    }
  },
  methods:{
    sendSchoolName(){
     // this.$bus.$emit("receiveSchoolName",this.schoolName)
      pubsub.publish("receiveSchoolName",this.schoolName)
    }
  
  }

}
</script>

<style>

</style>