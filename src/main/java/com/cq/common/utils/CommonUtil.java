/*
* 文 件 名:  CommonUtil.java
* 版    本:  Baseline 2.0
* 描    述:  <提供各种转换工具函数>
* 创 建 人:  luoxh
* 创建时间:  Aug 15, 2013
* CQ 单号:  <CQ单号>
* 修改内容:  <添加注释>
*/
package com.cq.common.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <提供各种转换工具函数>
 * <功能详细描述>
 *
 * @author  luoxh
 * @version  [Baseline 2.0, Aug 15, 2013]
 */
public class CommonUtil {

    /** <将一个集合转换成字符串的形式>
    * <功能详细描述>
    * @param list   待转换的集合
    * @return       转换后的字符串
    */
    public static String listToString(List<Object> list) {
        String result = CommonUtil.listToString(list, ",");
        return result;
    }


    /** <将一个集合转换成字符串的形式>
    * <功能详细描述>
    * @param list     待转换的集合
    * @param splitor  分割器(将集合中的各项分割开来)
    * @return         转换后的字符串
    */
    public static String listToString(List<Object> list, String splitor) {
        String result = "";
        int i=0, j=list.size();
        Iterator<Object> li = list.iterator();
        while(li.hasNext()) {
            Object item = li.next();
            result += String.valueOf(item);
            if(i++!=(j-1)) {
                result += splitor;
            }
        }
        return result;
    }

	/** <将时间字符串转换成yyyy-MM-dd HH:mm:ss格式>
	* <功能详细描述>
	* @param str    待转换的时间字符串
	* @return       outDate:成功转换后的时间;null:转换失败(字符串非法或字符串为空)
	*/
	public static Date StringToFullDate(String str) {
		if (str == null) {
			return null;
		}
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date outDate = formatter.parse(str);
			return outDate;
		} catch (Exception e) {
			return null;
		}
	}

	/** <将时间转换成字符串>
	* <功能详细描述>
	* @param date   待转换时间
	* @return       outDate:转换成功后的字符串;null:转换失败(错误的时间或时间为空)
	*/
	public static String dateToString(Date date) {
		if (date == null) {
			return null;
		}
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String outDate = formatter.format(date);
			return outDate;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * <将IP转换成长整型>
	 *  <功能详细描述>
	 * @param strIP 待转换IP
	 * @return longIP:转换成功后的长整型;null:转换失败(错误的IP)
	 */
	public static Long IpToLong(String strIP) {
		Long longIP = null;
		String regex = "(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(strIP);

		if (matcher.find()) {
			Long ip1 = new Long(matcher.group(1));
			Long ip2 = new Long(matcher.group(2));
			Long ip3 = new Long(matcher.group(3));
			Long ip4 = new Long(matcher.group(4));

			if ((ip1.longValue() <= 255L) && (ip1.longValue() >= 0L)
					&& (ip2.longValue() <= 255L) && (ip2.longValue() >= 0L)
					&& (ip3.longValue() <= 255L) && (ip3.longValue() >= 0L)
					&& (ip4.longValue() <= 255L) && (ip4.longValue() >= 0L)) {
				longIP = Long.valueOf((ip1.longValue() << 24) + (ip2.longValue() << 16) + (ip3.longValue() << 8) + ip4.longValue());
			}
		}

		return longIP;
	}

	/**
	 * <将IP长整型表达式转换成点分表达式>
	 * <功能详细描述>
	 * @param longIP 待转换IP长整型表达式
	 * @return strIP:转换成功后的点分表达式;"":转换失败(错误的IP)
	 */
	public static String LongToIp(Long longIP) {
		String strIP = "";

		if ((longIP.longValue() <= 4294967295L) && (longIP.longValue() > 0L)) {
			strIP = strIP + String.valueOf(longIP.longValue() >>> 24);
			strIP = strIP + ".";
			strIP = strIP + String.valueOf((longIP.longValue() & 0xFFFFFF) >>> 16);
			strIP = strIP + ".";
			strIP = strIP + String.valueOf((longIP.longValue() & 0xFFFF) >>> 8);
			strIP = strIP + ".";
			strIP = strIP + String.valueOf(longIP.longValue() & 0xFF);
		}

		return strIP;
	}
	
	/**
	 * 根据IDs获取
	* @param ids
	* @return
	* @date  Dec 2, 2013
	 */
	public static List<Long> getCreateIdListById(String ids) {
		//对资产的ID进行组装成List
		String[] idStr = ids.split(",");
		List<Long> assetidList = new ArrayList<Long>();
		for(int i=0;i<idStr.length;i++){
			assetidList.add(Long.parseLong(idStr[i]));
		}
		//获取创建者的ID
		return assetidList;

	}
}
