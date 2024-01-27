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
        <form:form modelAttribute="boardDTO" action="/board/update" method="post" cssClass="mb-5" onclick="updateFn()">
            <div class="form-group">
                <div class="mb-3">
                    <form:input path="boardWriter"  class="form-control" placeholder="${boardDTO.boardWriter}" readonly="true"/>
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
                <button type="button" class="btn btn-primary" onclick="updateReqFn()">수정</button>
            </div>
        </form:form>
    </div>
</div>
</body>
<script>
    const updateReqFn = () => {
        if (validate()) {
            const passInput = document.getElementById("boardPass").value;
            const passDB = '${board.boardPass}';
            if (passInput == passDB) {
                alert("수정이 완료되었습니다.")
                document.updateForm.submit();
            } else {
                alert("비밀번호가 일치하지 않습니다!!");
            }
        }
    }
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
