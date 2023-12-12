<!--
 * @Description: 
 * @Author: Rabbiter
 * @Date: 2023-03-11 13:37:23
-->
<template>
    <div class="user-table">
        <el-table :data="tableData" stripe style="width: 100%">
            <el-table-column prop="id" label="房间id"> </el-table-column>
            <el-table-column prop="number" label="房间号"> </el-table-column>
            <el-table-column prop="type" label="房间类型"> </el-table-column>
            <el-table-column prop="state" label="房间状态"> </el-table-column>
            <el-table-column prop="maxPeople" label="最大容纳人数">
            </el-table-column>
            <el-table-column prop="introduce" label="客房简介">
            </el-table-column>
            <el-table-column label="操作" width="140" fixed="right" >
                <template slot-scope="scope">
                    <el-button
                        type="danger"
                        @click="deleteRoom(scope.row.id)"
                        
                        style="font-size: 18px;"
                        >
                         删除</el-button
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
        deleteRoom(roomId) {
            // 删除房间
            this.$confirm("此操作将永久删除该文件, 是否继续?", "提示", {
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                type: "warning",
            })
                .then(() => {
                    this.axios
                        .post(
                            "http://localhost:9151/admin/deleteRoom?roomId=" +
                                roomId
                        )
                        .then((res) => {
                            this.$message({
                                type: "success",
                                message: "删除成功",
                            });
                            this.listRooms();
                        })
                        .catch((res) => {
                            this.$message({
                                type: "error",
                                message: "删除失败",
                            });
                        });
                })
                .catch(() => {
                    this.$message({
                        type: "info",
                        message: "已取消删除",
                    });
                });
        },
        listRooms() {
            this.axios
                .get("http://localhost:9151/admin/listRooms")
                .then((res) => {
                    // console.log(res.data.data);
                    this.tableData = res.data.data;
                    for (var i = 0; i < this.tableData.length; ++i) {
                        // 房间状态
                        if (this.tableData[i].state == 0) {
                            this.tableData[i].state = "空闲";
                        } else if (this.tableData[i].state == 1) {
                            this.tableData[i].state = "已入住";
                        }

                        // 房间类型
                        switch (this.tableData[i].type) {
                            case 1:
                                this.tableData[i].type = "单人房";
                                break;
                            case 2:
                                this.tableData[i].type = "双人房";
                                break;
                            case 3:
                                this.tableData[i].type = "三人房";
                                break;
                            case 4:
                                this.tableData[i].type = "大床房";
                                break;
                            case 5:
                                this.tableData[i].type = "豪华套房";
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
        this.listRooms();
    },
};
</script>

<style>
.user-table {
    margin: 2rem;
}
</style>
