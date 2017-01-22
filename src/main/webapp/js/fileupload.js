// 设置图片上传
function setFileUpload() {
	new AjaxUpload($('#upload'), {
		data:{
			"filenameId":$('#clientNo').val(),
			"width":153,
			"height":54,
		},
		action: "../common/uploadTempImg.do",
		name: "fileUpload",
		onSubmit: function(file, ext){
			if (!(ext && /^(gif|jpg|jpeg|png)$/.test(ext))){
	            // extension is not allowed
				alert("只能上传gif|jpg|jpeg|png格式文件！");
				return false;
			}
			var  fileInput = document.getElementsByName('fileUpload')[0];
			  if(!/msie/.test(navigator.userAgent.toLowerCase())){
				if(fileInput!=null && fileInput.value!=""){
					if(fileInput.files[0].size>1*1048576){
			        	alert("上传公司Logo图片文件不能超过1M！");
			        	return false;
			        }
				}
			}
			//disable保存操作按钮
			$('#upload').attr("disabled",true);
			$('#delPic').attr("disabled",true);
			$('#upload').linkbutton({text:'上传中...'});
		},
		onComplete: function(file, data){
			$('#upload').attr("disabled",false);
			$('#delPic').attr("disabled",false);
			$('#upload').linkbutton({text:'上传Logo'});
			
			data = (eval("("+data+")")).data;
			console.log(data);
			if (hasSucc_body_msg(data)) {
	        	$('#delPic').css('display','');
				//刷新图片的url
				data = data.data;
				$('#imgpic').attr("src", data+"?timestamp=" + (new Date()).valueOf());
				$('#clientLogo').val(data.substring(data.lastIndexOf('.'), data.length));
			} else {
				alert(data.error);
			}
		}
	});
}

// 删除上传的临时文件
function deletePic() {
	var ext = $("#clientLogo").val();
	var filename=$("#clientNo").val()+ext;
	if (HRMCommon.isEmpty(ext)) {
		filename = "";
	}
	
	if(ext==null || ext==""){
		$.messager.alert('提示', '上传图片有误，请刷新后重试！', 'info');
		return false;
	}
	var filename=$("#clientNo").val()+ext;
	$.messager.confirm('提示','您确定要删除吗？',function(r){
		if (r){
			$.ajax({ // 4.提交
			    type: "post",   
			    url: "../common/deleteTempFile.do",
				data: {"fileName":filename, "toPath":"comp_images"},  
			    datatype: "json",
			    success:function(data){ // 5.返回结果
					$('#imgpic').attr("src", "");
					$('#clientLogo').val("");
					$('#delPic').css('display','none');
			    }
			});
		}
	});
}
