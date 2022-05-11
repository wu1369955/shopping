<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<head>
    <title>Judge</title>
</head>
<body>
<sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/shopping?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8"
                   user="root"
                   password="123456"/>
<sql:query dataSource="${snapshot}" var="result">
    SELECT * from user;
</sql:query>
<h1 style="text-align: center"> 这里是判断是否成功登陆界面</h1>
<%
    request.setAttribute("password", request.getParameter("password"));
    request.setAttribute("email", request.getParameter("email"));
%>
<div align="center">
    <c:forEach var="row" items="${result.rows}">
        <c:if test="${password ==row.user_password}">
            <c:if test="${email==row.user_name}">
                <c:out value="success"></c:out>
                <script>
                    alert("登陆成功")
                    window.location.replace("main.jsp");
                </script>
            </c:if>
        </c:if>
    </c:forEach>
    <script>
        alert("登陆失败")
        window.location.replace("login.jsp");
    </script>


</div>
</body>
</html>


<%--            <table border="1" width="50%">--%>
<%--                <tr>--%>
<%--                    <th>ID</th>--%>
<%--                    <th>姓名</th>--%>
<%--                    <th>密码</th>--%>
<%--                </tr>--%>
<%--                <c:forEach var="row" items="${result.rows}">--%>
<%--                    <tr>--%>
<%--                        <td><c:out value="${row.user_id}"/></td>--%>
<%--                        <td><c:out value="${row.user_name}"/></td>--%>
<%--                        <td><c:out value="${row.user_password}"/></td>--%>
<%--                    </tr>--%>
<%--                </c:forEach>--%>
<%--            </table>--%>