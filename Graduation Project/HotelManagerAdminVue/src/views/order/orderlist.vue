<!--
 * @Description: 
 * @Author: Rabbiter
 * @Date: 2023-03-11 13:37:23
-->
<template>
    <div class="user-table">
        <el-table :data="tableData" stripe style="width: 100%">
            <el-table-column prop="id" label="id"> </el-table-column>
            <el-table-column prop="userId" label="用户id"> </el-table-column>
            <el-table-column prop="roomId" label="房间id"> </el-table-column>
            <el-table-column prop="createTime" label="下单时间">
            </el-table-column>
            <el-table-column prop="inTime" label="入住时间"> </el-table-column>
            <el-table-column prop="leaveTime" label="离店时间">
            </el-table-column>
            <el-table-column prop="realPrice" label="总计价格">
            </el-table-column>
            <el-table-column prop="realPeople" label="入住人数">
            </el-table-column>
            <el-table-column label="发票">
                <template slot-scope="scope">
                    <span v-if="scope.row.fapiao == 1">需要</span>
                    <span v-if="scope.row.fapiao == 0">不需要</span>
                </template>
            </el-table-column>
            <el-table-column prop="flag" label="受理状态"> </el-table-column>
            <el-table-column label="操作" width="250" fixed="right">
                <template slot-scope="scope">
                    <el-button
                        type="success"
                        @click="accept(scope.row.id)"
                        
                        style="font-size: 18px;"
                        >
                         接受</el-button
                    >
                    <el-button
                        type="danger"
                        @click="cancel(scope.row.id)"
                        
                        style="font-size: 18px;"
                        >
                         取消</el-button
                    >
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
export default {
    data() {
        return {
            tableData: [],
        };
    },
    methods: {
        accept(orderId) {
            // 接受订单
            this.$confirm("确定接受该订单？", "提示", {
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                type: "success",
            })
                .then(() => {
                    this.axios
                        .post(
                            "http://localhost:9151/admin/handle?orderId=" +
                                orderId
                        )
                        .then((res) => {
                            this.$message({
                                type: "success",
                                message: "接受订单成功",
                            });
                            this.listOrders();
                        })
                        .catch((res) => {
                            this.$message({
                                type: "error",
                                message: "接受订单失败",
                            });
                        });
                })
                .catch(() => {
                    this.$message({
                        type: "info",
                        message: "已取消操作",
                    });
                });
        },
        cancel(orderId) {
            // 取消订单
            this.$confirm("确定取消该订单？", "提示", {
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                type: "error",
            })
                .then(() => {
                    this.axios
                        .post(
                            "http://localhost:9151/admin/unsubscribe?orderId=" +
                                orderId
                        )
                        .then((res) => {
                            this.$message({
                                type: "info",
                                message: "取消订单成功",
                            });
                            this.listOrders();
                        })
                        .catch((res) => {
                            this.$message({
                                type: "info",
                                message: "取消订单失败",
                            });
                        });
                    this.listOrders();
                })
                .catch(() => {
                    this.$message({
                        type: "info",
                        message: "已取消操作",
                    });
                });
        },
        listOrders() {
            this.axios
                .get("http://localhost:9151/admin/listOrders?orderFlags=0")
                .then((res) => {
                    console.log(res.data.data);
                    this.tableData = res.data.data;
                    for (var i = 0; i < this.tableData.length; ++i) {
                        switch (this.tableData[i].flag) {
                            case 0:
                                this.tableData[i].flag = "未处理";
                                break;
                            case 1:
                                this.tableData[i].flag = "办理入住";
                                break;
                            case 2:
                                this.tableData[i].flag = "退订";
                                break;
                            case 3:
                                this.tableData[i].flag = "订单完成";
                                break;
                        }
                    }
                })
                .catch((res) => {
                    console.log("err: " + res);
                });
        },
    },
    mounted() {
        this.listOrders();
    },
};
</script>

<style>
.user-table {
    margin: 2rem;
}
</style>
