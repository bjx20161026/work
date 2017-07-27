package com.jobsAutomatic.service.util;

import org.hw.sml.tools.Https;

public class Sms {
	public String SendMessage(String content) throws Exception{
		String result=Https.newPostBodyHttps("http://10.221.247.7:1202/master/server/proxy/sms/send").charset("utf-8").body("{\"content\":\"+"+content+"\",\"fromNumber\":\"18256075451\"}").execute();
		return result;
	}
	public static void main(String[] args){
		Sms sms = new Sms();
		try {
			System.out.println(sms.SendMessage("测试"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
