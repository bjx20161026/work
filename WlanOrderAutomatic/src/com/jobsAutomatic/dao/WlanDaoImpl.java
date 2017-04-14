package com.jobsAutomatic.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.jobsAutomatic.service.modle.RMDevice;

public class WlanDaoImpl extends DaoSupport{
	public RMDevice getRMDeviceByIP(String ip) {
		String sql = "select t1.DEVICE_ID, t1.SYS_NAME, t1.IP_ADDR, t1.MAC_ADDR, t1.NETMASK, t1.GATEWAY, t1.PROVINCE, t1.CITY, "
				+ "t1.SERIAL_NUMBER, t1.SYS_LOCATION, t1.SYS_VERSION, t1.SYS_OID, t1.SYS_CONTACT, t1.SYS_UPTIME, t1.IF_NUMBER, "
				+ "t1.SOFTWARE_NAME, t1.SOFTWARE_VERSION, t1.LAST_TIMESTAMP, t1.ALIAS, t2.DEVICE_TYPE, t1.COLLECTOR_ID "
				+ "from RM_DEVICE t1 left join RM_DEVICE_TEMPLATE t2 on t1.SYS_OID=t2.SYS_OID where t1.IP_ADDR='"
				+ ip + "'";
		RowMapper<RMDevice> rowMapper = new BeanPropertyRowMapper<RMDevice>(RMDevice.class);
		RMDevice device = jdbcTemplate2.queryForObject(sql, rowMapper);	
		return device;
	}
	
	public String getFPTaskMgrInf() {
		String url = "";
		String sql = "SELECT GLOBAL_VALUE FROM IPNET_GLOBAL WHERE GLOBAL_NAME='FP_TASK_MANAGER'";
		url = jdbcTemplate2.queryForObject(sql, String.class);
		return url;		
	}
}
