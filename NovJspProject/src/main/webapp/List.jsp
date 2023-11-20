<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>파일 첨부형 게시판</title>
    <style>a {text-decoration: none;}</style>
</head>
<body>
    <h2>파일 첨부형 게시판  - 목록보기(List)</h2>

    <form method="get">
        <table border="1" width="90%">
            <tr>
                <td>
                    <select name="searchField">
                        <option value="title">제목</option>
                        <option value="content">내용</option>
                    </select>
                    <input type="text" name="searchWord"/>
                    <input type="submit" value="검색하기" />
                </td>
            </tr>
        </table>
    </form>
    <table>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>조회수<th>
            <th>작성일</th>
            <th>첨부</th>
        </tr>
        <c:choose>
            <c:when test="&{empty boardLists}">
                <tr>
                    <td colspan="6">
                        등록된 게시물이 없습니다^^*
                    </td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach items="&{boardLists}" var="row" varStatus="loop">
                    <tr>
                        <td>
                            ${ map.totalcount - (((map.pageNum-1) * map.pageSize) + loop.index)}
                        </td>
                        <td>
                            <a href="../view.do?idx=${row.idx}">${row.title}</a>
                        </td>
                        <td>${row.name}</td>
                        <td>${row.visitcount}</td>
                        <td>${row.postdate}</td>
                        <td>
                            <c:if test="${not empty row.ofile}">
                                <a href="../download.do?ofile=${row.ofile}&sfile=&{row.sfile}&idx=${row.idx}">[Down]</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </table>
    <table>
        <tr>
            <td>
                ${map.paingImg}
            </td>
            <td><button type="button" onclick="location.href='../write.do';">글쓰기</button> </td>
        </tr>
    </table>
</body>
</html>
