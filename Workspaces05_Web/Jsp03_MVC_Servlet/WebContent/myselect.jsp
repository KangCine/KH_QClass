<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@page import="com.mvc.biz.MVCBoardBizImpl"%>
<%@page import="com.mvc.biz.MVCBoardBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>

<script type="text/javascript">
	function deleteProc(seq){
		if(confirm(seq+"번 글을 삭제하시겠습니까?")){
			location.href="myservlet.do?command=delete&seq="+seq;
		}
	}
</script>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%	
	MVCBoardDto dto = (MVCBoardDto) request.getAttribute("dto");
%>
</head>
<body>

	<h1>SELECT</h1>

	<table border="1">
		<tr>
			<th>작성자</th>
			<td><%=dto.getWriter() %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%=dto.getTitle() %></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea cols="50px" rows="30px" readonly="readonly"><%=dto.getContent() %></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="수정" onclick="location.href='myservlet.do?command=update&seq=<%=dto.getSeq()%>'">
				<input type="button" value="삭제" onclick="deleteProc(<%=dto.getSeq()%>);">
				<input type="button" value="목록" onclick="location.href='myservlet.do?command=list'">
			</td>
		</tr>
	</table>

</body>
</html>