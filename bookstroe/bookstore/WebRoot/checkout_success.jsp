<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
	<title>网上购书系统</title>
	<link href="css/bookstore.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="/head.jsp"></jsp:include>
	<div class=content>
		<div class=left>
			<div class=list_box>
				<div class=list_bk>
					<s:action name="browseCatalog" executeResult="true" />
				</div>
			</div>
		</div>
		<div class=right>
			<div class=right_box>
				<div class="info_bk1">
					<div align="center">
						<h3>订单添加成功</h3>
						<s:property value="#session.user.username" />
						  ,您的订单已经下达, 订单号<s:property value="#request.order.orderid" />
						  ,我们会在三日内寄送图书给您!<br><br>
						  <a href="logout.action">退出登录</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/foot.jsp"></jsp:include>
</body>
</html>
