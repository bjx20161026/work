package com.jobsAutomatic.test;

import java.io.IOException;
import java.io.InputStream;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

import com.jobsAutomatic.dao.WlanDaoImpl;
import com.jobsAutomatic.service.modle.PingListParam;
import com.jobsAutomatic.service.modle.RMDevice;

import ipnet.nhm.commandCenter.taskMgr.FPTaskMgrInf;
import ipnet.nhm.commandCenter.taskObject.FPTask;


public class PingListConfigAction {
	
	public void addSwitchPingListTaskBySwitchIds(Object[] switchIds){
		PingListParam param = new PingListParam();
		Properties pro=new Properties();
		InputStream is=this.getClass().getClassLoader().getResourceAsStream("pingSwitchListParameter.properties");
		try {
			pro.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		param.setParam_id((String) pro.get("ping.switch.param_id"));
		param.setParam_name((String) pro.get("ping.switch.param_name"));
		param.setPacket_count(Integer.parseInt((String) pro.get("ping.switch.packet_count")));
		param.setPacket_size(Integer.parseInt((String) pro.get("ping.switch.packet_size")));
		param.setTimeout(Integer.parseInt((String) pro.get("ping.switch.timeout")));
		param.setFrequency(Integer.parseInt((String) pro.get("ping.switch.frequency")));
		param.setRetry_times(Integer.getInteger((String) pro.get("ping.switch.retry_times")));
		PingListConfigAction configAction = new PingListConfigAction();
		List<RMDevice> deviceList = configAction.getRMDeviceByIP(StringUtils.join(switchIds, ","));
		int validIPs = configAction.importTasks(param, deviceList);//失败
		int invalidIPs = switchIds.length - validIPs;//成功 
		String msg = "导入IP:"+invalidIPs+"条<br>丢弃IP:"+validIPs+"条";
		System.out.println(msg);
	}
	/*
	 * 根据IP获取设备
	 */
	public List<RMDevice> getRMDeviceByIP(String ips){
		List<RMDevice> deviceList = new ArrayList<RMDevice>();
		WlanDaoImpl wlanDaoImpl = new WlanDaoImpl();
		String[] ipArr = ips.split(",");
		for(int i=0;i<ipArr.length;i++){
			String ip = ipArr[i];
			RMDevice device = wlanDaoImpl.getRMDeviceByIP(ip);
			if(device!=null){
				deviceList.add(device);
			}
		}
		return deviceList;
	}
	/*
	 * 导入task
	 */
	public int importTasks(PingListParam param,List<RMDevice> deviceList){
		int validTasks = 0;
		int failtcount =0;
		WlanDaoImpl wlanDaoImpl = new WlanDaoImpl();
		String url = wlanDaoImpl.getFPTaskMgrInf();
		FPTaskMgrInf tm = null;
		try {
			tm = (FPTaskMgrInf) Naming.lookup(url);
			if (tm == null)
				System.out.println("没有找到远程fpTask服务对象");
			else
				System.out.println("找到远程fpTask服务对象");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
//		FPTaskMgrInf tm = wlanDaoImpl.getFPTaskMgrInf();
		ArrayList<FPTask> taskList = new ArrayList<FPTask>();
		try{
			for(int i=0;i<deviceList.size();i++){
				RMDevice device = deviceList.get(i);
				if(device.getCOLLECTOR_ID()==null){
					continue;
				}
				FPTask task = new FPTask();
				task.setTaskID(device.getDEVICE_ID());
				task.setProbeUuid(device.getCOLLECTOR_ID());
				task.setFrequency(param.getFrequency());
				task.setPacketCount(param.getPacket_count());
				task.setPacketSize(param.getPacket_size());
				task.setParamId(param.getParam_id());
				task.setDevType(device.getDEVICE_TYPE());
				task.setTargetUuid(device.getDEVICE_ID());
				task.setTargetAlias(device.getALIAS());
				task.setTargetIp(device.getIP_ADDR());
				task.setTargetName(device.getSYS_NAME());
				task.setTimeOut(param.getTimeout());
				taskList.add(task);
				validTasks++;
			}
		String a[] = tm.addTasks(taskList);
		int countone =deviceList.size()-validTasks;//第一次过滤失败条数
		String count= a [0];
		failtcount=	Integer.parseInt(count)+countone;
		}catch(Exception e){
			e.printStackTrace();
		}
		return failtcount;
	}
	public static void main(String[] args){
//		PingListConfigAction pingListConfigAction = new PingListConfigAction();
//		pingListConfigAction.addSwitchPingListTaskBySwitchIds();
		
		
	}
	
}
