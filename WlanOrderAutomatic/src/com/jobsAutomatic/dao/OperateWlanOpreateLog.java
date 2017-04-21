package com.jobsAutomatic.dao;

import org.springframework.stereotype.Repository;

@Repository
public class OperateWlanOpreateLog extends DaoSupport{
	public int Update(String opreator,String oprate_detail){
		return jdbcTemplate.update(
				"insert into wlan_opreate_log(oprate_time,opreator,oprate_detail)values(sysdate,?,?)",
				opreator,oprate_detail);
	}
}
