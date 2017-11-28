package com.gray.base.quartz;

import java.util.Date;


public class EmailSend{

	public void execute(){
		// TODO 发送邮件的一些操作
		System.out.println("Timed task execution...Current time is: "+new Date(System.currentTimeMillis()));
	}

}
