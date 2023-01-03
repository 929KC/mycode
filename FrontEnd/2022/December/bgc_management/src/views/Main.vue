<template>
    <div>
        <el-container>
            <el-aside width="auto">
                <CommonAside />
            </el-aside>
            <el-container>
                <el-header>
                    <CommonHeader />
                </el-header>
                <Tag></Tag>
                <el-main><router-view></router-view></el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
import CommonAside from '../components/CommonAside.vue';
import CommonHeader from '../components/CommonHeader.vue';
import Tag from '../components/Tag.vue';
export default {
    name: "Main",
    components: {
        CommonAside,
        CommonHeader,
        Tag
    }
};
</script>

<style>

</style>