package com.jobsAutomatic.dao;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class DaoSupport {
	@Resource
	JdbcTemplate jdbcTemplate;
	@Resource
	JdbcTemplate jdbcTemplate2;
	Logger logger = Logger.getLogger(DaoSupport.class);
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public JdbcTemplate getJdbcTemplate2() {
		return jdbcTemplate2;
	}
	public void setJdbcTemplate2(JdbcTemplate jdbcTemplate2) {
		this.jdbcTemplate2 = jdbcTemplate2;
	}
}
