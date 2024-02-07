<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

</head>
<body>
    <div class="m-5  d-flex justify-content-around">
        <h1 class="text-warning">TableMaster</h1>
        <section>
            <h3>Nuevo Mesero</h3>
            <p class="text-danger"><form:errors path="mesero.*"/></p>
            <form:form method="POST" action="/register" modelAttribute="mesero" class="form">
                <p class="form-group">
                    <form:label path="name"  class="control-label">Name:</form:label>
                    <form:input type="text" path="name" class="form-control" />
                </p>
                <p class="form-group">
                    <form:label path="email"  class="control-label">Email:</form:label>
                    <form:input type="email" path="email" class="form-control" />
                </p>
                <p class="form-group">
                    <form:label path="password"  class="control-label">Password:</form:label>
                    <form:password path="password" class="form-control" />
                </p>
                <p class="form-group">
                    <form:label path="passwordConfirmation"  class="control-label">Password Confirmation:</form:label>
                    <form:password path="passwordConfirmation" class="form-control" />
                </p>
                <input type="submit" value="Register" class="btn btn-info"/>
            </form:form> 
        </section>

        <section>
            <h3>Log in</h3>
            <p class="text-danger"><c:out value="${error}" /></p>
            <form method="post" action="/login" class="form">
                <p class="form-group">
                    <label for="email"  class="control-label">Email</label>
                    <input type="email" id="email" name="email" class="form-control"/>
                </p>
                <p class="form-group">
                    <label for="password"  class="control-label">Password</label>
                    <input type="password" id="password" name="password" class="form-control"/>
                </p>
                <input type="submit" value="Login" class="btn btn-info"/>
            </form>  
        </section>
    </div>
</body>
</html>