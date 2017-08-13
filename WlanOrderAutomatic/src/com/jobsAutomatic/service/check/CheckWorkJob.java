package com.jobsAutomatic.service.check;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.jobsAutomatic.service.modle.WorkJob;

@Service
public class CheckWorkJob extends Check{
public WorkJob workJob;

public String CheckWork(){
	String str="";
	if(workJob.getWorkjob_id()==null){
		str+=";工单流水号不能为空";
	}
	if(workJob.getSend_time()==null||workJob.getHandle_time()==null){
		if(workJob.getSend_time()==null){
			str+=";派单时间不能为空";
		}
		if(workJob.getHandle_time()==null){
			str+=";处理时限不能为空";
		}
	}else{
	      SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
	      try {
			Date dateH = format.parse(workJob.getHandle_time());
			Date dateS = format.parse(workJob.getSend_time()); 
			if(dateH.getTime()<=dateS.getTime()){
				str+=";处理时限必须在下发时间之后";	
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}  
	}
	if(workJob.getLocation()==null){
		str+=";属地分公司不能为空";
	}else if(!isContainsElement(cities, workJob.getLocation())){
		str+=";所属分公司不在[东区,西区,南区,北区,宝山,崇明,奉贤,嘉定,金山,南汇,青浦,松江,闵行]范围内";
	}
	if(workJob.getArea()==null){
		str+=";行政区域不能为空";
	}else if(!isContainsElement(cities, workJob.getLocation())){
		str+=",行政区域不在[宝山,长宁,崇明,奉贤,虹口,黄浦,嘉定,金山,静安,卢湾,南汇,普陀,浦东新区,青浦,松江,徐汇,杨浦,闸北,闵行]范围内";
	}
	return str;
}

public WorkJob getWorkJob() {
	return workJob;
}

public void setWorkJob(WorkJob workJob) {
	this.workJob = workJob;
}
}
