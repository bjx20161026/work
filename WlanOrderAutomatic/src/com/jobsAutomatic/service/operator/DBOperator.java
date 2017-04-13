package com.jobsAutomatic.service.operator;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class DBOperator {
	protected DataSource dataSource;
	protected JdbcTemplate jdbcTemplate;	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
    protected String getFailureMsg(String message,int row){
        return "第"+row+"行记录导入失败："+message+"；";
    }
}
