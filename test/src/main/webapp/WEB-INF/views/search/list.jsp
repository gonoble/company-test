<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file = "../include/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div class="box-body">
		<select name="searchType">
			<%-- <option value="n"
				<c:out value="${cri.searchType == null?'selected':''}"/>>---</option> --%>
			<option value="w"
				<c:out value="${cri.searchType eq 'w'?'selected':''}"/>>운송장번호</option>
			<option value="o"
				<c:out value="${cri.searchType eq 'o'?'selected':''}"/>>주문번호</option>
		</select>
	
		
		<input type="text" name="keyword" id="keywordInput" value="${cri.keyword}">
		<button id="searchBtn" class="btn btn-primary">검색</button>
		<button id="newBtn" class="btn btn-danger">등록</button>
	</div>
	
	
	<table class="table table-bordered">
		<tr>
			<th>운송장번호</th>
			<th>주문번호</th>
			<th>보내는 분</th>
			<th>받는 분</th>
			<th>수량</th>
			<th>상품명</th>
			<th>집하지점</th>
			<th>배송지점</th>
			<th>주소</th>
		</tr>
		
	<c:forEach items="${list}" var="waybillVO">
		<tr id="tbl">
			<td>${waybillVO.wb_num}</td>
			<td><a href='/search/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&wb_num=${waybillVO.wb_num}'>
				${waybillVO.order_num}</a></td>
			<td>${waybillVO.sender}</td>
			<td>${waybillVO.receiver}</td>
			<td>${waybillVO.quantity}</td>
			<td>${waybillVO.p_name}</td>
			<td>${waybillVO.c_point}</td>
			<td>${waybillVO.s_point}</td>
			<td>${waybillVO.address}</td>
		</tr>
	</c:forEach>
	
	</table>
	
	<div class="text-center">
		<ul class="pagination">
			<c:if test="${pageMaker.prev}">
				<li><a href="list${pageMaker.makeSearch(pageMaker.startPage -1)}">&laquo;</a></li>
			</c:if>
			
			<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
				<li <c:out value="${pageMaker.cri.page == idx?'class = active':''}"/>>
				<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
				</li>
			</c:forEach>
			
			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a href="list${pageMaker.makeSearch(pageMaker.endPage +1)}">&raquo;</a></li>
			</c:if>
		</ul>
	</div>
	



</body>
<script>
	var result = '${msg}';
	if(result == 'SUCCESS'){
		alert("처리가 완료되었습니다.");
	}
	
	$(document).ready(function(){
		$('#searchBtn').on("click", function(event){
			self.location ="list"
				+ '${pageMaker.makeQuery(1)}'
				+ "&searchType="
				+ $("select option:selected").val()
				+ "&keyword=" + $('#keywordInput').val();
		});
		
		$('#newBtn').on("click", function(evt){
			self.location = "/search/register";
		});	
	});

</script>
</html>

<%@include file = "../include/footer.jsp" %>