package com.jobsAutomatic.service.util;



import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Logger;


/**
 * @author hm
 *  @
 */
public class IpUtil {
	private static final Logger logger = Logger.getLogger("ipnet.rm");
	@SuppressWarnings("unused")
	private static final String validLetters = "abcdefghijklmnopqrstuvwxyz0123456789";
	@SuppressWarnings("unused")
	private static final Random rand = new Random();
	public static String compare(String oldString, String newString) {
		if (oldString != null && oldString.trim().equals("")) {
			oldString = null;
		}
		if (newString != null && newString.trim().equals("")) {
			newString = null;
		}
		if (oldString == null && newString == null) {
			return null;
		} else if (oldString == null) {
			return "null -> " + newString;
		} else if (newString == null) {
			return oldString + " -> null";
		} else if (oldString.equals(newString)) {
			return null;
		} else {
			return oldString + " -> " + newString;
		}
	}
	public static String compare(int oldInt, int newInt) {
		if (oldInt == newInt) {
			return null;
		} else {
			return oldInt + " -> " + newInt;
		}
	}
	public static String compare(Date oldDate, Date newDate) {
		if (oldDate == null && newDate == null) {
			return null;
		} else if (oldDate == null) {
			return "null -> " + new Timestamp(newDate.getTime());
		} else if (newDate == null) {
			return new Timestamp(oldDate.getTime()) + " -> null";
		} else if (oldDate.equals(newDate)) {
			return null;
		} else {
			return new Timestamp(oldDate.getTime()) + " -> " + new Timestamp(newDate.getTime());
		}
	}
	public static String appendCompare(String compareLog, String title, String newCompareLog) {
		if (newCompareLog == null) {
			return compareLog;
		} else if (compareLog == null) {
			return newCompareLog;
		} else {
			return compareLog + "��" + title + "��" + newCompareLog + "��";
		}
	}
	/**
	 * �������Ƿ��ǺϷ���ip��ַ�Σ�0��255��
	 * 
	 * @param i
	 * @return
	 */
	public static boolean validIpSection(int i) {
		return i < 0 || i > 255;
	}

	/**
	 * ���ַ����Ƿ��ǺϷ���ip��ַ�Σ�0��255��
	 * 
	 * @param s
	 * @return
	 */
	public static boolean validIpSection(String s) {
		if (s == null || s.trim().equals(""))
			return false;
		try {
			int i = Integer.parseInt(s);
			if (i < 0 || i > 255)
				return false;
			else
				return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
	/**
	 * ĳ����ת��Ϊ�ַ����磺128ת��Ϊ"10000000"
	 * @param i
	 * @return
	 */
	private static String ipSection2Binary(int ipsec) {
		String binary = Integer.toBinaryString(ipsec);
		while (binary.length() < 8) {
			binary = "0" + binary;
		}
		return binary;
	}
	/**
	 * ��ʮ����ip��ַ��ת��Ϊ������ip��ַ������1.1.1.1ת��Ϊ��"00000001.00000001.00000001.00000001"
	 * @param ipaddr
	 * @return
	 */
	public static String ip2BinaryString(String ipaddr) {
		StringTokenizer st = new StringTokenizer(ipaddr, ".");
		String result = null;
		while (st.hasMoreTokens()) {
			if (result== null) {
				result = "";
			} else {
				result += ".";
			}
			result += ipSection2Binary(Integer.parseInt(st.nextToken()));
		}
		return result;
	}

	/**
	 * ��ip��ַת��Ϊ������
	 * 
	 * @param ip
	 *            String
	 * @return long
	 */
	public static long ip2Long(String ip) {
		StringTokenizer st = new StringTokenizer(ip, ".");
		long returnIP = 0;
		if (st.countTokens() != 4) {
			return -1;
		}
		while (st.hasMoreTokens()) {
			returnIP = (returnIP << 8) + Integer.parseInt(st.nextToken());
		}
		return returnIP;
	}

	/**
	 * �ѳ�����ת��Ϊip��ַ
	 * 
	 * @param ip
	 *            long
	 * @return String
	 */
	public static String long2Ip(long ip) {
		String partString = "";
		long ipTemp = ip;
		long ipPart = -1;
		while (true) {
			ipPart = ipTemp % 256;
			ipTemp = ipTemp >> 8;
			partString = String.valueOf(ipPart) + "." + partString;
			if (ipTemp < 1) {
				break;
			}
		}
		return partString.substring(0, partString.length() - 1);
	}

	/**
	 * �ṩһ��һ��ĵ�ַ����192.168.1.250�����Լ�����ĳ��ȣ���24�����õ������ַ����192.168.1.0��
	 * 
	 * @param len
	 * @return
	 */
	public static long getNetworkAddr(long generalAddr, int maskLength) {
		return generalAddr & (long)(Math.pow(2, 32) - 1 - (Math.pow(2, 32 - maskLength) - 1));
	}
	public static long[] getAvailableNetwork(String startIp, String endIp, int maskLength) {
		long startNetwork = getNetworkAddr(ip2Long(startIp), maskLength);
		long endNetwork = getNetworkAddr(ip2Long(endIp), maskLength);
		long step = (long)Math.pow(2, 32 - maskLength);
		int count = (int)((endNetwork - startNetwork) / step);
		long[] result = new long[count + 1];
		for(int i = 0; i <= count ; i++) {
			result[i] = startNetwork;
			startNetwork += step;
		}
		return result;
	}
	/**
	 * �������ε�ַ��������Ҫ���������볤�ȣ���ÿ�ʹ�õ�������ַ
	 * @param networkAddr ���ε�ַ
	 * @param networkMaskLength �������볤��
	 * @param subnetMaskLength �������볤��
	 * @return
	 */
	public static long[] getAvailableSubnet(String networkAddr, int networkMaskLength, int subnetMaskLength) {
		int count = (int)Math.pow(2, subnetMaskLength - networkMaskLength);
		long[] result = new long[count];
		for (int i = 0; i < count; i++) {
			result[i] = ip2Long(networkAddr) + (long)(i * Math.pow(2, 32 - subnetMaskLength));
		}
		return result;
	}
	public static int getMinMaskLength(String segAddr) {
		long addr = ip2Long(segAddr);
		int i = 32;
		for (; i > 8; i--) {
			int remain = 32 - i;
			long weight = (long)Math.pow(2, remain + 1);
			if (addr % weight != 0) {
				break;
			}
		}
		return i;
	}

	public static void main(String[] args) {
//		long start = ipToLong("192.168.13.210");
//		System.out.println("start:" + start);
//		long start2 = ipToLong("192.168.14.51");
//		System.out.println("start2:" + start2);
		System.out.println(long2Ip(getNetworkAddr(ip2Long("192.168.1.250"), 30)));
		//System.out.println(ipSection2Binary(0));
		System.out.println(getMinMaskLength("255.255.255.253"));
	}
	/**
	 * ����������ַ�����룬������е����µ�ip��ַ
	 * @param subnetAddr
	 * @param maskLength
	 * @return
	 */
	public static long[] getAvailableIpAddr(String subnetAddr, int maskLength) {
		int count = (int)Math.pow(2, 32 - maskLength);
		long[] result = new long[count];
		for (int i = 0; i < count; i++) {
			result[i] = ip2Long(subnetAddr) + i;
		}
		return result;
	}
	  /**
	   * �������ε���ʼip��ַ�����볤�ȣ������ֹip��ַ
	   * @param ip String
	   * @param maskLength int
	   * @return String
	   */
	  public static String getDestinationIp(String startIp, int maskLength) {
	    long startIpLong = ip2Long(startIp);
	    startIpLong >>>= (32 - maskLength);
	    startIpLong <<= (32 - maskLength);
	    startIpLong += Math.pow(2, 32 - maskLength) - 1;
	    return long2Ip(startIpLong);
	  }
	  public static void displayMessage(@SuppressWarnings("rawtypes") HashMap message) {
	  	@SuppressWarnings("rawtypes")
		Set keySet = message.keySet();
	  	@SuppressWarnings("rawtypes")
		Iterator itor = keySet.iterator();
	  	while (itor.hasNext()) {
	  		Object key = itor.next();
	  		Object value = message.get(key);
	  		logger.info(key + " = " + value);
	  	}
	  }
}