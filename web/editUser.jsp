<%--
  Created by IntelliJ IDEA.
  User: amant
  Date: 07.10.2023
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit account</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<%@include file="navbar.jsp"%>
<br>
<div class="container" style="display: flex;justify-content: center;">
<%
    User user = (User) request.getAttribute("user");
    if(user!=null){
%>
        <form class="w-50" method="post" action="/editUser" style="border: 2px solid #eaeaea;padding: 10px;">
            <h3>Edit user form</h3>
            <input type="hidden" name="id" value="<%=user.getId()%>">
            <br>
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Email</label>
                <input type="email" class="form-control" name="email" value="<%=user.getEmail()%>" id="exampleInputEmail1" aria-describedby="emailHelp">
                <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Password</label>
                <input type="password" class="form-control" name="password" value="<%=user.getPassword()%>" id="exampleInputPassword1" aria-describedby="passwordHelp">
            </div>
            <div class="mb-3">
                <label for="exampleInputFullName" class="form-label">Full name</label>
                <input type="text" class="form-control" name="fullName" value="<%=user.getFullName()%>" id="exampleInputFullName" aria-describedby="fullNameHelp">
            </div>
            <button type="submit" class="btn btn-success">Save</button>
        </form>
    <%
        }
    %>
</div>
<br>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
