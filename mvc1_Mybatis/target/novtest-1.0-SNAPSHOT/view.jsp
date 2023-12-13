<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="board.BoardDAO" %>
<%@ page import="board.BoardDTO" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List" %>

<%
    BoardDAO dao = new BoardDAO();
    String idx = request.getParameter("idx");
    BoardDTO dto = dao.selectView(idx);

    dto.setContent(dto.getContent().replaceAll("\r\n", "<br />"));

    String ext = null, fileName = dto.getSfile();
    if (fileName != null) {
        ext = fileName.substring(fileName.lastIndexOf(".") + 1);
    }
    String[] mimeStr = {"png", "jpg", "gif", "jpeg", "PNG", "JPG", "GIF", "JPEG"};
    List<String> mimeList = Arrays.asList(mimeStr);
    boolean isImage = false;

    if (mimeList.contains(ext)) {
        isImage = true;
    }

    request.setAttribute("dto", dto);
    request.setAttribute("isImage", isImage);
%>
<html>
<head>
    <title>게시판</title>
        <style>
        table {
            width: 100%;
            border: 1px solid #444444;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #444444;
            padding: 10px;
            text-align: center;
            flex: 1;
        }
        td{
            text-align: center;
        }
        .writebtn{
            text-align: right;
        }
        .viewbtn{
            text-align: left;
        }
        .flextable{
            display: flex;
        }
        a {
            text-align: center;
            text-decoration: none; /* 링크의 밑줄 제거 */
        }

    </style>

</head>
<body>

<h2> 게시판 - 상세 보기(View)</h2>

<table>
    <colgroup>
        <col width="15%" /><col width="35%" />
        <col width="15%" /><col width="*" />
    </colgroup>

    <%--    게시글 정보--%>
    <tr>
        <td>번호</td>
        <td>${dto.idx}</td>
        <td>작성자</td>
        <td>${dto.name}</td>
    </tr>
    <tr>
        <td>작성일</td>
        <td>${dto.postdate}</td>
        <td>조회수</td>
        <td>${dto.visitcount}</td>
    </tr>
    <tr>
        <td>제목</td>
        <td colspan="3">${dto.title}</td>
    </tr>
    <tr>
        <td>내용</td>
        <td colspan="3" height="100">
            ${dto.content}
            <c:if test="${(not empty dto.ofile) and (isImage)}">
                <br><img src="../Uploads/${ dto.sfile }" style="max-width:30%;"/>
            </c:if>
        </td>
    </tr>

    <%--    하단 메뉴(버튼)--%>
    <tr>
        <td colspan="4" align="center">
            <button type="button" onclick="location.href='${pageContext.request.contextPath}/mvcboard/pass.do?mode=edit&idx=${param.idx}';">
                수정하기
            </button>
            <button type="button" onclick="location.href='${pageContext.request.contextPath}/mvcboard/pass.do?mode=delete&idx=${param.idx}';">
                삭제하기
            </button>
            <button type="button" onclick="location.href='${pageContext.request.contextPath}/list.jsp';">
                목록으로
            </button>
        </td>
    </tr>
</table>
</body>
</html>