<%--
  Created by IntelliJ IDEA.
  User: amant
  Date: 07.10.2023
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add item</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
</head>
<body>
<%@include file="navbar.jsp" %>
<br>

<div class="container" style="display: flex;justify-content: center;">

    <form class="w-50" method="post" action="/addItem">
        <h3>Creating Item</h3>
        <br>
        <div class="mb-3">
            <label for="InputName" class="form-label">Item's name</label>
            <input type="text" class="form-control" name="name" id="InputName" aria-describedby="nameHelp">
        </div>
        <div class="mb-3">
            <label for="floatingTextarea">Description</label>
            <textarea class="form-control" name="description" placeholder="Write description here"
                      id="floatingTextarea"></textarea>
        </div>
        <div class="mb-3">
            <label for="InputPrice" class="form-label">Price</label>
            <input type="number" class="form-control" name="price" id="InputPrice">
        </div>
        <button type="submit" class="btn btn-success">Add Item</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
