<%-- 
    Document   : students
    Created on : 2020-04-05, 00:26:11
    Author     : alicj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Students</title>
    </head>
    <body>
        <h3>licznik wyświetleń: ${sessionScope.counter}</h3>
        <table border="1">
            <tr>
                <th>Imię</th>
                <th>Nazwisko</th>
                <th>Email</th>
            </tr>
            <c:forEach items="${sessionScope.studentList}" var="student">
                <tr>
                    <td>${student.name}</td>
                    <td>${student.lastName}</td>
                    <td>${student.email}</td>
                </tr>
            </c:forEach> 
    </table>


        <form action='StudentsList' method='post'><br>
        Student: <br>
        <input type='text' name='imie'> Imie <br>
        <input type='text' name='nazwisko'> Nazwisko <br>
        <input type='email' name='email'> Email <br><br>
        <input type='submit' value="Dodaj" >
    </form>
</body>
</html>
