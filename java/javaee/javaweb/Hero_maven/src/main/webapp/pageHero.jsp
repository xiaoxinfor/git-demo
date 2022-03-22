<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="js/vue.min.js" type="text/javascript" charset="utf-8"></script>
    <!-- 引入样式 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <!-- 引入组件库 -->
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <%-- 导入QS。js 文件--%>
    <script src="https://cdn.bootcdn.net/ajax/libs/qs/6.10.1/qs.js"></script>

    <style>
        .el-input {
            width: 250px;
        }

        .el-input-number__decrease {
            height: 23px;
            padding-top: 12px;
        }

        .el-input-number__increase {
            height: 23px;
            padding-top: 12px;
            left: 205px;
        }
    </style>
</head>
<body>
<div id="app">
    <el-form label-width="120px" :model="queryHeroInfo">

        <el-row>
            <el-col :span="5">
                <el-form-item label="英雄名称：">
                    <!-- 如果 elementUI 中表情元素的组件未绑定 v-model，那么这个表单元素不能输入内容 -->
                    <el-input v-model="queryHeroInfo.heroName" clearable >
                    </el-input>
                </el-form-item>
            </el-col>

            <el-col :span="5">
                <el-form-item label="上线时间：">
                    <el-date-picker v-model="queryHeroInfo.date" value-format="yyyy-MM-dd" type="daterange"
                                    range-separator="至" start-placeholder="开始日期"
                                    end-placeholder="结束日期">
                    </el-date-picker>
                </el-form-item>
            </el-col>

            <el-col :span="6" :offset="1">
                <el-button type="primary" plain @click="queryHeroCondition()">搜索</el-button>
            </el-col>
        </el-row>

    </el-form>

    <el-button @click="initSave()" type="success" plain>添加</el-button>

    <el-table :data="heroList" style="width: 50%">
        <el-table-column prop="heroName" label="英雄名称" width="180"></el-table-column>
        <el-table-column prop="heroTypeName" label="英雄类型" width="130"></el-table-column>
        <el-table-column prop="heroAttack" label="攻击值" width="120"></el-table-column>
        <el-table-column prop="heroHealth" label="生命值" width="120"></el-table-column>
        <el-table-column prop="heroCreateDate" label="上线时间" width="180"></el-table-column>
        <el-table-column label="图片" width="180">

        </el-table-column>
        <el-table-column label="操作" width="180">
            <template slot-scope="scope">
                <el-button @click="initUpdate(scope.row)" type="text" size="small">修改</el-button>
                <el-button type="text" size="small" @click="deleteHero(scope.row)">删除</el-button>
            </template>
        </el-table-column>
    </el-table>
    <el-pagination
    <%--@size-change="handleSizeChange"--%>
    <%--@current-change="handleCurrentChange"--%>
    <%-- current-page: 当前页 --%>
            :current-page="pageInfo.pageNum"
    <%-- 每页显示几条数据的下拉类别 --%>
            :page-sizes="[3, 6, 9, 12]"
    <%-- page-size：每页显示几条数据 --%>
            :page-size="pageInfo.pageSize"
    <%-- layout:布局 --%>
            layout="total, sizes, prev, pager, next, jumper"
    <%-- total：总条数 --%>
            :total="pageInfo.total"
    <%-- pageSize 改变时会触发 --%>
            @size-change="pageSizeChange"
            @current-change="nowPageChange"
    >
    </el-pagination>


    <el-dialog :title="title" :visible.sync="editFlag" width="30%">
        <el-form label-width="120px" :model="hero">
            <el-row>
                <el-col :span="24">
                    <el-form-item label="英雄名称：">
                        <!-- 如果 elementUI 中表情元素的组件未绑定 v-model，那么这个表单元素不能输入内容 -->
                        <el-input v-model="hero.heroName" clearable >
                        </el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="24">
                    <el-form-item label="英雄类型：">
                        <el-select v-model=hero.heroTypeId>
                            <%--<el-option :value=1 label="射手"></el-option>--%>
                            <el-option v-for="type in typeList" :value="type.heroTypeId"
                                       :label="type.heroTypeName"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="24">
                    <el-form-item label="攻击值：">
                        <el-input-number v-model="hero.heroAttack"></el-input-number>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="24">
                    <el-form-item label="生命值：">
                        <el-input-number v-model="hero.heroHealth"></el-input-number>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="24">
                    <el-form-item label="上线时间：">
                        <el-date-picker v-model="hero.heroCreateDate" value-format="yyyy-MM-dd" type="date" placeholder="选择日期">
                        </el-date-picker>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="24">
                    <el-form-item label="图片：">
                        <el-upload class="upload-demo" action="https://jsonplaceholder.typicode.com/posts/" multiple
                                   :limit="3">
                            <el-button size="small" type="primary">点击上传</el-button>
                            <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
                        </el-upload>
                    </el-form-item>
                </el-col>
            </el-row>

        </el-form>
        <span slot="footer" class="dialog-footer">
            <el-button @click="editFlag = false">取 消</el-button>
            <el-button type="primary" @click="editHero()">保存</el-button>
        </span>
    </el-dialog>
</div>
<script>
    new Vue({
        el: "#app",
        data: {
            heroList: [],
            pageInfo: {
                pageNum: 1,
                pageSize: 3,
                total: 0
            },
            queryHeroInfo: {
                heroName: "",
                date: "",
                method: "showHeroByPage",
                pageNum: 1,
                pageSize: 3,
            },
            editFlag: false,
            title: "添加英雄",
            hero: {
                method: "saveHero",
                heroName: "",
                heroTypeId: 1,
                heroAttack: 100,
                heroHealth: 888,
                heroCreateDate: "2022-04-01",
                heroImage: "img/1.jpg"
            },
            typeList: []
        }, methods: {
            queryHeroCondition() {// 条件查询
                // window.Qs.stringify()：将 json 数据装为 key=value&key=value
                // window.Qs.stringify(json对象, {arrayFormat: "repeat"})：处理 json的数据中有数组，key1=value&key2=value1&key2=value2
                var params = window.Qs.stringify(this.queryHeroInfo, {arrayFormat: "repeat"});
                console.log(params)
                // 发送异步请求到服务器，查询所有的英雄信息
                axios.get("/hero.do?" + params).then(response => {
                    var result = response.data;// page对象
                    this.heroList = result.list;
                    this.pageInfo.pageNum = result.pageNum
                    this.pageInfo.pageSize = result.pageSize
                    this.pageInfo.total = result.total
                }).catch(error => {// 处理
                    // console.log(error)
                    if (error.response) {
                        alert(error.response.status);
                    }
                });
            },
            pageSizeChange(pageSize) {
                console.log(pageSize)
                // this.pageInfo.pageSize = pageSize;
                // 调用 queryHero() 获取英雄信息
                //this.queryHero();

                // 分页条件查询
                this.queryHeroInfo.pageSize = pageSize;
                this.queryHeroCondition();
            },
            nowPageChange(pageNum) {

                this.queryHeroInfo.pageNum = pageNum;
                this.queryHeroCondition();
            },
            initSave() {// 初始化添加
                this.hero = {
                    method: "saveHero",
                    heroName: "",
                    heroTypeId: 1,
                    heroAttack: 100,
                    heroHealth: 888,
                    heroCreateDate: "2022-04-01",
                    heroImage: "img/1.jpg"
                };
                this.title = "添加英雄"
                this.editFlag = true;
            },
            initUpdate(heroObject) {// 将 heroObject 赋值给 this.hero

                // this.hero 是用于表单的双向绑定
                this.hero = {
                    method: "updateHero",
                    heroName: heroObject.heroName,
                    heroTypeId: heroObject.heroTypeId,
                    heroAttack: heroObject.heroAttack,
                    heroHealth: heroObject.heroHealth,
                    heroCreateDate: heroObject.heroCreateDate,
                    heroImage: heroObject.heroImage,
                    heroId: heroObject.heroId
                };
                // 显示对话框
                this.editFlag = true;
                this.title = "修改英雄"
            },
            editHero() {// 实现对英雄编辑
                // 获取 用户输入的数据
                var hero = this.hero;
                console.log(hero);
                // 发送异步请求到服务器，实现添加
                axios.get("hero.do", {
                    params: hero
                }).then(response => {
                    console.log(response.data);
                    if (response.data == true) {
                        let message = "添加成功";
                        if (this.title == "修改英雄") {
                            message = "修改成功";
                        }
                        this.$message({
                            message: message,
                            type: 'success'
                        });
                        // 调用 queryHeroCondition() 获取英雄信息
                        this.queryHeroCondition();

                        // 关闭对话框
                        this.editFlag = false;
                    } else {
                        let message = this.title == "修改英雄" ? "修改失败" : "添加失败";
                        this.$message.error(message);
                    }
                })
            },
            deleteHero(hero) {
                // 发送异步请求到服务器，删除英雄
                axios.get("hero.do?method=deleteHero&heroId=" + hero.heroId).then(response => {
                    // this.typeList = response.data;
                    let message = response.data ? "删除成功" : "删除失败";
                    this.$message({
                        message: message,
                        type: 'success'
                    });
                    this.queryHeroCondition();
                });

            }
        },
        created() {
            // 发送异步请求到服务器，查询所有的英雄信息
            // this.queryHero();
            this.queryHeroCondition();
            // 发送异步请求到服务器，查询所有的英雄类型
            axios.get("hero.do?method=showHeroType").then(response => {
                console.log(response.data)
                this.typeList = response.data;
            })
        }
    });
</script>
</body>
</html>
