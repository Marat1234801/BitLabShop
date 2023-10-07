<%@ page import="java.util.List" %>
<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: amant
  Date: 07.10.2023
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users list</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<%@include file="navbar.jsp"%>
<br>
<%
    List<User> users = (List<User>) request.getAttribute("users");
    if(!users.isEmpty()){

%>
        <div class="container">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">email</th>
                    <th scope="col">full_name</th>
                    <th scope="col">password</th>
                    <th scope="col">Edit</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (User user: users) {
                %>
                    <tr>
                        <th scope="row"><%=user.getId()%></th>
                        <td><%=user.getEmail()%></td>
                        <td><%=user.getFullName()%></td>
                        <td><%=user.getPassword()%></td>
                        <td><button class="btn btn-warning">Edit</button></td>
                        <td><button class="btn btn-danger">Delete</button></td>
                    </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
<%
    } else{
%>
        <h4 class="bg-danger text-wrap">No users!</h4>
<%
    }
%>
<br>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
