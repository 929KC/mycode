<template>
  <div>
    <h1 v-text="message" ref="title"></h1>
    <button ref="btn" @click="show">点我</button>
      <School/>
  </div>
</template>

<script>
import School from "./components/School.vue"

export default {
    name:"App",
    components:{School},
    data() {
      return {
        message:"Hello World"
      }
    },
    methods:{
      show(){
        console.log(this.$refs.btn);
      }
    },
}
</script>

<style>

</style>