<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: amant
  Date: 06.10.2023
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    User account = (User) session.getAttribute("account");
%>
<nav class="navbar navbar-expand-lg bg-primary" data-bs-theme="dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">BITLAB Shop</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/users">Users</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link active dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Items
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/itemList">Items list</a></li>
                        <li><a class="dropdown-item" href="/addItem.jsp">Add item</a></li>
                    </ul>
                </li>
                <%
                    if(account != null){
                %>
                    <li class="nav-item dropdown">
                        <a class="nav-link active dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <%=account.getFullName()%>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/editUser?id=<%=account.getId()%>">Edit account</a></li>
                            <li><a class="dropdown-item" href="/addItem.jsp">Delete account</a></li>
                            <li><a class="dropdown-item" href="/addItem.jsp">Log out</a></li>
                        </ul>
                    </li>
                <%
                    }else{
                %>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/login">Sign in</a>
                    </li>
                <%
                    }
                %>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

</html>
