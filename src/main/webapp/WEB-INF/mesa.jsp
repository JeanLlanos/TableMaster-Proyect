<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/mesa.css">
</head>
<body>
    <div class="m-5 d-flex justify-content-center ">
        <section class="form-tajet">
            <div class="d-flex justify-content-between">
                <h2 class="font-monospace text-dark">New Table</h2>
                <a href="/logout">Log out</a>
            </div>
            <p class="text-danger"><form:errors path="mesa.*"/></p>
            
            <form:form method="POST" action="/tables/new" modelAttribute="mesa" class="form">
                <form:input type="hidden" path="mesero" value="${meseroId}"/>
               
                <p class="form-group">
                    <form:label path="name" class="control-label">Name:</form:label>
                    <form:input type="text" path="name" class="form-control"/>
                </p>
                <p class="form-group">
                    <form:label path="invites" class="control-label">Number of Guests:</form:label>
                    <form:input path="invites" type="number" min="1" max="10" value="1" class="form-control"/>
                </p>
                <p class="form-group">
                    <form:label path="notes" class="control-label">Notes:</form:label>
                    <form:textarea cols="30" rows="4" style="resize: none;" path="notes" class="form-control"/>
                </p><br>
            
                <input type="submit" value="Submit" class="btn btn-primary"/>
                
            </form:form><br>
            <a href="/home" class="btn btn-danger">Cancel</a>
        </section>
        
    </div>
    <div class="m-5 text-center">
        <h1 class="font-monospace">Tus Mesas</h1>
        <table class="table table-hover table-borderless table-secondary">
            <thead>
                <th class="fs-4">Guest Name</th>
                <th class="fs-4"># Guests</th>
                <th class="fs-4">Arrived at</th>
            </thead>
            <tbody>
                <c:forEach items="${mesas}" var="mesa">
                    <c:if test="${mesa.mesero.id == sessionScope.meseroId}">
                        <tr>
                            <td>
                                <p><c:out value="${mesa.name}"/></p>
                            </td>
                            <td>
                                <p><c:out value="${mesa.invites}"/></p>
                            </td>
                            <td>
                                <p><fmt:formatDate pattern="MMMM-dd hh:mm a" value="${mesa.createdAT}" /></p>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>

            </tbody>
        </table>
    </div>
</body>
</html>