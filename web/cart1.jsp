<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entity.Cart" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    //获取Cart List
    List<Cart> cart = (List<Cart>) request.getAttribute("cart");

//总计
    Double sum = 0.0;
    for (Cart c : cart) {
        sum += c.getPrice() * c.getNumber();
    }
    int flag = 1;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <link href="css/object.css" rel="stylesheet">

</head>

<body>
<h1>我的购物车</h1>
<hr>
<div id="wrapper">
    <table id="keywords" cellpadding="0" cellspacing="1">
        <thead>
        <tr>
            <th><span>序号</span></th>
            <th><span>商品</span></th>
            <th><span>数量</span></th>
            <th><span>价格</span></th>
            <th>
                <sapn>操作</sapn>
            </th>
        </tr>
        </thead>

        <%
            if (cart.size() > 0) {
                for (int i = 1; i <= cart.size(); i++) {
                    Cart c = cart.get(i - 1);
        %>
        <tr>
            <td><%=i %>
            </td>
            <td><%=c.getGoodsname() %>
            </td>
            <td><%=c.getNumber() %>
            </td>
            <td><%=c.getPrice() %>
            </td>
            <td><a href="<%=request.getContextPath()%>/delete.cart?goodsname=<%=c.getGoodsname() %>">删除</a></td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="5">没有购买任何商品</td>
        </tr>
        <%
                flag = 0;
            }
        %>
    </table>
    <hr>
    总计：<%=sum %>元
    <br>
    <a href="<%=request.getContextPath()%>/delete.cart?type=All">清空购物车</a>
    <a href="<%=request.getContextPath()%>/show_food.goods">继续购物</a>
    <%if (flag == 1) { %><a href="<%=request.getContextPath()%>/confirm.order">结算</a><%} %>
</div>
</body>
</html>
