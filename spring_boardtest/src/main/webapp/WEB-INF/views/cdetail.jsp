<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <title>detail</title>
    <script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
    <jsp:include page="nav.jsp"/>

</head>
<body class="bg-light">
<div class="container mt-4">
    <table class="table">
        <tr>
            <th>번호</th>
            <td>${comment.id}</td>
        </tr>
        <tr>
            <th>작성자</th>
            <td>${comment.commentWriter}</td>
        </tr>
        <tr>
            <th>내용</th>
            <td>${comment.commentContents}</td>
        </tr>
        <tr>
            <th>작성시간</th>
            <td>${comment.commentCreatedTime}</td>
        </tr>

    </table>

    <div class="mb-3">
        <button class="btn btn-warning" onclick="updateFn()">수정</button>
        <button class="btn btn-danger" onclick="deleteFn()">삭제</button>
    </div>

</div>

</body>
<script>
    const updateFn = () => {
        const id = '${comment.id}';
        location.href = "/comment/update?id=" + id;
    }
    const deleteFn = () => {
        const id = `${comment.id}`;

        const isConfirmed = window.confirm("정말 삭제하시겠습니까?");

        if (isConfirmed) {
            alert("삭제 되었습니다.");
            location.href = "/comment/delete?id=" + id;
        } else {
            alert("삭제가 취소되었습니다.");
        }
    };

</script>
<script>
    // 특수문자 입력 방지
    function characterCheck(obj){
        var regExp = /[ \{\}\[\]\/|\)`^\-_+┼<>@\#$%&\'\"\\\(\=]/gi;
        if( regExp.test(obj.value) ){
            alert("특수문자는 입력하실수 없습니다.");
            obj.value = obj.value.substring( 0 , obj.value.length - 1 ); // 입력한 특수문자 한자리 지움
        }
    }
</script>
</html>