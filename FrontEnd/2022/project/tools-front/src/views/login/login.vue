<template>
  <div class="login-container">
    <el-form ref="loginForm" :model="loginForm" :rules="loginRules" class = "login-form" label-position="left" auto-complete="on">
      <div class="title-container">
        <h3 class="title">tools</h3>
      </div>

      <el-form-item prop="username">
        <span class="svg-container">
          <svg-icon icon-class="user"/>
        </span>
        <el-input
          v-model="loginForm.username"
          placeholder="账号"
          name="username"
          type="text"
          auto-complete="on"
          required
        ></el-input>
      </el-form-item>

      <el-form-item prop="password">
         <span class="svg-container">
          <svg-icon icon-class="password"/>
        </span>
        <el-input
          v-model="loginForm.password"
          placeholder="密码"
          name="password"
          :type="passwordType"
          auto-complete="on"
          @keyup.enter.native="handleLogin"
        >
        </el-input>
        <span class="show-pwd" @click="showPwd">
          <svg-icon icon-class="eye"/>
        </span>
      </el-form-item>
      <el-button :loading="loading" type="primary" style="width:100%;margin-bottom:30px;" @click.native.prevent="handleLogin">
        登录
      </el-button>
    </el-form>
  </div>
</template>

<script>
  export default {
    name: 'login',
    data() {
      const validatePassword = (rule, value, callback) => {
        if (value && value.length < 6) {
          callback(new Error('密码不能少于6个字符！'))
        } else {
          callback()
        }
      }
      return {
        loginForm: {
          username: '',
          password: ''
        },
        loginRules: {
          password: [{required: true, trigger: 'blur', validator: validatePassword}]
        },
        passwordType: 'password',
        loading: false,
        redirect: undefined
      }
    },

    methods: {
      handleLogin() {
        // this.$refs.loginForm.validate(valid => {
        //   if (valid) {
        //     this.loading = true
        //     this.$store.dispatch('Login', this.loginForm).then(() => {
        //       this.loading = false
        //       console.log("ss22: " + this.$store.getters.message)
        //       console.log("ss11: " + this.$store.getters.code)
        //       if (this.$store.getters.code === 20000) {
        //         this.$router.push({path: this.redirect || '/'})
        //       } else {
        //         console.log("ss: " + this.$store.getters.message)
        //         this.$notify({
        //           title: '错误',
        //           message: this.$store.getters.message,
        //           type: 'error',
        //           duration: 2000
        //         })
        //       }
        //     }).catch(() => {
        //       this.loading = true
        //     })
        //   } else {
        //     return false
        //   }
        // })
      }
    }
  }
</script>

<style >



</style>

<style ref="stylesheet/scss" scoped>
.login-container {
  position: fixed;
  height: 100%;
  width: 100%;
  background-image: url("https://api.dujin.org/bing/1920.php");
  background-size: 100% 100%;
}
.login-container  .login-form {
    position: absolute;
    left: 0;
    right: 0;
    width: 520px;
    max-width: 100%;
    padding: 35px 35px 15px 35px;
    margin: 120px auto;
    background-color:#2d3a4b;
  }
  .title{
    background-color:  #2d3a4b;
    font-weight: bold;
    color: black;
    font-size:26px;
    text-align: center;
    margin: 0px auto 40px auto;
  }
  .title-container {
    position: relative;
  }
</style>
