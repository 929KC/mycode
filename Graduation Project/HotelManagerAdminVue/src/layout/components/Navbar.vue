<template>
    <div class="navbar">
        <hamburger
            :is-active="sidebar.opened"
            class="hamburger-container"
            @toggleClick="toggleSideBar"
        />

        <breadcrumb class="breadcrumb-container" />

        <div class="right-menu">
<!--            <el-avatar-->
<!--                shape="square"-->
<!--                :size="35"-->
<!--                :src="require('@/assets/avatar.jpg')"-->
<!--                style="margin: 0 5px -8px 0"-->
<!--            ></el-avatar>-->
          <img src="http://120.24.91.11:9001/myimages/2023-img/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20231210200159.jpg" alt=""
               style="margin: 0 5px -8px 0"
               width="40px"
               height="40px"
              >
            <el-dropdown

                style="cursor: pointer; font-size: 22px; padding-bottom: 15px"
            >
                <span class="el-dropdown-link">
                    {{adminName}}<i class="el-icon-arrow-down el-icon--right"></i>
                </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item @click.native="logout"
                        >退出登录</el-dropdown-item
                    >
                </el-dropdown-menu>
            </el-dropdown>
        </div>
    </div>
</template>

<script>
import { mapGetters } from "vuex";
import Breadcrumb from "@/components/Breadcrumb";
import Hamburger from "@/components/Hamburger";

export default {
    components: {
        Breadcrumb,
        Hamburger,
    },
    computed: {
        ...mapGetters(["sidebar", "avatar"]),
    },
    methods: {
        toggleSideBar() {
            this.$store.dispatch("app/toggleSideBar");
        },
        async logout() {
            this.axios
                .get("http://localhost:9151/admin/logout")
                .then((res) => {
                    localStorage.removeItem("hasLogin");
                    this.$router.push(
                        `/login?redirect=${this.$route.fullPath}`
                    );
                })
                .catch((res) => {
                    console.log("err: " + res);
                });
        },
    },
    mounted() {
      console.log()
    },
    data() {
      return {
        adminName: JSON.parse(localStorage.getItem('userInfo')).admin_name
      }
    }
};
</script>

<style lang="scss" scoped>
.navbar {
    height: 50px;
    overflow: hidden;
    position: relative;
    background: #fff;
    box-shadow: 0 1px 4px rgba(0, 21, 41, 0.08);

    .hamburger-container {
        line-height: 46px;
        height: 100%;
        float: left;
        cursor: pointer;
        transition: background 0.3s;
        -webkit-tap-highlight-color: transparent;

        &:hover {
            background: rgba(0, 0, 0, 0.025);
        }
    }

    .breadcrumb-container {
        float: left;
    }

    .right-menu {
        float: right;
        height: 100%;
        line-height: 50px;
        margin-right: 20px;

        &:focus {
            outline: none;
        }

        .right-menu-item {
            display: inline-block;
            padding: 0 8px;
            height: 100%;
            font-size: 18px;
            color: #5a5e66;
            vertical-align: text-bottom;

            &.hover-effect {
                cursor: pointer;
                transition: background 0.3s;

                &:hover {
                    background: rgba(0, 0, 0, 0.025);
                }
            }
        }

        .avatar-container {
            margin-right: 30px;

            .avatar-wrapper {
                margin-top: 5px;
                position: relative;

                .user-avatar {
                    cursor: pointer;
                    width: 40px;
                    height: 40px;
                    border-radius: 10px;
                }

                .el-icon-caret-bottom {
                    cursor: pointer;
                    position: absolute;
                    right: -20px;
                    top: 25px;
                    font-size: 12px;
                }
            }
        }
    }
}
</style>
