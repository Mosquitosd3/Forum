<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title>Post job4j</title>
</head>
<jsp:include page="../navbar/navbar.jsp"/>
<body>
<br>
<div class="container">
    <div class="form-group">
        <h4><c:out value="${post.name}"/></h4>
    </div>
    <hr>
    <form>
        <div class="form-group">
            <span>Nickname: <c:url value="${post.user.username}"/></span>
        </div>
        <div class="form-group">
            <div class="container">
                <textarea class="form-control" id="formForDefinition1" rows="3" disabled readonly><c:out value="${post.description}"/></textarea>
            </div>
        </div>
        <c:if test="${post.user.username == user.username}">
            <div class="form-group">
                <a href="<c:url value='/edit/${post.id}'/>" class="btn btn-info">Edit</a>
                <a href="#" class="btn btn-danger">Delete</a>
            </div>
        </c:if>
    </form>
    <hr>
    <div class="form-group">
        <form action="<c:url value='/addComment/${post.id}'/>" id="postComment" method="post">
            <div class="form-group">
                <label for="desc">Post comment</label>
                <textarea class="form-control" id="desc" name="description" placeholder="Enter comment..."></textarea>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary mb-2">Add</button>
            </div>
        </form>
    </div>
    <hr>
    <p>discussion</p>
    <div class="form-group">
        <table class="table">
            <thead>
            <tr>
                <th>Username</th>
                <th>Comment</th>
                <th>Created</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${comments}" var="comment">
                <tr>
                    <td>
                            ${comment.user.username}
                    </td>
                    <td>
                            ${comment.description}
                    </td>
                    <td>
                            ${comment.created()}
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>




