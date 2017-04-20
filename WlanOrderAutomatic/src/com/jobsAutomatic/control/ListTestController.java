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
import com.jobsAutomatic.dao.OperateWorkOrder;
import com.jobsAutomatic.service.modle.QueryCondition;
import com.jobsAutomatic.service.modle.ReplyWorkOrder;
import com.jobsAutomatic.service.modle.WorkOrder;
import com.jobsAutomatic.service.tempRetire.OrderClassify;

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
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			queryCondition.setWorkjob_type(null);
		}
		queryCondition.setSend_time(Request.getParameter("send_time"));
		queryCondition.setFinishtime(Request.getParameter("finishtime"));
		queryCondition.setStatement(Request.getParameter("statement"));
		queryCondition.setWorkjob_id(Request.getParameter("workjob_id"));
		queryCondition.setWorkjob_type(Request.getParameter("workjob_type"));
		queryCondition.setLimit(Request.getParameter("limit"));
		queryCondition.setStart(Request.getParameter("start"));
		System.out.println("workjob_id---->>>>>"+Request.getParameter("workjob_id"));
		System.out.println("workjob_type---->>>>>"+Request.getParameter("workjob_type"));
		System.out.println("Send_time---->>>>>"+Request.getParameter("Send_time"));
		System.out.println("finishtime---->>>>>"+Request.getParameter("finishtime"));
		System.out.println("statement---->>>>>"+Request.getParameter("statement"));
		System.out.println("limit---->>>>>"+Request.getParameter("limit"));
		System.out.println("start---->>>>>"+Request.getParameter("start"));
//		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
//		QueryCondition queryCondition = gson.fromJson(code, QueryCondition.class);
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
		OrderClassify orderClassify = new OrderClassify();
		orderClassify.setJdbcTemplate(jdbcTemplate);
		return orderClassify.DoClassify(workOrders);
	}

	@RequestMapping(value = "/download", produces = "application/octet-stream;charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<byte[]> download(HttpServletRequest  request) throws IOException {
		String filePath = new String(request.getParameter("localFile").getBytes("iso-8859-1"),"utf-8");
//		String filePath = request.getParameter("localFile");
		System.out.println("localFile---->>>>"+request.getParameter("localFile"));
		File file = new File(filePath);// "../logs/SpringMVC.log"
		String dfileName = file.getName();
		System.out.println(dfileName);
//		dfileName=URLEncoder.encode(dfileName, "UTF-8");
		dfileName = new String(dfileName.getBytes("utf-8"),"iso-8859-1");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", dfileName);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
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
