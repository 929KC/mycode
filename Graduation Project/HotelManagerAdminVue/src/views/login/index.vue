<!--
 * @Description:
 * @Author: Rabbiter
 * @Date: 2023-03-11 13:37:23
-->
<template>
    <div class="login-container">
        <el-card class="box-card">
            <div class="text item">
                <el-form
                    ref="loginForm"
                    :model="loginForm"
                    class="login-form"
                    auto-complete="on"
                    label-position="left"
                >
                    <div class="title-container">
                        <h2 class="title">酒店管理系统</h2>
                    </div>

                    <el-form-item prop="username">

                      <i class="fa-solid fa-user"
                         style="font-size: 26px; margin-left: 10px"></i>
                        <el-input
                            id="account"
                            ref="username"
                            v-model="loginForm.username"
                            name="username"
                            type="text"
                            tabindex="1"
                        />
                    </el-form-item>

                    <el-form-item prop="password">
                      <i class="fa-solid fa-lock"
                         style="font-size: 26px; margin: 0 0 -5px 10px"></i>
                        <el-input
                            id="psw"
                            :key="passwordType"
                            ref="password"
                            v-model="loginForm.password"
                            :type="passwordType"
                            name="password"
                            tabindex="2"
                            @keyup.enter.native="handleLogin"
                        />
                        <span class="show-pwd" @click="showPwd">
                            <svg-icon
                                :icon-class="
                                    passwordType === 'password'
                                        ? 'eye'
                                        : 'eye-open'
                                "
                            />
                        </span>
                    </el-form-item>

                    <el-button
                        id="login_btn"
                        type="primary"
                        style="
                            width: 100%;
                            margin-bottom: 30px;
                            font-size: 22px;
                        "
                        @click.native.prevent="handleLogin"
                    >
                        登 录</el-button
                    >
                </el-form>
            </div>

        </el-card>
    </div>
</template>

<script>
import '@fortawesome/fontawesome-free/css/all.css';

// 引入需要的图标集样式，比如 solid 图标集
import '@fortawesome/fontawesome-free/css/solid.css';
import md5 from "js-md5";
export default {
    name: "Login",
    data() {
        return {
            loginForm: {
                username: "",
                password: "",
            },
            loading: false,
            passwordType: "password",
            redirect: undefined,
        };
    },
    watch: {
        $route: {
            handler: function (route) {
                this.redirect = route.query && route.query.redirect;
            },
            immediate: true,
        },
    },
    methods: {
        showPwd() {
            if (this.passwordType === "password") {
                this.passwordType = "";
            } else {
                this.passwordType = "password";
            }
            this.$nextTick(() => {
                this.$refs.password.focus();
            });
        },
        handleLogin() {
            let that = this;
            this.loading = true;
            // 可自定义登录时的逻辑处理
            this.req({
                url: "http://localhost:9151/admin/login",
                data: {
                    userName: that.loginForm.username,
                    password: that.loginForm.password,
                },
                method: "POST",
            }).then(
                (res) => {
                    localStorage.setItem("hasLogin", true);
                    localStorage.setItem("token", res.data.token);
                    localStorage.setItem("userInfo", JSON.stringify(res.data));
                    this.$router.push({
                        path: "/",
                    });
                },
                (e) => {
                    this.passwordError = true;
                    this.loading = false;
                    if (e.response.data == undefined) {
                        this.$message({
                            showClose: true,
                            message: e,
                            type: "error",
                            duration: 0,
                        });
                    } else {
                        this.$message({
                            showClose: true,
                            message: e.response.data,
                            type: "error",
                            duration: 0,
                        });
                    }
                }
            );
        },
    },
};
</script>

<style lang="scss">
/* 修复input 背景不协调 和光标变色 */
/* Detail see https://github.com/PanJiaChen/vue-element-admin/pull/927 */
$bg: #283443;
$light_gray: #303133;
$cursor: #303133;

.info {
    // position: fixed;
    margin-bottom: 10px;
    width: 100%;
    text-align: center;
    color: $bg;
}

@supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
    .login-container .el-input input {
        color: $cursor;
    }
}

/* reset element-ui css */
.login-container {
    .el-input {
        display: inline-block;
        height: 47px;
        width: 85%;

        input {
            background: transparent;
            border: 0px;
            -webkit-appearance: none;
            border-radius: 0px;
            padding: 12px 5px 12px 15px;
            color: $light_gray;
            height: 47px;
            caret-color: $cursor;

            &:-webkit-autofill {
                box-shadow: 0 0 0px 1000px $bg inset !important;
                -webkit-text-fill-color: $cursor !important;
            }
        }
    }

    .el-form-item {
        border: 1px solid rgba(255, 255, 255, 0.1);
        background: rgba(0, 0, 0, 0.1);
        border-radius: 5px;
        color: #454545;
    }
}
</style>

<style lang="scss" scoped>
$bg: #2d3a4b;
$dark_gray: #525d63;
$light_gray: #eee;

.login-container {
    height: 100%;
    background: url(../../assets/admin-bg.jpg);
    background-size: 100%;
    overflow: hidden;
    background-repeat: no-repeat;

    .login-form {
        position: relative;
        width: 520px;
        max-width: 100%;
        // padding: 160px 35px 0;
        margin: 0 auto;
        overflow: hidden;
    }

    .tips {
        font-size: 14px;
        color: #fff;
        margin-bottom: 10px;

        span {
            &:first-of-type {
                margin-right: 16px;
            }
        }
    }

    .svg-container {
        padding: 6px 5px 6px 15px;
        color: $dark_gray;
        vertical-align: middle;
        width: 30px;
        display: inline-block;
    }

    .title-container {
        position: relative;

        .title {
            font-size: 26px;
            color: $bg;
            margin: 0px auto 40px auto;
            text-align: center;
            font-weight: bold;
        }
    }

    .show-pwd {
        position: absolute;
        right: 10px;
        top: 7px;
        font-size: 16px;
        color: $dark_gray;
        cursor: pointer;
        user-select: none;
    }
}
</style>


<style scoped="scoped">
.text {
    font-size: 1rem;
}

.item {
    padding: 18px 0;
}

.box-card {
    width: 480px;
    margin: 20vh auto;
    /*    background-color: #2d3a4b;
    border: 1px solid #2d3a4b; */
    background-color: rgba(255, 255, 255, 0.8);
}

.login-container .el-input input:-webkit-autofill {
    -webkit-box-shadow: none !important;
    box-shadow: none !important;
    -webkit-text-fill-color: #ffffff !important;
}

#app {
    overflow: hidden !important;
}
</style>
