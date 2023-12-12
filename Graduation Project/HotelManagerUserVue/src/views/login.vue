<template>
    <div>
        <el-container class="wrapper">
            <el-main class="section text-center">
                <div class="login-bg"></div>
                <el-card class="box-card login-card">
                    <div class="text item">
                        <p class="login-title">
                            <i
                                class="iconfont icon-r-yes"
                                style="font-size: 32px"
                            ></i>
                            酒店预订系统
                        </p>
                        <el-form
                            :model="login"
                            status-icon
                            ref="login"
                            label-width="80px"
                        >
                            <el-form-item label="账户邮箱" prop="email">
                                <el-input
                                    type="text"
                                    v-model="login.email"
                                    autocomplete="off"
                                ></el-input>
                            </el-form-item>
                            <el-form-item label="密码" prop="pass">
                                <el-input
                                    type="password"
                                    v-model="login.password"
                                    autocomplete="off"
                                ></el-input>
                            </el-form-item>
                        </el-form>
                    </div>
                </el-card>
                <el-button
                    circle
                    :type="btnType"
                    @click="loginBtn"
                    class="loginbtn"
                    :disabled="disabled"
                >
                    <i :class="iconstyle" style="font-size: 54px"></i>
                </el-button>
                <div class="register">
                    <p>
                        <router-link to="/register" style="color: black"
                            >注册账号</router-link
                        >
                    </p>
                </div>
            </el-main>
        </el-container>
        <el-footer class="footer text-center">
            <copyright></copyright>
        </el-footer>
    </div>
</template>

<script>
import copyright from "@/components/copyright.vue";
import store from "./../store";
export default {
    data() {
        return {
            login: {
                email: "",
                password: "",
            },
            iconstyle: "iconfont icon-r-right",
            disabled: false,
            btnType: "primary",
            isRealLogin: true,
        };
    },
    components: {
        copyright,
    },
    methods: {
        loginBtn() {
            if (
                this.login.email.trim() == "" ||
                this.login.password.trim() == ""
            ) {
                this.$message({
                    message: "账号或密码不能为空",
                    type: "error",
                });
                return;
            }
            this.iconstyle = "el-icon-loading";
            this.disabled = true;

            this.axios
                .post("http://localhost:9151/user/login", {
                    email: this.login.email,
                    password: this.login.password,
                })
                .then((res) => {
                    if (res.data.code == 200) {
                        this.iconstyle = "el-icon-check";
                        this.btnType = "success";
                        this.$message({
                            message: "登录成功，正在跳转",
                            type: "success",
                        });
                        setTimeout(() => {
                            this.disabled = false;
                            this.$store.commit("setFind");
                            this.$router.push("/findroom");
                        }, 2000);
                    } else {
                        this.iconstyle = "el-icon-close";
                        this.btnType = "danger";
                        this.$message({
                            message: "登录失败，账号或密码错误",
                            type: "error",
                        });
                        setTimeout(() => {
                            this.disabled = false;
                            this.iconstyle = "iconfont icon-r-right";
                            this.btnType = "primary";
                        }, 2000);
                    }
                })
                .catch((e) => {
                    this.iconstyle = "el-icon-close";
                    this.btnType = "danger";
                    setTimeout(() => {
                        this.disabled = false;
                        this.iconstyle = "iconfont icon-r-right";
                        this.btnType = "primary";
                    }, 2000);

                    if (e.response == undefined || e.response.data == undefined) {
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
                });
        },
        nologinBtn() {
            this.$store.commit("setFind");
            this.$router.push("/findroom");
        },
    },
};
</script>

<style scoped="scoped">
.login-bg {
    background: rgb(65, 105, 225);
    height: 30vh;
    background-size: 100%;
    border: 0px solid transparent;
    border-bottom-left-radius: 10px;
    border-bottom-right-radius: 10px;
}

.text {
    font-size: 14px;
}

.item {
    /* padding: 18px 0; */
}

.login-card {
    margin: -7rem 1rem 1rem 1rem;
}

.login-title {
    font-size: 2rem;
    font-weight: lighter;
    margin-top: 1rem;
}

.wrapper {
    min-height: 90vh;
}

.el-main {
    max-height: 90vh;
}

#app {
    overflow: hidden;
}

.loginbtn {
    width: 7rem;
    height: 7rem;
    font-size: 1.5rem;
    margin-top: 2rem;
}

.register {
    margin-top: 5vh;
}

.register a,
.register div {
    color: #409eff;
}

.register p {
    margin: 0.5rem;
}
</style>
