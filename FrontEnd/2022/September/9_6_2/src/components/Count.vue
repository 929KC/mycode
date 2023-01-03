<template>
  <div>
    <h1>当前求和为:{{sum}}</h1>
    <h1>当前求和为sum的十倍:{{bigSum}}</h1>
    <h1>我在{{school}},学{{subject}}</h1>
    <h1 id="p">下面组件人员列表人数为:{{personList.length}}</h1>
    <select v-model.number="num">
      <option value="1">1</option>
      <option value="2">2</option>
      <option value="3">3</option>
    </select>
    <button @click="increment(num)">+</button>
    <button @click="decrement(num)">-</button>
    <button @click="decrementOdd(num)">当前求和为奇数再加</button>
    <button @click="incrementWait(num)">等一等在加</button>
  </div>
</template>

<script>
import { mapState,mapGetters,mapMutations,mapActions } from 'vuex'  
export default {
  name: "Count",
  data() {
    return {
      num:1
    }
  },
  methods: {
    // increment() {
    //  // this.sum+=this.num
    //  //this.$store.dispatch("add",this.num)
    //  this.$store.commit("ADD",this.num)
    // },
    // decrement() {
    //   //this.sum-=this.num
    //   //this.$store.dispatch("sub",this.num)
    //   this.$store.commit("SUB",this.num)
    // },
    ... mapMutations("countAbout",{increment:"ADD",decrement:"AUB"}) ,
    // decrementOdd() {
    //   // if (this.$store.state.sum%2){
    //   //   //this.sum+=this.num
    //    this.$store.dispatch("addOdd",this.num)
    //   // }
    // },
    // incrementWait() {
    //   //setTimeout(()=>{
    //     //this.sum+=this.num
    //  this.$store.dispatch("addWait",this.num)
    // //  },300)
    // }
    ...mapActions("countAbout",{incrementWait:"addWait",decrementOdd:"addOdd"})
  },
  computed:{
    //对象写法
      //...mapState({sum:"sum",school:"school",subject:"subject",personList:"personList"}),
  //数组写法
  ...mapState("countAbout",["sum","school","subject"]),
  
  ...mapState("personAbout",["personList"]),
  //对象写法
  //...mapGetters({bigSum:"bigSum"})
  //数组写法
  ...mapGetters("countAbout",["bigSum"])
    }
}
</script>

<style>
button {
  margin-left: 8px;
}
#p{
color: red;

}
</style>