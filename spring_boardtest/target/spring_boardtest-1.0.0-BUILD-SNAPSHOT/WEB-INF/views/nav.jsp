<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
    <title>개인 프로젝트 남원우</title>
    <jsp:include page="register.jsp" />
</head>
<body class="bg-light">
<div class="container mt-5">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/">홈</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/board/save">글작성</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/board/list">글목록</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/board/paging">페이징 목록</a>
                </li>
            </ul>
        </div>
    </nav>
</div>
</body>
</html>