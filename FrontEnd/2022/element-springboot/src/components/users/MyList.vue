<template>
  <div>
    <el-table
        :height="400"
        :data="tableData.filter(data => !search || data.name.toLowerCase().includes(search.toLowerCase()))"
        style="width: 100%">
      <el-table-column label="编号" width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.id }}</span>
        </template>
      </el-table-column>
      <el-table-column
          label="日期"
          width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.dir }}</span>
        </template>
      </el-table-column>

      <el-table-column
          label="姓名"
          width="180">
        <template slot-scope="scope">
          <el-popover trigger="hover" placement="top">
            <p>姓名: {{ scope.row.name }}</p>
            <p>住址: {{ scope.row.address }}</p>
            <div slot="reference" class="name-wrapper">
              <el-tag size="medium">{{ scope.row.name }}</el-tag>
            </div>
          </el-popover>
        </template>
      </el-table-column>

      <el-table-column
          label="性别"
          width="180" prop="sex">
      </el-table-column>

      <el-table-column
          width="180"
          label="搜索">
        <template slot="header">
          <el-input
              v-model="search"
              size="mini"
              placeholder="输入关键字搜索"/>
        </template>
        <template slot-scope="scope">
          <el-button
              size="mini"
              @click="handleEdit(scope.$index, scope.row)">编辑
          </el-button>
          <el-popconfirm
              @confirm="handleDelete(scope.$index, scope.row)"
              confirm-button-text='好的'
              cancel-button-text='不用了'
              icon="el-icon-info"
              icon-color="red"
              title="该用户确定删除吗？"
          >
            <el-button slot="reference"
                       size="mini"
                       type="danger"
            >删除
            </el-button>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>

    <el-row>
      <el-col :span="12" :offset="12">
        <div class="block">
          <el-pagination
              background
              prev-text="上一页"
              next-text="下一页"
              :page-size="size"
              :page-sizes="[2,4,6,8,10]"
              style="margin-top: 10px"
              layout="prev, pager, next,jumper,total,sizes"
              :total="total"
              @size-change="findSize"
              @current-change="findPage"
              :current-page="pageNow"
          >
          </el-pagination>
        </div>
      </el-col>
    </el-row>


    <el-button type="success" size="mini" style="margin:10px 0px" @click="showButton()">添加</el-button>

    <template>
      <div>
        <div style="margin-top: 20px; height: 200px;">
          <el-collapse-transition>
            <div v-show="show">
              <div class="transition-box">
                <el-form :hide-required-asterisk="false" ref="userForm" :rules="rules" :model="form" label-width="80px"
                         label-suffix=":">
                  <el-form-item label="姓名" prop="name">
                    <el-input v-model="form.name"></el-input>
                  </el-form-item>
                  <el-form-item label="生日" prop="dir">
                    <el-col :span="11">
                      <el-date-picker type="date" placeholder="选择日期"
                                      v-model="form.dir"
                                      style="width: 100%;"
                                      value-format="yyyy-MM-dd"
                      ></el-date-picker>
                    </el-col>
                  </el-form-item>
                  <el-form-item label="性别" prop="sex">
                    <el-radio-group v-model="form.sex">
                      <el-radio label="男"></el-radio>
                      <el-radio label="女"></el-radio>
                    </el-radio-group>
                  </el-form-item>
                  <el-form-item label="详细地址" prop="address">
                    <el-input type="textarea" v-model="form.address"></el-input>
                  </el-form-item>
                  <el-form-item>
                    <el-button type="primary" @click="onSubmit('userForm')">保存用户</el-button>
                    <el-button @click="showButton">重置</el-button>
                  </el-form-item>
                </el-form>
              </div>
            </div>
          </el-collapse-transition>
        </div>
      </div>
    </template>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "MyList",
  data() {
    return {
      size:4,
      pageNow:1,
      total:0,
      tableData: [],
      search: "",
      show: false,
      form: {
        name: '',
        dir: "",
        sex: '男',
        address: ""
      },
      rules: {
        name: [
          {required: true, message: '请输入姓名', trigger: 'blur'},
          {min: 2, max: 5, message: '长度在 2 到 5 个字符', trigger: 'blur'}
        ],
        dir: [
          {type: 'date', required: true, message: '请选择日期', trigger: 'change'}
        ],
        sex: [
          {type: 'array', required: true, message: '请至少选择一个性别', trigger: 'change'}
        ],
        address: [
          {required: true, message: '请填写详细地址', trigger: 'blur'}
        ]
      }
    };
  },
  methods: {
    findSize(size){
       this.size  = size
      this.updateAndAddDate(this.page,size)
      },
    findPage(page){
        this.page = page
        this.updateAndAddDate(page,this.size)
      },
    showButton() {
      this.show = true
      this.form = {sex: "男"}
    },
    handleEdit(index, row) {
      console.log(index, row);
      this.show = true
      this.form = row
    },
    handleDelete(index, row) {
      console.log(index, row);
      axios.get("http://localhost:8989/user/delete?id=" + row.id).then(res => {
        if (res.data.flag) {
          this.$message({
            message: res.data.message,
            type: 'success'
          })
          this.updateAndAddDate()
        } else {
          this.$message({
            message: '警告哦，这是一条警告消息',
            type: 'warning'
          });
        }
      })
    },
    onSubmit(userForm) {
      this.$refs[userForm].validate((valid) => {
        if (valid) {
          axios.post("http://localhost:8989/user/addOrUpdate", this.form).then(res => {
            console.log(res.data)
            if (res.data.flag) {
              this.$message({
                message: '恭喜你，这是一条成功消息',
                type: 'success'
              })
              this.form = {sex: "男"}
              this.show = false
              this.updateAndAddDate()
              //this.form={sex:"男"}
            } else {
              this.$message({
                message: '警告哦，这是一条警告消息',
                type: 'warning'
              });
            }
          })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    updateAndAddDate(page,size) {
      page = page?page:this.pageNow
      size = size?size:this.size
      axios.get("http://localhost:8989/user/findByPage?pageNow="+page+"&pageSize"+size).then(res => {
        this.tableData = res.data.users
        this.total = res.data.total
        // console.log(res.data)
      })
    }

  },
  created() {
    this.updateAndAddDate()
  }
}
</script>

<style scoped>
.transition-box {
  margin-bottom: 10px;
  width: 100%;
  height: 600px;
  border-radius: 4px;
  text-left: center;
  padding: 40px 20px;
  box-sizing: border-box;
  margin-right: 20px;
}
</style>