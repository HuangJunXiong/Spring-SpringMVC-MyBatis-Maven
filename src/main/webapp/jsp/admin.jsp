<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/fileupload.js" ></script>
<title>文件上传Demo</title>
</head>
<body>
	<div>
		<ul>
			<li>用户Logo：
				<div style="height:90px;width:153px">
					<div class="client_logo" id="pic" style="text-align:center">
						<input type="hidden" id="clientLogo_db" name="clientLogo_db" value="${(cli.clientLogo)!''}"/>
						<img src="${(user.userLogo)!''}" id="imgpic" />
						<div class="file-box" style="text-align:center;">
							<a id="upload" href="javascript:void(0)" class="easyui-linkbutton" style="width:66px;height:30px;">上传Logo</a>
							<label id="delPic" style="margin-left:10px;margin-top:10px;display:none">
								<a onclick="deletePic()" title="删除图片" href="#">
									<i class="icon-remove" style="color:red;font-size:22px;"></i>
								</a>
							</label>
						</div>
					</div>
				</div>
			</li>
		</ul>   
	</div>
</body>
<script type="text/javascript">
$(function(){
	// 设置图片上传事件
	setFileUpload();
	
	// 修改clientLogo，设置为文件名的后缀；显示删除图片按钮
	var clientLogo = $('#clientLogo_db').val();
	if (HRMCommon.isNotEmpty(clientLogo)) {
		$('#clientLogo').val(clientLogo.substring(clientLogo.lastIndexOf('.'), clientLogo.length));
		$('#delPic').css('display','');
	}
	
});
</script>
</html>