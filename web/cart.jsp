<%@ page import="java.util.ArrayList" %>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link href="css/object.css" rel="stylesheet">
    <%
        ArrayList id = new ArrayList();

        for (int i = 0; i < 20; i++) {
            if (request.getParameter(String.valueOf(i)) != null) {
                id.add(request.getParameter(String.valueOf(i)));
            } else {
                id.add(0);
            }
        }
        request.setAttribute("id", id);


        // 编码，解决中文乱码
        String str = URLEncoder.encode(request.getParameter("name"), "utf-8");
        // 设置 name 和 url cookie
        Cookie name = new Cookie("name", str);
        Cookie url = new Cookie("url", request.getParameter("url"));

        // 设置cookie过期时间为24小时。
        name.setMaxAge(60 * 60 * 24);
        url.setMaxAge(60 * 60 * 24);

        // 在响应头部添加cookie
        response.addCookie(name);
        response.addCookie(url);
    %>


</head>
<body id="body">
<style>
    table {
        border-collapse: collapse;
        border-spacing: 0;
    }

    th, td {
        padding: 10px 20px;
        border: 1px solid #000;
    }
</style>

<sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/shopping?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8"
                   user="root"
                   password="123456"/>
<sql:query dataSource="${snapshot}" var="result">
    SELECT * from mall_cloth,mall_fruit,mall_mobile,mall_food;
</sql:query>

<c:out value="${id}">提交的表单为</c:out>

<div>
    <p> 这个界面将展示 购物车的内容</p>
</div>
<button onclick="show()">显示购物车</button>
<button onclick="show_table()">显示表格信息</button>


<script>
    function show() {
        console.log(document.cookie)
        var ca = document.cookie.split(';');
        for (var i = 0; i < ca.length; i++) {
            // var c = ca[i].trim();
            // console.log(c);
            var temp = ca.pop();
            console.log(temp + " " + temp[1] + temp[2]);
        }

    }

    function show_table() {
        let table = document.createElement('table');
        let thead = document.createElement('thead');
        let tbody = document.createElement('tbody');

        table.appendChild(thead);
        table.appendChild(tbody);
        document.getElementById('body').appendChild(table);

        let row_1 = document.createElement('tr');
        let heading_1 = document.createElement('th');
        heading_1.innerHTML = "Sr. No.";
        let heading_2 = document.createElement('th');
        heading_2.innerHTML = "Name";
        let heading_3 = document.createElement('th');
        heading_3.innerHTML = "Company";

        row_1.appendChild(heading_1);
        row_1.appendChild(heading_2);
        row_1.appendChild(heading_3);
        thead.appendChild(row_1);

        let row_2 = document.createElement('tr');
        let row_2_data_1 = document.createElement('td');
        row_2_data_1.innerHTML = "1.";
        let row_2_data_2 = document.createElement('td');
        row_2_data_2.innerHTML = "James Clerk";
        let row_2_data_3 = document.createElement('td');
        row_2_data_3.innerHTML = "Netflix";

        row_2.appendChild(row_2_data_1);
        row_2.appendChild(row_2_data_2);
        row_2.appendChild(row_2_data_3);
        tbody.appendChild(row_2);


        let row_3 = document.createElement('tr');
        let row_3_data_1 = document.createElement('td');
        row_3_data_1.innerHTML = "2.";
        let row_3_data_2 = document.createElement('td');
        row_3_data_2.innerHTML = "Adam White";
        let row_3_data_3 = document.createElement('td');
        row_3_data_3.innerHTML = "Microsoft";

        row_3.appendChild(row_3_data_1);
        row_3.appendChild(row_3_data_2);
        row_3.appendChild(row_3_data_3);
        tbody.appendChild(row_3);

    }


</script>
</body>
</html>
