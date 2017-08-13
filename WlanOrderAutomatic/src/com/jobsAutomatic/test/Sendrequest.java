package com.jobsAutomatic.test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Sendrequest {
	public String sendPost(String data)
			throws Exception {
		System.out.println("PostBody---->>>"+data);
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		PrintWriter out = null;
		String urlNameString = "http://10.221.18.29:9002/esbTransMr/msg";
		URL realUrl = new URL(urlNameString);
		URLConnection connection = realUrl.openConnection();
		connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
//		connection.setRequestProperty("connection", "Keep-Alive");
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.connect();
		out = new PrintWriter(connection.getOutputStream());
		out.print(data);
		out.flush();
		Map<String, List<String>> map = connection.getHeaderFields();
		InputStream is = connection.getInputStream();// ByteArrayOutputStream
          // 遍历所有的响应头字段
          for (String key : map.keySet()) {
              System.out.println(key + "--->" + map.get(key));
          }
//		if (map.get("Content-Type").get(0).toLowerCase().indexOf("stream") > -1) {
//			int c = is.read();
//			while (c != -1) {
//				bo.write(c);
//				c = is.read();
//			}
//			is.close();
//			String disposition = map.get("Content-Disposition").get(0);
//			String dfileName = disposition.substring(disposition.indexOf("filename=\"") + "filename=\"".length(),
//					disposition.lastIndexOf("\""));
//		} else {
			String result = "";
			BufferedReader in = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
//		}
		return result;
	}
	
	public static void main(String[] args){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@10.221.247.47:1521/ipms");
		dataSource.setUsername("IPMSDM");
		dataSource.setPassword("SHipmsdm!23$");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		for(int x=2000;x<14000;x=x+1000){
			int y = x-1000;
			String sql =" select ID,RECEIVE_TIME_STAMP,MSG_CONTENT from (select ID,RECEIVE_TIME_STAMP,MSG_CONTENT,rownum rnum from ipmsds.META_DT_MSG_RECORD where RECEIVE_TIME_STAMP<to_date('201707280300','yyyyMMddhh24mi') and RECEIVE_TIME_STAMP>to_date('201707280200','yyyyMMddhh24mi') and rownum <"+x+") where rnum>="+y;
;
		System.out.println("sql--->>>>"+sql);
			List<Map<String,Object>> list =jdbcTemplate.queryForList(sql);
		HashMap<String,Object> map;
		for(int i=0;i<list.size();i++){
			map = (HashMap<String, Object>) list.get(i);
			System.out.println(map.get("MSG_CONTENT"));
			Sendrequest sendrequest = new Sendrequest();
			try {
				String resutlt=sendrequest.sendPost((String) map.get("MSG_CONTENT"));
                System.out.println(resutlt);				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	}
}
