<template>
  <div>
     <el-carousel indicator-position="outside">
    <el-carousel-item v-for="item in imags" :key="item">
      <el-image
      style="width: 1600px; height: 2240px"
      :src="item"
      fit="fill"></el-image>
    </el-carousel-item>
  </el-carousel>
  </div>
</template>

<script>
import myImags1 from "../assets/indexImags/1.jpg"
import myImags2 from "../assets/indexImags/2.jpg"
import myImags3 from "../assets/indexImags/3.jpg"
import  myImags4 from "../assets/indexImags/4.jpg"
import  myImags5 from "../assets/indexImags/5.jpg"
import  myImags6 from "../assets/indexImags/6.jpg"
export default {
  name: "MyIndex",
  data(){
    return {
      imags:[myImags1,myImags2,myImags3,myImags4,myImags5,myImags6]
    }
  }
}
</script>

<style scoped>

</style>