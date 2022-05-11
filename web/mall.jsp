<%@page import="entity.User" %>
<%@page import="entity.mall" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    List<mall> mall_cloth = (List<mall>) request.getAttribute("mall_cloth");
    List<mall> mall_mobile = (List<mall>) request.getAttribute("mall_mobile");
    List<mall> mall_fruit = (List<mall>) request.getAttribute("mall_fruit");
    List<mall> mall_food = (List<mall>) request.getAttribute("mall_food");
    User u = (User) session.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>食品展示区</title>
    <link href="css/object.css" rel="stylesheet">
</head>
<body>
<h1>商品列表</h1>
<%if (u != null) { %>
<b style="color: red;">用户<%=u.getUsername() %>在线... </b>
<a href="<%=request.getContextPath()%>/logout.user">注销</a>
<a href="<%=request.getContextPath()%>/showOrders.order">我的历史订单</a><%} else { %>
<a href="login.jsp">登录</a>
<a href="register.jsp">注册</a><%} %>
<hr>

<div id="wrapper">
    <table id="keywords" cellpadding="0" cellspacing="1">
        <thead>
        <tr>
            <th><span>序号</span></th>
            <th><span>商品</span></th>
            <th><span>介绍</span></th>
            <th><span>价格</span></th>
            <th><span>删除</span></th>
            <th><span>修改</span></th>
        </tr>
        </thead>
        <%
            for (int i = 1; i <= mall_food.size(); i++) {
                mall g = mall_food.get(i - 1);
        %>
        <tr>
            <td><%=i %>
            </td>
            <td><%=g.getGoodsname() %>
            </td>
            <td><%=g.getDescribe() %>
            </td>
            <td><%=g.getPrice() %>
            </td>
            <td><a href="/check_mall.user?tag=Del&id=food&mall_name=<%=g.getGoodsname()%>">删除</a></td>
            <td><a href="/check_mall.user?tag=Update&id=food&mall_name=<%=g.getGoodsname()%>">修改</a></td>
        </tr>
        <%
            }
        %>


        <thead>
        <tr>
            <th><span>序号</span></th>
            <th><span>商品</span></th>
            <th><span>介绍</span></th>
            <th><span>价格</span></th>
            <th><span>删除</span></th>
            <th><span>修改</span></th>
        </tr>
        </thead>
        <%
            for (int i = 1; i <= mall_cloth.size(); i++) {
                mall g = mall_cloth.get(i - 1);
        %>
        <tr>
            <td><%=i %>
            </td>
            <td><%=g.getGoodsname() %>
            </td>
            <td><%=g.getDescribe() %>
            </td>
            <td><%=g.getPrice() %>
            </td>
            <td><a href="/check_mall.user?tag=Del&id=cloth&mall_name=<%=g.getGoodsname()%>">删除</a></td>
            <td><a href="/check_mall.user?tag=Update&id=cloth&mall_name=<%=g.getGoodsname()%>">修改</a></td>
        </tr>
        <%
            }
        %>


        <thead>
        <tr>
            <th><span>序号</span></th>
            <th><span>商品</span></th>
            <th><span>介绍</span></th>
            <th><span>价格</span></th>
            <th><span>删除</span></th>
            <th><span>修改</span></th>
        </tr>
        </thead>
        <%
            for (int i = 1; i <= mall_mobile.size(); i++) {
                mall g = mall_mobile.get(i - 1);
        %>
        <tr>
            <td><%=i %>
            </td>
            <td><%=g.getGoodsname() %>
            </td>
            <td><%=g.getDescribe() %>
            </td>
            <td><%=g.getPrice() %>
            </td>
            <td><a href="/check_mall.user?tag=Del&id=mobile&mall_name=<%=g.getGoodsname()%>">删除</a></td>
            <td><a href="/check_mall.user?tag=Update&id=mobile&mall_name=<%=g.getGoodsname()%>">修改</a></td>
        </tr>
        <%
            }
        %>


        <thead>
        <tr>
            <th><span>序号</span></th>
            <th><span>商品</span></th>
            <th><span>介绍</span></th>
            <th><span>价格</span></th>
            <th><span>删除</span></th>
            <th><span>修改</span></th>
        </tr>
        </thead>
        <%
            for (int i = 1; i <= mall_fruit.size(); i++) {
                mall g = mall_fruit.get(i - 1);
        %>
        <tr>
            <td><%=i %>
            </td>
            <td><%=g.getGoodsname() %>
            </td>
            <td><%=g.getDescribe() %>
            </td>
            <td><%=g.getPrice() %>
            </td>
            <td><a href="/check_mall.user?tag=Del&mall_name=<%=g.getGoodsname()%>">删除</a></td>
            <td><a href="/check_mall.user?tag=Update&mall_name=<%=g.getGoodsname()%>">修改</a></td>
        </tr>
        <%
            }
        %>
    </table>

</div>


<% String msg = (String) request.getAttribute("msg");%>
<h1 style="color: red;"><%=msg != null ? msg : "" %>
</h1>
<br>

</body>
</html>