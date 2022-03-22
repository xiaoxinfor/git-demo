<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
<select id="province" onchange="showCity(this.value)">
    <option>请选择</option>
</select>
<select id="city" onchange="showQu(this.value)">
    <option>请选择</option>
</select>
<select id="area">
    <option>请选择</option>
</select>

<script>
    axios.get("/showPro.do").then(function (response) {
        var result = response.data;
        result.forEach(function (obj) {
            var option = document.createElement("option");
            option.innerText = obj.areaName;
            option.value = obj.areaId;
            document.getElementById("province").append(option);
        })
    })

    function showCity(value) {
        // 删除其他省的城市
        var options = document.getElementById("city").children;
        for (var i = options.length - 1; i >= 1; i--) {
            options[i].remove();
        }

        axios.get("/showCity.do", {
            params: {"parenId": value}
        }).then(function (response) {
            var result = response.data;
            result.forEach(function (obj) {
                var option = document.createElement("option");
                option.innerText = obj.areaName;
                option.value = obj.areaId;
                document.getElementById("city").append(option);
            })
        })
    }

    function showQu(value) {
        // 删除其他区的城市
        var options = document.getElementById("area").children;
        for (var i = options.length - 1; i >= 1; i--) {
            options[i].remove();
        }
        axios.get("/showArea.do", {
            params: {"parenId": value}
        }).then(function (response) {
            var result = response.data;
            result.forEach(function (obj) {
                var option = document.createElement("option");
                option.innerText = obj.areaName;
                option.value = obj.areaId;
                document.getElementById("area").append(option);
            })
        })

    }
</script>

</body>
</html>
