<%@ page contentType="text/html;charset=gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
	<title>�������</title>
	<script type="text/javascript" src="dwr/engine.js"></script>
	<script type="text/javascript" src="dwr/util.js"></script>
	<script type="text/javascript" src="dwr/interface/UserDAOAjax.js"></script>
	<script type="text/javascript">
    function show(boolean){
    	if(boolean){
    		alert("�û��Ѿ�����!");
    	}
    }
    function validate(){
    	var name=document.all.name.value;
    	if(name == ""){
    		alert("�û�������Ϊ��!");
    		return;
    	}
    	UserDAOAjax.existUser(name,show);
    }
	</script>
</head>
<body>
	<!-- ���� head.jsp -->
	<jsp:include page="head.jsp"></jsp:include>
	<div class=content>
		<div class=left>
			<div class=list_box>
				<div class=list_bk>
					<!-- ִ�� browseCatalog �� Action�����ѽ����ʾ�ڸ�λ�ã��� action �Ĺ�������ʾ���е�ͼ�����ͣ��ù��ܻ��ں��潲������ͬ -->
					<s:action name="browseCatalog" executeResult="true" />
				</div>
			</div>
		</div>
		<div class=right>
			<div class=right_box>
				<div class=info_bk1>
					<div align="center">
						<form action="register" method="post" name="form1">
							�û�ע��
							<br>
							�û�����<input type="text" id="name" name="user.username" size=20 onblur="validate()" />
							<br>
							��&nbsp;&nbsp;&nbsp;&nbsp;�룺
							<input type="password" name="user.password" size=21 />
							<br>
							��&nbsp;&nbsp;&nbsp;&nbsp;��
							<input type="text" name="user.sex" size=20 />
							<br>
							��&nbsp;&nbsp;&nbsp;&nbsp;�䣺
							<input type="text" name="user.age" size=20 />
							<br>
							<input type="submit" value="ע��">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>
