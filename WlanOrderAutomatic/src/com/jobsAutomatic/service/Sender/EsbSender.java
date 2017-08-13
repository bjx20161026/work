package com.jobsAutomatic.service.Sender;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.message.SOAPHeaderElement;
import org.springframework.stereotype.Component;

@Component
public class EsbSender {
//	@Value("${esb.endpoint}")
	private String esbEndPoint;
//	@Value("${esb.systemcode}")
	private String esbSystemCode;
//	@Value("${esb.authcode}")
	private String esbAuthCode;
//	@Value("${esb.operation}")
	private String esbOperation;
	private ThreadLocal<Integer> ldc=new ThreadLocal<Integer>(){
		public Integer initialValue(){
			return 0;
		}
	};	
	public Object send(String serviceCode,String msg) throws Exception {
		Integer times=ldc.get();
		Object result=null;
		Service service=new Service();
		Call call=null;
		call = (Call) service.createCall();
		SOAPHeaderElement serviceEle = new SOAPHeaderElement(new QName("cn.com.boco.HermesService","ServiceCode"),serviceCode);
		SOAPHeaderElement userEle = new SOAPHeaderElement(new QName("cn.com.boco.HermesService","UserName"),esbSystemCode);
		SOAPHeaderElement authEle = new SOAPHeaderElement(new QName("cn.com.boco.HermesService","AuthCode"),esbAuthCode);
		call.addHeader(serviceEle);
		call.addHeader(userEle);
		call.addHeader(authEle);
		call.setTargetEndpointAddress(esbEndPoint);
		call.setOperation(esbOperation);
		try{
		result=call.invoke(new Object[]{msg});
		}catch(Throwable t){
			Thread.sleep(1000);
			if(times>50){
				return result;
			}
			ldc.set(times+1);
			result=send(serviceCode, msg);
		}finally{
			ldc.remove();
		}
		return result;
	}

	public String getEsbEndPoint() {
		return esbEndPoint;
	}

	public void setEsbEndPoint(String esbEndPoint) {
		this.esbEndPoint = esbEndPoint;
	}

	public String getEsbSystemCode() {
		return esbSystemCode;
	}

	public void setEsbSystemCode(String esbSystemCode) {
		this.esbSystemCode = esbSystemCode;
	}

	public String getEsbAuthCode() {
		return esbAuthCode;
	}

	public void setEsbAuthCode(String esbAuthCode) {
		this.esbAuthCode = esbAuthCode;
	}

	public String getEsbOperation() {
		return esbOperation;
	}

	public void setEsbOperation(String esbOperation) {
		this.esbOperation = esbOperation;
	}
	
	public static void main(String[] args) {
//		ProxoolDataSource ds = new ProxoolDataSource();
//		ds.setDriver("oracle.jdbc.driver.OracleDriver");
//		ds.setDriverUrl("jdbc:oracle:thin:@10.221.247.44:1521/ipms");
//		ds.setUser("ipmsdm");
//		ds.setPassword("SHipmsdm!23$");
//		JdbcTemplate jt=new JdbcTemplate(ds);
//		String sql=  "select to_char(MSG_CONTENT) from ipmsds.META_DT_MSG_send_RECORD where send_time_stamp>sysdate-1 and call_result like '-8;The service does not%'  order by send_time_stamp desc";
//		List<String> datas=jt.queryForList(sql, String.class);
		EsbSender es=new EsbSender();
		es.setEsbAuthCode("8a875cc3-001f-4d57-856a-27c5e55efe3c");
		es.setEsbEndPoint("http://10.221.213.148:7080/Hermes/services/HermesService?wsdl");
//		es.setEsbEndPoint("http://10.222.5.7:9080/eoms35/services/DataNetService?wsdl");
		
		es.setEsbOperation("replyWorkSheet");
		es.setEsbSystemCode("WLAN_APP");
		
		try {
			System.out.println(es.send("DATA.STATIC.ORDER.WLAN_FK.EOMS_APP",new Receipt().SendReceipt("SH-206-170323-00002", "成功", "")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
