<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html public "-//w3c//dtd html 4.01 transitional//en" 
"http://www.w3c.org/tr/1999/rec-html401-19991224/loose.dtd">
<html>
<head>
	<title>���Ϲ���ϵͳ</title>
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
				<font face=����></font><font face=����></font><font face=����></font><font face=����></font>
				<div class=banner></div>
				<div class=info_bk1>
					<div align="center">
						<form action="login" method="post" name="login">
							�û���¼
							<br>
							�û�����
							<input type="text" name="user.username" size=20 id="username">
							<br>
							��&nbsp;&nbsp;&nbsp;&nbsp;�룺
							<input type="password" name="user.password" size=21	id="username">
							<br>
							<input type="submit" value="��¼">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>
