<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
    <title>save</title>
    <script>
         function check(re, what, message) {
            if(re.test(what.value)) {
                return true;
            }
            alert(message);
            what.value = "";
            what.focus();
            return false;
        }
    </script>
    <jsp:include page="nav.jsp"/>
</head>

<body class="bg-light">
<div class="container mt-5">
         <%--@elvariable id="boardDTO" type="kr.co.chunjae.dto.BoardDTO"--%>
        <form:form modelAttribute="boardDTO" action="/board/save" method="post" cssClass="mb-5">
        <div class="form-group">
            <div class="mb-3">
            <form:input path="boardWriter"  class="form-control" placeholder="작성자" />
            <form:errors path="boardWriter" cssClass="text-danger"/></div>
            <div class="mb-3">
            <form:input path="boardPass"  class="form-control" placeholder="비밀번호" />
            <form:errors path="boardPass" cssClass="text-danger"/></div>
            <div class="mb-3">
            <form:input path="boardTitle"  class="form-control" placeholder="제목" />
            <form:errors path="boardTitle" cssClass="text-danger"/></div>
            <div class="mb-3">
            <form:textarea path="boardContents"  class="form-control" rows="5" placeholder="내용을 입력하세요" />
            <form:errors path="boardContents" cssClass="text-danger"/></div>
        </div>
        <div class="mb-3">
        <button type="submit" class="btn btn-primary">작성</button>
        <button type="button" class="btn btn-primary" onclick="backFn()">뒤로가기</button>
        </div>
    </form:form>
</div>
<script>
    const backFn = () => {
        location.href = "/board/paging";
    }
</script>
</body>
</html>