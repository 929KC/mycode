<template>
    <div class="message">
        <el-dialog title="新增用户" :visible.sync="dialogVisible" width="50%" :before-close="handleClose">
            <el-form ref="form" :model="form" :rules="rules" label-width="80px" :inline="true">
                <el-form-item label="姓名" prop="name">
                    <el-input v-model="form.name" placeholder="请输入姓名:"></el-input>
                </el-form-item>
                <el-form-item label="年龄" prop="age">
                    <el-input v-model="form.age" placeholder="请输入年龄:"></el-input>
                </el-form-item>
                <el-form-item label="性别" prop="sex">
                    <el-select v-model="form.sex" placeholder="请选择">
                        <el-option label="男" :value="1"></el-option>
                        <el-option label="女" :value="0"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="出生日期" prop="birth">
                    <el-date-picker v-model="form.birth" type="date" placeholder="选择日期" value-format="yyyy-MM-DD">
                    </el-date-picker>
                </el-form-item>
                <el-form-item label="地址" prop="addr">
                    <el-input v-model="form.addr" placeholder="请输入地址:"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = cancle()">取 消</el-button>
                <el-button type="primary" @click="dialogVisible = submit()">确 定</el-button>
            </span>
        </el-dialog>
        <div class="mangge-header">
            <el-button type="primary" @click="handAdd()">
                +新增
            </el-button>
            
        </div>
        <el-table :data="tableData" style="width: 100%" height="90%">
            <el-table-column prop="name" label="姓名">
            </el-table-column>
            <el-table-column prop="sex" label="性别">
                <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.sex == 1 ? "男" : "女" }}</span>
                </template>
            </el-table-column>
            <el-table-column prop="age" label="年龄">
            </el-table-column>
            <el-table-column prop="birth" label="出生日期">
            </el-table-column>
            <el-table-column prop="addr" label="地址">
            </el-table-column>
            <el-table-column prop="addr" label="操作">
                <template slot-scope="scope">
                    <el-button size="mini" @click="handleEdit(scope.row)">编辑</el-button>
                    <el-button type="danger" @click="handleDelete(scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>

import { getUser, addUser, editUser, delUser } from "../api/"
export default {
    name: "User",
    data() {
        return {
            dialogVisible: false,
            form: {
                name: "",
                age: "",
                sex: "",
                birth: "",
                addr: ""
            },
            rules: {
                name: [{
                    required: true, message: "请输入你的姓名:"
                }],
                age: [{
                    required: true, message: "请输入你的年龄:"
                }],
                sex: [{
                    required: true, message: "请输入你的性别:"
                }],
                birth: [{
                    required: true, message: "请输入你的出生日期:"
                }],
                addr: [{
                    required: true, message: "请输入你的地址:"
                }]
            },
            tableData: [],
            modelType: 0
        };
    }, methods: {
        submit() {
            this.$refs.form.validate((flag) => {
                if (flag) {
                    if (this.modelType === 0) {
                        addUser(this.form).then(() => {
                            this.getList();
                        })
                    } else {
                        editUser(this.form).then(() => {
                            this.getList();
                        })
                    }
                    this.$refs.form.resetFields();
                    this.dialogVisible = false;
                }
            })
        },
        handleClose() {
            this.$refs.form.resetFields();
            this.dialogVisible = false;
        }, cancle() {
            this.handleClose();
        }, handleEdit(row) {
            this.modelType = 1;
            this.dialogVisible = true;
            this.form = JSON.parse(JSON.stringify(row));
        }, handleDelete(row) {
            this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                delUser({ id: row.id }).then(() => {
                    this.$message({
                        type: 'success',
                        message: '删除成功!'
                    });
                    this.getList();
                })
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除'
                });
            });
        }, getList() {
            getUser().then(({ data }) => {
                this.tableData = data.list;
            })
        }, handAdd() {
            this.modelType = 0;
            this.dialogVisible = true;
        }
    },
    mounted() {
        this.getList();
    },
}
</script>

<style  lang="less">
.message {
    height: 90%;
}
</style>