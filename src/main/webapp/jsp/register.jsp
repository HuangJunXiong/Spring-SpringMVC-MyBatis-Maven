<%@ page language="java"  contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册页</title>
<script src="../js/jquery.js" type="text/javascript"></script>
</head>
<body>
<form id="info" action="../doregister.do" method="post">
<table>
	<tr>
		<td><label>用户名</label></td>
		<td><input type="text" name="username"
			style="width: 120;" /></td>
	</tr>
	<tr>
		<td><label>密&nbsp;码</label></td>
		<td><input type="password" name="password"
			style="width: 120;" /></td>
	</tr>
    <tr>
        <td><label>姓&nbsp;名</label></td>
        <td><input type="text" name="name"
            style="width: 120;" /></td>
    </tr>
    <tr>
        <td><label>邮&nbsp;箱</label></td>
        <td><input type="text" name="email"
            style="width: 120;" /></td>
    </tr>
	<tr>
		<td><input id="registerBtn" type="button" name="login" value="注册" /></td>
		<td><span id="errMsg"></span></td>
	</tr>
</table>
</form>
<script type="text/javascript">
$(function() {
    $('#registerBtn').click(function(){
        $('#errMsg').html("");
        var user = $('#info').serialize();
        $.post('../register.do',user,function(data){
            if(hasSucc(data)){
                window.location = "../index.jsp";
            }else{
                $('#errMsg').html(data.error);
            }
        });
    });
});
function hasSucc(data){console.info(data.success);
    if(data.success != null )return true;
}
</script>
</body>
</html>