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
	<form role="form" action="modifyPage" method="post">
		<input type="hidden" name="wb_num" value="${waybillVO.wb_num}">
		<input type="hidden" name="page" value="${cri.page}">
		<input type="hidden" name="perPageNum" value="${cri.perPageNum}">
		<input type="hidden" name="searchType" value="${cri.searchType}">
		<input type="hidden" name="keyword" value="${cri.keyword}">  
	
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">주문번호</label>
				<input type="text" name="order_num" class="form-control" value="${waybillVO.order_num}" readonly="readonly">
			</div>
			
			<div class="form-group">
				<label for="exampleInputEmail1">보내는 분</label>
				<input type="text" name="sender" class="form-control" value="${waybillVO.sender}" readonly="readonly">
			</div>
			
			<div class="form-group">
				<label for="exampleInputEmail1">받는 분</label>
				<input type="text" name="receiver" class="form-control" value="${waybillVO.receiver}" readonly="readonly">
			</div>
			
			<div class="form-group">
				<label for="exampleInputEmail1">수량</label>
				<input type="text" name="quantity" class="form-control" value="${waybillVO.quantity}">
			</div>
			
			<div class="form-group">
				<label for="exampleInputEmail1">상품</label>
				<input type="text" name="p_name" class="form-control" value="${waybillVO.p_name}">
			</div>
			
			<div class="form-group">
				<label for="exampleInputEmail1">집하지점</label>
				<input type="text" name="c_point" class="form-control" value="${waybillVO.c_point}">
			</div>
			
			<div class="form-group">
				<label for="exampleInputEmail1">배송지점</label>
				<input type="text" name="s_point" class="form-control" value="${waybillVO.s_point}">
			</div>
			
			<div class="form-group">
				<label for="exampleInputEmail1">주소</label>
				<input type="text" name="address" class="form-control" value="${waybillVO.address}">
			</div>
		</div>
	</form>		
		<div class="box-footer">			
			<button type="submit" class="btn btn-primary">Save</button>
			<button type="submit" class="btn btn-warning">Cancel</button>
		</div>
	
</body>
<script>
	$(document).ready(function(){
		var formObj = $("form[role='form']");
		
		console.log(formObj);
		
		$(".btn-warning").on("click", function(){
			self.location = "/search/list?page=${cri.page}&perPageNum=${cri.perPageNum}"
					+ "&searchType=${cri.searchType}&keyword=${keyword}";
		});
	
		$(".btn-primary").on("click", function(){
			formObj.submit();
		});
	
	});
</script>
</html>

<%@include file = "../include/footer.jsp" %>