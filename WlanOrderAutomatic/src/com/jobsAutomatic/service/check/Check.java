package com.jobsAutomatic.service.check;

import java.util.Arrays;


public abstract class Check {
	String[] districts={"宝山","长宁","崇明","奉贤","虹口","黄浦","嘉定","金山","静安","卢湾","南汇","普陀","浦东新区","青浦","松江","徐汇","杨浦","闸北","闵行"};
	String[] cities={"东区","西区","南区","北区","宝山","崇明","奉贤","嘉定","金山","南汇","青浦","松江","闵行"};
		
	public boolean isContainsElement(Object[] collection,Object element){
		return Arrays.asList(collection).contains(element);
	}
}
