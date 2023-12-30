<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
    <title>save</title>
    <script>
        function validate() {
            var re = /^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]{2,12}$/; // 작성자가 적합한지 검사할 정규식
            var re2 = /^[a-zA-Z0-9]{1,12}$/; // 패스워드가 적합한지 검사할 정규식

            var id = document.getElementById("uid");
            var pw = document.getElementById("upw");
            var title = document.getElementById("title");
            var content = document.getElementById("content");

            if(!check(re, id, "작성자 2~12자의 한글로만 입력")) {
                return false;
            }

            if(!check(re2, pw, "패스워드는 1~12자의 영문 대소문자와 숫자로만 입력")) {
                return false;
            }

            if(title.value.trim() === "") {
                alert("제목을 입력해 주세요");
                title.focus();
                return false;
            }

            if(content.value.trim() === "") {
                alert("내용을 입력해 주세요");
                content.focus();
                return false;
            }
            alert("작성 완료")
            return true;
        }

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
    <jsp:include page="nav.jsp"/>
</head>

<body class="bg-light">
<div class="container mt-5">
    <form action="/board/save" method="post" onsubmit="return validate();">
        <div class="form-group">
            <input type="text" name="boardWriter" class="form-control" placeholder="작성자" id="uid" autofocus  onkeyup="characterCheck(this)" onkeydown="characterCheck(this)">
        </div>
        <div class="form-group">
            <input type="text" name="boardPass" class="form-control" placeholder="비밀번호"  id="upw"  onkeyup="characterCheck(this)" onkeydown="characterCheck(this)">
        </div>
        <div class="form-group">
            <input type="text" name="boardTitle" class="form-control" placeholder="제목" id="title"  onkeyup="characterCheck(this)" onkeydown="characterCheck(this)">
        </div>
        <div class="form-group">
            <textarea name="boardContents" class="form-control" rows="5" placeholder="내용을 입력하세요" id="content"  onkeyup="characterCheck(this)" onkeydown="characterCheck(this)"></textarea>
        </div>

        <c:if test="${errors.errorCount > 0}">
            <div class="alert alert-danger">
                <ul>
                    <c:forEach var="error" items="${errors.allErrors}">
                        <li>${error.defaultMessage}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>

        <button type="submit" class="btn btn-primary">작성</button>
    </form>
</div>
</body>
</html>