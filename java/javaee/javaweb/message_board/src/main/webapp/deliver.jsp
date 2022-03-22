<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/20
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
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

        #title {
            width: 300px;
            margin-left: 900px;
            margin-top: 30px;
        }

        #app {
            width: 800px;
            margin: 0 auto;
            margin-top: 60px;
        }
    </style>
</head>
<body>
<div id="title">

</div>
<div id="app">
    <template>
        <el-table :data="deliverList" border style="width: 100%">
            <el-table-column prop="dTitle" label="主题" width="180" ></el-table-column>
            <el-table-column prop="dContent" label="内容" width="600"></el-table-column>
        </el-table>
        <el-pagination :current-page="pageInfo.pageNum" :page-sizes="[3, 6, 9, 12]"
                       :page-size="pageInfo.pageSize" layout="total, sizes, prev, pager, next, jumper"
                       :total="pageInfo.total" @size-change="pageSizeChange" @current-change="nowPageChange">
        </el-pagination>
    </template>
</div>


<script>
    new Vue({
        el: "#app",
        data() {
            return {
                deliverList: [],
                pageInfo: {
                    pageNum: 1,
                    pageSize: 3,
                    total: 0
                },
                queryInfo: {}
            }

        },
        methods: {
            pageSizeChange(pageSize) {
                console.log(pageSize)
                this.pageInfo.pageSize = pageSize;
                this.query();
            },
            nowPageChange(pageNum) {
                this.pageInfo.pageNum = pageNum;
                this.query();
            },
            query(){
                axios.get("/deliver.do?pageNum=" + this.pageInfo.pageNum+"&pageSize="+this.pageInfo.pageSize).then(response => {
                    var result = response.data;
                    console.log(result);
                    this.deliverList = result.list;
                    this.pageInfo.pageNum = result.pageNum;
                    this.pageInfo.pageSize = result.pageSize;
                    this.pageInfo.total = result.total;
                })
            }
        },
        mounted() {
           this.query();
        }
    })
</script>
</body>
</html>
