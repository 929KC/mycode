<template>
  <div>
    <h1>人员列表</h1>
    <h1 id="sum">上面组件sum为:{{sum}}</h1>
    <input  placeholder="请输入名字" v-model="name"/>
    <button @click="add">添加</button>
    <ul>
        <li v-for="p in personList" :key="p.id">{{p.name}}</li>
    </ul>  
  </div>
</template>

<script>
import {nanoid} from "nanoid";
export default {
    name:"Person",
    data() {
        return {
            name:"",
        }  
    },
    computed:{
        personList(){
            return this.$store.state.personList
        },
        sum(){
            return this.$store.state.sum
        }
    },
    methods:{
        add(){
          const   personObj = {id:nanoid(),name:this.name}
          this.$store.commit("ADD_PERSON",personObj)
          this.name = ''
        }
    }
    
}
</script>

<style>
#sum {
    color: red;
}
</style>