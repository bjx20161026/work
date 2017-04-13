package com.jobsAutomatic.control;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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

	@RequestMapping(value = "/getOrderByCondition", method = RequestMethod.POST)
	public @ResponseBody List<WorkOrder> getOrderByCondition(@RequestBody String code) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		QueryCondition queryCondition = gson.fromJson(code, QueryCondition.class);
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

	@RequestMapping(value = "/download", produces = "application/octet-stream;charset=UTF-8", method = RequestMethod.POST)
	public ResponseEntity<byte[]> download(@RequestBody String code) throws IOException {
		WorkOrder workOrders = new Gson().fromJson(code, WorkOrder.class);
		String filePath = workOrders.getLocalfile();
		File file = new File(filePath);// "../logs/SpringMVC.log"
		String dfileName = "SpringMVC.log";
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
