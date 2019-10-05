<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
						您好!用户 <s:property value="user.username" />  恭喜您注册成功! <a href="login.jsp">登录</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>
