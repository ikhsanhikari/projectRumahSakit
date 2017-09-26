<%-- 
    Document   : hikari
    Created on : Aug 23, 2017, 6:24:23 AM
    Author     : hikari
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach var="data" items="${klinikRawatInap}">
            ${data.nama_klinik}
        </c:forEach>
        <h1>Login sebagai ${hikari}</h1><br>
        <h1>Login sebagai ${jenis}</h1><br>
        <a href="logOut.htm">Log Out</a>
    </body>
</html>
