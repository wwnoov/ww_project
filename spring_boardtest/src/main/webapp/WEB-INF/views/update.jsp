<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
    <title>update</title>

    <jsp:include page="nav.jsp"/>
</head>
<body class="bg-light">
    <div class="container mt-5">
        <%--@elvariable id="boardDTO" type="kr.co.chunjae.dto.BoardDTO"--%>
        <form:form modelAttribute="boardDTO" action="/board/update" method="post" cssClass="mb-5">
            <div class="form-group">
                <div class="mb-3">
                    <form:hidden path="id"/>
                    <form:input path="boardWriter"  class="form-control" placeholder="${boardDTO.boardWriter}" readonly="true"/>
                    <form:errors path="boardWriter" cssClass="text-danger"/></div>
                <div class="mb-3">
                    <form:password path="boardPass"  class="form-control" onblur ="passfn()"/>
                    <form:errors path="boardPass" cssClass="text-danger"/></div>
                <div class="mb-3">
                    <form:input path="boardTitle"  class="form-control"/>
                    <form:errors path="boardTitle" cssClass="text-danger"/></div>
                <div class="mb-3">
                    <form:textarea path="boardContents"  class="form-control" rows="5" />
                    <form:errors path="boardContents" cssClass="text-danger"/></div>
            </div>
            <div class="mb-3">
                <form:button type="submit" class="btn btn-primary" onclick="updateFn()">수정</form:button>
                <form:button type="button" class="btn btn-primary" onclick="backFn()">뒤로</form:button>
            </div>
        </form:form>
    </div>
</body>
<script>
    const passfn = () => {
            const passInput = document.getElementById("boardPass").value;
            const passDB = '<c:out value="${boardDTO.boardPass}" />';
            console.log(passDB)
            if (passInput == passDB) {
                alert("비밀번호가 일치합니다.")
            } else {
                alert("비밀번호가 일치하지 않습니다!!");
            }
    }
    const updateFn = () => {
            alert("수정이 완료되었습니다.");
    }
    const backFn = () => {
        window.history.back();
    }
</script>
</html>
