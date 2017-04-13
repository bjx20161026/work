/*
 * IpScopeFieldHandler.java was created on 12-6-10 ����10:53
 *
 * Copyright (c) 2012 EASTCOM Software Technology Co.,Ltd. All rights reserved.
 */
package com.jobsAutomatic.service.readExcle;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jobsAutomatic.service.util.AbstractFieldHandler;


public class IpScopeFieldHandler extends AbstractFieldHandler<String, String[]> {
    public static final String IP_SCOPE_REGEX = "^((\\d|\\d\\d|[0-1]\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|\\d\\d|[0-1]\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|\\d\\d|[0-1]\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|\\d\\d|[0-1]\\d\\d|2[0-4]\\d|25[0-5])\\-(\\d|\\d\\d|[0-1]\\d\\d|2[0-4]\\d|25[0-5]))$";

    @Override
    protected String[] converter(String value) {
        String networkIp = value.substring(0, value.lastIndexOf("."));
        String start = networkIp +"."+ value.substring(value.lastIndexOf(".") + 1, value.lastIndexOf("-"));
        String end = networkIp +"."+ value.substring(value.lastIndexOf("-") + 1);
        String[] ipScope = new String[]{start, end};
        return ipScope;
    }

    @Override
    protected boolean validator(String value) {
        Pattern pattern = Pattern.compile(IP_SCOPE_REGEX);
        Matcher matcher = pattern.matcher(value);
        if (matcher.matches()) {
            return true;
        } else {
            this.setErrorMsg("格式错误，单个或多个地址格式均为‘117.131.97.31-254'");
            return false;
        }
    }
}
