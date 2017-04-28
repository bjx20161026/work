package com.jobsAutomatic.dao;

import com.jobsAutomatic.service.modle.QueryCondition;

public class Test {

	public static void main(String[] args){
		QueryCondition queryCondition = new QueryCondition();
		queryCondition.setStatement("处理完成");
		queryCondition.setWorkjob_type("热点入网");
		OperateWorkOrder operateWorkOrder = new OperateWorkOrder();
		operateWorkOrder.getOrderByCondition(queryCondition);
	}

}
