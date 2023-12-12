<template>
    <el-row>
        <el-col :span="8" :offset="8">
            <div class="change-form">
                <div class="text item">
                    <p class="change-title">输入修改房间id</p>
                    <el-form
                        :model="change"
                        status-icon
                        ref="change"
                        label-width="80px"
                    >
                        <el-form-item label="id" prop="id">
                            <el-input
                                type="text"
                                v-model="change.id"
                            ></el-input>
                        </el-form-item>
                    </el-form>
                    <el-button type="primary" @click="queryBtn" class="mb-1" style="font-size: 18px;">
                        
                        查询
                    </el-button>
                    <p class="change-title">输入修改信息</p>
                    <el-form
                        :model="change"
                        status-icon
                        ref="change"
                        label-width="100px"
                    >
                        <el-form-item label="房间号" prop="number">
                            <el-input
                                type="text"
                                v-model="change.number"
                            ></el-input>
                        </el-form-item>

                        <el-form-item label="房间类型" prop="type">
                            <el-select
                                v-model="change.type"
                                placeholder="请选择"
                            >
                                <el-option :label="'单人房'" :value="1">
                                </el-option>
                                <el-option :label="'双人房'" :value="2">
                                </el-option>
                                <el-option :label="'三人房'" :value="3">
                                </el-option>
                                <el-option :label="'大床房'" :value="4">
                                </el-option>
                                <el-option :label="'豪华套房'" :value="5">
                                </el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="房间状态" prop="state">
                            <el-select
                                v-model="change.state"
                                placeholder="请选择"
                            >
                                <el-option :label="'空闲'" :value="0">
                                </el-option>
                                <el-option :label="'已入住'" :value="1">
                                </el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="最大容纳人数" prop="maxPeople">
                            <el-input
                                type="text"
                                v-model="change.maxPeople"
                            ></el-input>
                        </el-form-item>

                        <el-form-item label="客房详情" prop="introduce">
                            <!-- <el-input type="text" v-model="addnew.introduce"></el-input> -->
                            面积（m²）:
                            <el-input
                                type="text"
                                v-model="change.size"
                            ></el-input
                            ><br />
                            电脑:
                            <el-radio v-model="change.computer" label="有"
                                >有</el-radio
                            >
                            <el-radio v-model="change.computer" label="无"
                                >无</el-radio
                            ><br />
                            热水:
                            <el-radio v-model="change.hotWater" label="有"
                                >有</el-radio
                            >
                            <el-radio v-model="change.hotWater" label="无"
                                >无</el-radio
                            ><br />
                            WIFI:
                            <el-radio v-model="change.wifi" label="有"
                                >有</el-radio
                            >
                            <el-radio v-model="change.wifi" label="无"
                                >无</el-radio
                            ><br />
                            电视:
                            <el-radio v-model="change.tv" label="有"
                                >有</el-radio
                            >
                            <el-radio v-model="change.tv" label="无"
                                >无</el-radio
                            ><br />
                            早餐:
                            <el-radio v-model="change.breakfast" label="有"
                                >有</el-radio
                            >
                            <el-radio v-model="change.breakfast" label="无"
                                >无</el-radio
                            >
                        </el-form-item>
                    </el-form>
                    <el-button
                        type="success"
                        @click="changeBtn"
                        class="changebtn"
                        :disabled="disabled"
                        style="font-size: 18px"
                    >
                         确认修改
                    </el-button>
                </div>
            </div>
        </el-col>
        <el-dialog title="提示" :visible.sync="dialogVisible" width="30%">
            <span>{{ msgText }}</span>
            <span slot="footer" class="dialog-footer">
                <el-button type="primary" @click="dialogVisible = false"
                    >确定</el-button
                >
            </span>
        </el-dialog>
    </el-row>
</template>

<script>
export default {
    data() {
        return {
            change: {
                id: "",
                number: "",
                type: "",
                state: "",
                maxPeople: "",
                introduce: "",

                size: "",
                computer: "有",
                hotWater: "有",
                wifi: "有",
                tv: "有",
                breakfast: "有",
            },
            iconstyle: "el-icon-a-032",
            disabled: false,
            btnType: "primary",
            isRealchange: false,
            dialogVisible: false,
            msgText: "",
        };
    },
    components: {},
    methods: {
        queryBtn() {
            this.axios
                .post(
                    "http://localhost:9151/admin/roomDetail?roomId=" +
                        this.change.id
                )
                .then((res) => {
                    this.change.number = res.data.data.room.number;
                    this.change.type = res.data.data.type.id;
                    this.change.state = res.data.data.room.state;
                    this.change.maxPeople = res.data.data.room.maxPeople;

                    this.change.introduce = res.data.data.room.introduce;

                    var parms = this.change.introduce.split(",");
                    for (var i = 0; i < parms.length; ++i) {
                        // 填充房间参数详情
                        var values = parms[i].split(":");
                        switch (values[0]) {
                            case "面积":
                                this.change.size = values[1].replace("m²", "");
                                break;
                            case "电脑":
                                this.change.computer = values[1];
                                break;
                            case "热水":
                                this.change.hotWater = values[1];
                                break;
                            case "WIFI":
                                this.change.wifi = values[1];
                                break;
                            case "电视":
                                this.change.tv = values[1];
                                break;
                            case "早餐":
                                this.change.breakfast = values[1];
                                break;
                        }
                    }
                })
                .catch((res) => {
                    console.log("err:" + res);
                });
        },
        changeBtn() {
            if (this.change.number == "") {
                this.$message.error("请提供房间号");
                return;
            }
            if (this.change.type == "") {
                this.$message.error("请选择房间类型");
                return;
            }
            if (this.change.state === "") {
                this.$message.error("请选择房间状态");
                return;
            }
            if (this.change.maxPeople == "") {
                this.$message.error("请填写最大容纳人数");
                return;
            }
            if (this.change.size == "") {
                this.$message.error("请填写房间面积");
                return;
            }
            this.change.introduce =
                "面积:" +
                this.change.size +
                "m²,容纳:1-" +
                this.change.maxPeople +
                "人,电脑:" +
                this.change.computer +
                ",热水:" +
                this.change.hotWater +
                ",WIFI:" +
                this.change.wifi +
                ",电视:" +
                this.change.tv +
                ",早餐:" +
                this.change.breakfast;
            this.axios
                .post("http://localhost:9151/admin/updateRoom", this.change)
                .then((res) => {
                    if (res.data.code == "200") {
                        this.dialogVisible = true;
                        this.msgText = "信息修改成功。";
                    } else {
                        this.$message.error(res.data.data);
                    }
                })
                .catch((res) => {
                    this.dialogVisible = true;
                    this.msgText = "信息修改失败。";
                });
        },
    },
};
</script>

<style>
.change-form {
    margin: 2rem;
}
</style>
