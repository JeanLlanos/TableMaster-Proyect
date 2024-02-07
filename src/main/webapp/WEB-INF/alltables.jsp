<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

</head>
<body>
    <div class="m-5">
        <section class="d-flex justify-content-between">
            <h1>All Tables</h1>
            <a href="/home">Home</a>
        </section>
        <p>Tables</p>
        <table class="table table-secondary table-striped">
            <thead>
                <th class="fs-4">Guest Name</th>
                <th class="fs-4"># Guests</th>
                <th class="fs-4">Arrived at</th>
                <th class="fs-4">Server</th>
            </thead>
            <tbody>
                <c:forEach items="${mesas}" var="mesa" >
                    <c:if test="${mesa.mesero != null}">
                        <tr>
                            <td>
                                <p><c:out value="${mesa.name}"/></p>
                            </td>
                            <td>
                                <p><c:out value="${mesa.invites}"/></p>
                            </td>
                            <td>
                                <p><fmt:formatDate pattern = "MMMM-dd hh:mm a" value = "${mesa.createdAT}" /></p>
                            </td>
                            <td>
                                <p><c:out value="${mesa.mesero.name}"/></p>
                            </td>				
                        </tr>
                    </c:if>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>