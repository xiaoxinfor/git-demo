<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <script src="js/vue.js" type="text/javascript" charset="utf-8"></script>
    <!-- 引入样式 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <!-- 引入组件库 -->
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <style type="text/css">
        * {
            margin: 0px;
            padding: 0px;
        }
        .el-card {
            width: 500px;
            margin: 300px auto;
        }
        .el-form-item {
            width: 350px;
        }
        /*#app {*/
            /*width: 300px;*/
            /*margin: 0 auto;*/
            /*margin-top: 60px;*/
        /*}*/
    </style>
</head>
<body>

<div id="app">
    <el-card class="box-card">
        <div slot="header" class="clearfix">
            <span>欢迎登录简易留言板</span>
            <span style="color: red; margin-left: 200px">${message}</span>
        </div>
        <!-- rules：验证规则  prop：参与验证-->
        <el-form :model="form" :rules="rules" label-width="80px" ref="from">
            <el-form-item label="姓名" prop="name">
                <el-input v-model="form.name" suffix-icon="el-icon-user"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="pwd">
                <el-input v-model="form.pwd" suffix-icon="el-icon-unlock"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit('from')">登录</el-button>
                <el-button @click="ret('from')">重置</el-button>
            </el-form-item>
        </el-form>
    </el-card>
</div>


<script>
    new Vue({
        el: "#app",
        data() {
            return {
                form: {
                    name: "",
                    pwd: "",
                },
                // 验证规则
                rules: {
                    name: [
                        {required: true, message: "请输入姓名", trigger: "blur"}
                    ],
                    pwd: [
                        {required: true, message: "请输入密码", trigger: "blur"}
                    ]
                }
            }
        },
        methods: {
            onSubmit(fromName) {
                this.$refs[fromName].validate((valid) => {
                    if (valid) {//验证通过,提交数据
                        axios.get("/user.do?name=" + this.form.name + "&pwd=" + this.form.pwd).then(response => {
                            var result = response.data;
                            console.log(result)
                            let message = "登录状态";
                            if (result == true) {
                                message = "登录成功";
                                this.$message({
                                    message: message,
                                    type: 'success'
                                });
                                setTimeout(function () {
                                    location.href = "deliver.jsp";
                                }, 2000);
                            } else {
                                if (result == false) {
                                    message = "无此账号";
                                } else {
                                    message = "密码错误";
                                }
                                this.$message.error(message);
                            }
                        })
                    } else {
                        return false
                    }
                })
            },
            ret(fromName) {
                this.$refs[fromName].resetFields();
            }
        }
    })
</script>
</body>
</html>
