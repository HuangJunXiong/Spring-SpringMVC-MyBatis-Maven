package com.gray.base.quartz;

import java.util.Date;


public class EmailSend{

	public void execute(){
		// TODO 发送邮件的一些操作
		System.out.println("定时任务执行中...当前时间为"+new Date(System.currentTimeMillis()));
	}

}
