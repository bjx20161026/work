//package com.jobsAutomatic.test;
//
//import java.io.UnsupportedEncodingException;
//
//public class Encodetest {
//	public static void main(String[] args) throws Exception{
//		String   mytext   =   java.net.URLEncoder.encode("中国",   "utf-8");     
//		   String   mytext2   =   java.net.URLDecoder.decode("%E7%83%AD%E7%82%B9%E5%8F%98%E6%9B%B4","utf-8");     
//		   System.out.println("mytext : "+mytext);
//		   System.out.println("mytext2 : "+mytext2);
//		   String a = "%E7%83%AD%E7%82%B9%E5%8F%98%E6%9B%B4";
//		try {
//			String b = new String(a.getBytes("utf-8"),"iso-8859-1");
//			System.out.println(b);
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}
