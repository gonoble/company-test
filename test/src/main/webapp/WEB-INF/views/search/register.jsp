<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file = "../include/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form role="form" method="post">
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">주문번호</label>
				<input type="text" name="order_num" class="form-control" placeholder="Enter order_num">
			</div>
			
			<div class="form-group">
				<label for="exampleInputEmail1">보내는 사람</label>
				<input type="text" name="sender" class="form-control" placeholder="Enter sender">
			</div>
			
			<div class="form-group">
				<label for="exampleInputEmail1">받는 사람</label>
				<input type="text" name="receiver" class="form-control" placeholder="Enter receiver">
			</div>
			
			<div class="form-group">
				<label for="exampleInputEmail1">수량</label>
				<input type="text" name="quantity" class="form-control" placeholder="Enter quantity">
			</div>
			
			<div class="form-group">
				<label for="exampleInputEmail1">상품</label>
				<input type="text" name="p_name" class="form-control" placeholder="Enter p_name">
			</div>
			
			<div class="form-group">
				<label for="exampleInputEmail1">집하지점</label>
				<input type="text" name="c_point" class="form-control" placeholder="Enter c_point">
			</div>
			
			<div class="form-group">
				<label for="exampleInputEmail1">배송지점</label>
				<input type="text" name="s_point" class="form-control" placeholder="Enter s_point">
			</div>
			
			<div class="form-group">
				<label for="exampleInputEmail1">주소</label>
				<input type="text" name="address" class="form-control" placeholder="Enter address">
			</div>
		</div>
		
		<div class="box-footer">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>
</body>
</html>
<%@include file = "../include/footer.jsp" %>