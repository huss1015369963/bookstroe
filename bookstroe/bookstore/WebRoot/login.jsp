<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html public "-//w3c//dtd html 4.01 transitional//en" 
"http://www.w3c.org/tr/1999/rec-html401-19991224/loose.dtd">
<html>
<head>
	<title>网上购书系统</title>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
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
				<font face=宋体></font><font face=宋体></font><font face=宋体></font><font face=宋体></font>
				<div class=banner></div>
				<div class=info_bk1>
					<div align="center">
						<form action="login" method="post" name="login">
							用户登录
							<br>
							用户名：
							<input type="text" name="user.username" size=20 id="username">
							<br>
							密&nbsp;&nbsp;&nbsp;&nbsp;码：
							<input type="password" name="user.password" size=21	id="username">
							<br>
							<input type="submit" value="登录">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>
