<%@ page import="model.Item" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: amant
  Date: 07.10.2023
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Item list</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<%@include file="navbar.jsp" %>
<br>
<div class="d-flex" style="flex-direction: row; flex-wrap: wrap;justify-content: center;">
    <%
        List<Item> items = (List<Item>) request.getAttribute("items");

        if (items != null) {
            for (Item item : items) {

    %>
    <div class="card col-sm-3 m-3">
        <div class="card-header text-center">
            <h4><%=item.getName()%>
            </h4>
        </div>
        <div class="card-body">
            <h5 class="card-title text-center text-success"><%=item.getPrice()%>$</h5>
            <p class="card-text text-center"><%=item.getDescription()%>
            </p>
            <div class="d-flex" style="justify-content: center; align-items: flex-start;">
                <a href="/editItem?id=<%=item.getId()%>" style="margin-right: 4px;" class="btn btn-warning">EDIT</a>
                <form action="/deleteItem" method="post">
                    <input type="hidden" name="id" value="<%=item.getId()%>">
                    <button class="btn btn-danger">DELETE</button>
                </form>
            </div>

        </div>
    </div>
    <%

            }
        }
    %>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
