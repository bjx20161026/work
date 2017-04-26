package com.jobsAutomatic.control;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.jobsAutomatic.dao.OperateWlanOpreateLog;
import com.jobsAutomatic.dao.OperateWorkOrder;
import com.jobsAutomatic.service.Sender.Receipt;
import com.jobsAutomatic.service.modle.QueryCondition;
import com.jobsAutomatic.service.modle.ReplyWorkOrder;
import com.jobsAutomatic.service.modle.WorkOrder;
import com.jobsAutomatic.service.tempRetire.OrderClassify;
import com.jobsAutomatic.service.util.CreatorFile;

@Controller
@RequestMapping("/workOrder")
public class ListTestController {
	Logger logger = Logger.getLogger(ListTestController.class);
	@Resource
	JdbcTemplate jdbcTemplate;
	@Resource
	JdbcTemplate jdbcTemplate2;
	@Autowired
	OperateWorkOrder operateWorkOrder;
	@Autowired
	OperateWlanOpreateLog operateWlanOpreateLog;

	@RequestMapping(value = "/test2/{name}", method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> ListTest2(@PathVariable String name) {
		System.out.println("abc");
		List<Map<String, Object>> list = jdbcTemplate2.queryForList("select * from prm_device@RES where rownum<3");
		return list;
	}

	@RequestMapping(value = "/getAllOrder", method = RequestMethod.GET)
	public @ResponseBody List<WorkOrder> getAllOrder() {
		return operateWorkOrder.getAllOrder();
	}

	@RequestMapping(value = "/getOrderByCondition", method = RequestMethod.GET)
	public @ResponseBody ReplyWorkOrder getOrderByCondition(HttpServletRequest  Request) {
		System.out.println("Request-->>"+Request.toString());
		QueryCondition queryCondition = new QueryCondition();
		queryCondition.setWorkjob_id(Request.getParameter("workjob_id"));
		try {
			queryCondition.setWorkjob_type(new String(Request.getParameter("localFile").getBytes("iso-8859-1"),"utf-8"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			queryCondition.setWorkjob_type(null);
		}
		try {
			queryCondition.setUser(new String(Request.getParameter("user").getBytes("iso-8859-1"),"utf-8"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			queryCondition.setWorkjob_type(null);
		}
		queryCondition.setSend_time(Request.getParameter("send_time"));
		queryCondition.setFinishtime(Request.getParameter("finishtime"));
		queryCondition.setStatement(Request.getParameter("statement"));
		queryCondition.setWorkjob_id(Request.getParameter("workjob_id"));
//		queryCondition.setWorkjob_type(Request.getParameter("workjob_type"));
		queryCondition.setLimit(Request.getParameter("limit"));
		queryCondition.setStart(Request.getParameter("start"));
		logger.info("获取工单列表  --->>>"+queryCondition.toString());
		operateWlanOpreateLog.Update(queryCondition.getUser(), "获取工单列表");
		return operateWorkOrder.getOrderByCondition(queryCondition);
	}
	@RequestMapping(value = "/getCountByCondition", method = RequestMethod.POST)
	public @ResponseBody int getCountByCondition(@RequestBody String code) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		QueryCondition queryCondition = gson.fromJson(code, QueryCondition.class);
		return operateWorkOrder.getCountByCondition(queryCondition);
	}
	@RequestMapping(value = "/handleOrders", method = RequestMethod.POST)
	public @ResponseBody int handleOrders(@RequestBody String code) {
		logger.error(code);
		List<WorkOrder> workOrders = jsonToArrayList(code, WorkOrder.class);
		operateWorkOrder.RecordOperate(workOrders);
		OrderClassify orderClassify = new OrderClassify();
		orderClassify.setJdbcTemplate(jdbcTemplate);
		return orderClassify.DoClassify(workOrders);
	}
	@RequestMapping(value = "/receipt", method = RequestMethod.GET)
	public @ResponseBody String Receipt(HttpServletRequest  request) throws Exception {
		String workjob_id = new String(request.getParameter("workjob_id").getBytes("iso-8859-1"),"utf-8");
		String makeResult = new String(request.getParameter("makeResult").getBytes("iso-8859-1"),"utf-8");
		String failReason = new String(request.getParameter("failReason").getBytes("iso-8859-1"),"utf-8");
		String user = new String(request.getParameter("user").getBytes("iso-8859-1"),"utf-8");
		operateWorkOrder.RecordOperate(user,workjob_id,"制作结果："+makeResult+" 原因："+failReason);
		Receipt receipt = new Receipt();
		String result = receipt.SendReceipt(workjob_id, makeResult, failReason);
			if (result!=null&&result.equals("0")){
				operateWorkOrder.Update("处理完成", 1, "", workjob_id);
				result = "回单成功";
			}
			else{
				operateWorkOrder.Update("回单失败", 2, result, workjob_id);
				result = "回单失败 : "+result;
			}
		return result;	
	}

	@RequestMapping(value = "/download", produces = "application/octet-stream;charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<byte[]> download(HttpServletRequest  request) throws IOException {
		String filePath = new String(request.getParameter("localFile").getBytes("iso-8859-1"),"utf-8");
		System.out.println("localFile---->>>>"+filePath);
		File file = new File(filePath);// "../logs/SpringMVC.log"
		String dfileName = file.getName();
		System.out.println(dfileName);
		if (request.getHeader("User-Agent").toLowerCase()  
	               .indexOf("firefox") > 0) {  
			dfileName = new String(dfileName.getBytes("utf-8"), "ISO8859-1"); // firefox浏览器  
	        } else if (request.getHeader("User-Agent").toUpperCase()  
	                .indexOf("MSIE") > 0||request.getHeader("User-Agent").toLowerCase()  
	                .indexOf("rv:11.0") > 0) {  
	        	dfileName = URLEncoder.encode(dfileName, "UTF-8");// IE浏览器  
	       }else if (request.getHeader("User-Agent").toUpperCase()  
	                .indexOf("CHROME") > 0) {  
	    	   dfileName = new String(dfileName.getBytes("utf-8"), "ISO8859-1");// 谷歌  
	        } 
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", dfileName);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
	}
	@RequestMapping(value = "/export", produces = "application/octet-stream;charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<byte[]> export(HttpServletRequest  request) throws IOException {
		String[] heads = {"workjob_id","title","worker","department","send_time","handle_time","hotspotname","shield_start","shield_end","location","area","ftp","statement","issucced","workjob_type","nasid","finishtime","receipt","include","operatetime","localfile","failed_reason","order_user"};
		QueryCondition queryCondition = new QueryCondition();
		queryCondition.setWorkjob_id(request.getParameter("workjob_id"));
		try {
			queryCondition.setWorkjob_type(new String(request.getParameter("localFile").getBytes("iso-8859-1"),"utf-8"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			queryCondition.setWorkjob_type(null);
		}
		try {
			queryCondition.setStatement(new String(request.getParameter("statement").getBytes("iso-8859-1"),"utf-8"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			queryCondition.setStatement(null);
		}
		queryCondition.setSend_time(request.getParameter("send_time"));
		queryCondition.setFinishtime(request.getParameter("finishtime"));
		queryCondition.setWorkjob_id(request.getParameter("workjob_id"));
		CreatorFile creatorFile = new CreatorFile();
		byte[] bytes = creatorFile.Creator(heads, operateWorkOrder.getAllOrderByCondition(queryCondition), request.getParameter("exportType"));
		logger.info("文件名："+new String(request.getParameter("title").getBytes("iso-8859-1"),"utf-8"));
		String dfileName =new String(request.getParameter("title").getBytes("iso-8859-1"),"utf-8")+"."+request.getParameter("exportType");
		if (request.getHeader("User-Agent").toLowerCase()  
	               .indexOf("firefox") > 0) {  
			dfileName = new String(dfileName.getBytes("utf-8"), "ISO8859-1"); // firefox浏览器  
	        } else if (request.getHeader("User-Agent").toUpperCase()  
	                .indexOf("MSIE") > 0||request.getHeader("User-Agent").toLowerCase()  
	                .indexOf("rv:11.0") > 0) {  
	        	dfileName = URLEncoder.encode(dfileName, "UTF-8");// IE浏览器  
	       }else if (request.getHeader("User-Agent").toUpperCase()  
	                .indexOf("CHROME") > 0) {  
	    	   dfileName = new String(dfileName.getBytes("utf-8"), "ISO8859-1");// 谷歌  
	        } 
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", dfileName);
		return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
	}
	
	/**
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> ArrayList<T> jsonToArrayList(String json, Class<T> clazz) {
		Type type = new TypeToken<ArrayList<JsonObject>>() {
		}.getType();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		ArrayList<JsonObject> jsonObjects = gson.fromJson(json, type);
		ArrayList<T> arrayList = new ArrayList<T>();
		for (JsonObject jsonObject : jsonObjects) {
			arrayList.add(gson.fromJson(jsonObject, clazz));
		}
		return arrayList;
	}
}
