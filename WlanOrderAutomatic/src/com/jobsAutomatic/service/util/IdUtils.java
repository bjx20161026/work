/*
 * IdUtils.java was created on 12-6-3 ����5:06
 *
 * Copyright (c) 2012 EASTCOM Software Technology Co.,Ltd. All rights reserved.
 */
package com.jobsAutomatic.service.util;


/**
 * Created with IntelliJ IDEA.
 * User: wjhu
 * Date: 12-6-3
 * Time: ����5:06
 * To change this template use File | Settings | File Templates.
 */
public class IdUtils {
    /**
     * �������һ��UUID
     * @return
     */
    public static String GeneratorUUID(){
        UUIDHexGenerator gen = new UUIDHexGenerator();
        return (String) gen.generate();
    }
}
