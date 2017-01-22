package com.gray.common.controller;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.gray.util.FileOperate;

@Controller
@RequestMapping("/common")
public class CommController {
	private final Logger logger = LoggerFactory.getLogger(CommController.class);
	/**
	 * 上传图片到服务器
	 * @param filenameId
	 * @param mFile
	 * @return
	 */
	@RequestMapping("/uploadTempImg.do")
	@ResponseBody
	public String uploadTempImg(String filenameId, int width, int height, @RequestParam("fileUpload") CommonsMultipartFile mFile) {
		String msgParamError = "上传照片失败，请刷新后重试！";
		String msgPhotoMaxSize = "上传照片不能超过2M！";
		String msgFail = "上传照片失败！";

		// 异常处理，参数错误
		if (StringUtils.isEmpty(filenameId) || mFile.isEmpty()) {
			return msgParamError;
		}
		
		// 初始化图片提示信息
		if (mFile != null) {
			long fileSize = mFile.getFileItem().getSize();
			if (fileSize > 1024*1024*2) {
				return msgPhotoMaxSize;
			}
		}

		// 图片上传到temp目录
	    try {
			String urlPath = FileOperate.compressPic(mFile, width, height, filenameId);
			return urlPath;
		} catch (Exception e) {
			logger.error(msgFail, e);
			return msgFail;
		}
	}
}
