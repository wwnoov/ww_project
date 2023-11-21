<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../Common/stylecss.css">
    <title>파일 첨부형 게시판</title>
    <script type="text/javascript">
        function validateForm(form){
            if (form.pass.value == ""){
                alert("비밀번호를 입력하세요.");
                form.pass.focus();
            return false;
            }
        }
    </script>
</head>
<body>
<h2>파일 첨부형 게시판 - 비밀번호 검증(Pass)</h2>
<form name="writeFrm" method="post" action="${pageContext.request.contextPath}/mvcboard/pass.do" onsubmit="return validateForm(this);">
    <input type="hidden" name="idx" value="${param.idx}" />
    <input type="hidden" name="mode" value="${param.mode}" />
    <table border="1" width="90%">
        <tr>
            <td>비밀번호 검증!</td>
            <td>
                <input type="password" name="pass" style="width:100px;" />
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="submit">검증하기</button>
                <button type="reset">RESET</button>
                <button type="button" onclick="location.href='${pageContext.request.contextPath}/mvcboard/list.do';">
                    목록으로
                </button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>