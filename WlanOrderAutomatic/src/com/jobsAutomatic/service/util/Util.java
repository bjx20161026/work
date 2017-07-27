package com.jobsAutomatic.service.util;

import java.text.SimpleDateFormat;
import java.util.List;

import com.jobsAutomatic.service.common.Common;
import com.jobsAutomatic.service.modle.UpdateSql;

public class Util {
	/**
	 * @param path
	 * @return
	 */
	public static String getPostfix(String path) {
		if (path == null || Common.EMPTY.equals(path.trim())) {
			return Common.EMPTY;
		}
		if (path.contains(Common.POINT)) {
			return path.substring(path.lastIndexOf(Common.POINT) + 1, path.length());
		}
		return Common.EMPTY;
	}

	public UpdateSql getUpdateSql(String columnName, Object obj, String var) {
		UpdateSql us = new UpdateSql();
		us.setColumnName(columnName);
		us.setValue(obj);
		us.setVar(var);
		return us;
	}

	public String getUpdate(String sql, List<UpdateSql> list) {
		for (UpdateSql us : list) {
			if (us.getValue() != null) {
				if (us.getVar().equals("VARCHAR")) {
					sql += us.getColumnName() + "='" + us.getValue() + "',";
				} else if (us.getVar().equals("DECIMAL")) {
					sql += us.getColumnName() + "=" + us.getValue() + ",";
				} else if (us.getVar().equals("DATE")) {
					String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(us.getValue());
					sql += us.getColumnName() + "=to_date('" + date + "','SYYYY-MM-DD HH24:MI:SS'),";
				}
			}
		}
		return sql.substring(0, sql.length() - 1);
	}

	public String getWhere(String sql, List<UpdateSql> list) {
		for (UpdateSql us : list) {
			if (us.getValue() != null&&!us.getValue().equals("")) {
				if (us.getVar().equals("VARCHAR")) {
					sql += us.getColumnName() + "='" + us.getValue() + "' and ";
				} else if (us.getVar().equals("DECIMAL")) {
					sql += us.getColumnName() + "=" + us.getValue() + " and ";
				} else if (us.getVar().equals("DATE")) {
					String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(us.getValue());
					sql += us.getColumnName() + "=to_date('" + date + "','SYYYY-MM-DD HH24:MI:SS') and ";
				} else if (us.getVar().equals("DATE2")) {
					sql += us.getColumnName() + "=to_date('" + us.getValue() + "','SYYYY-MM-DD HH24:MI:SS') and ";
				} else if (us.getVar().equals("LIKE")) {
					sql += "upper(" + us.getColumnName() + ") like upper('%" + us.getValue() + "%') and ";
				} else if (us.getVar().equals("NOTLIKE")) {
					sql += us.getColumnName() + " not like '%" + us.getValue() + "%' and ";
				}
			}
		}
		if (!sql.equals(""))
			sql = sql.substring(0, sql.length() - 5);
		return sql;
	}
}
