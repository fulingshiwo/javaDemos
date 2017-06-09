/*
* 文 件 名:  Validators.java
* 版    本:  Baseline 2.0
* 描    述:  <验证用户输入的各种类型的数据是否合法>
* 创 建 人:  luoxh
* 创建时间:  Aug 15, 2013
* CQ 单号:  <CQ单号>
* 修改内容:  <添加注释>
*/
package com.cq.common.utils;

import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

/**
 * <验证用户输入的各种类型的数据是否合法>
 * <功能详细描述>
 *
 * @author  luoxh
 * @version  [Baseline 2.0, Aug 15, 2013]
 */
public class Validators {


    /** <判断端口号,是否为整数并且位数小于6>
    * <端口号可以为空>
    * @param exstr  待判断的端口号
    * @param top    系统最大端口号
    * @return       true:合法端口号;false:非法端口号
    */
    public static boolean isValidateNum(String exstr,int top){
      if(exstr.equals("")){
         return true;
      }
      try{
         int num = Integer.parseInt(exstr);
         if(num>0 && num <top){
             return true;
         }else{
        	 return false;
         }
      }
      catch(Exception e){
          return false;
      }
   }


    /** <判断字符串是否为纯数字>
    * <功能详细描述>
    * @param tester  待判断字符串
    * @return        true：是纯数字 false：不是纯数字
    */
    public static boolean isNumeric(String tester) {
        boolean isNumeric=false;
        if(tester==null || tester.equals("")) {
            isNumeric=false;
            return isNumeric;
        }
        if(Pattern.matches("^(-)?\\d+$", tester)) {
            isNumeric = true;
        }
        return isNumeric;
    }


    /** <判断时间格式是否满足 yyyy-mm-dd hh:mm:ss>
    * <功能详细描述>
    * @param datetime  待判断的时间
    * @return          true:正确的时间格式;false:错误的时间格式
    */
    public static boolean isDateTime(String datetime){
        datetime = datetime.trim();
        try {
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(datetime);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /** <比较两个日期大小>
    * <判断开始时间是否小于等于结束时间>
    * @param startDate     开始时间
    * @param endDate       结束时间
    * @return              true:是;false:否
    */
    public static boolean dataCommpare(String startDate, String endDate){
        if(startDate.equals("")||endDate.equals("")){
           return false;
        }
        String[] sdatetime = startDate.split("\\ ");
        String[] edatetime = endDate.split("\\ ");
        String[] sdate = sdatetime[0].split("\\-");
        String[] edate = edatetime[0].split("\\-");

        if(Integer.parseInt(sdate[0])>Integer.parseInt(edate[0])){
            return false;
        }else if(Integer.parseInt(sdate[0])==Integer.parseInt(edate[0])){
            if(Integer.parseInt(sdate[1])>Integer.parseInt(edate[1])){
                return false;
            }else if(Integer.parseInt(sdate[1])==Integer.parseInt(edate[1])){
                if(Integer.parseInt(sdate[2])>Integer.parseInt(edate[2])){
                    return false;
                }else if(Integer.parseInt(sdate[2])==Integer.parseInt(edate[2])){
                    String stime = sdatetime[1].replaceAll(":","");
                    String etime = edatetime[1].replaceAll(":","");
                    if(Integer.parseInt(stime)>Integer.parseInt(etime)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /** <判断字符串是否满足要求>
    * <字符串只能包含中文、数字、字母>
    * @param str      待判断字符串
    * @return         true:合法字符串;false:非法字符串
    */
    public static boolean isValidateString(String str){
        String exp = "^[\u4e00-\u9fa5a-zA-Z0-9]+$";
        if(str.matches(exp)){
            return true;
        }
        return false;
    }


    /** <判断字符串是否为时间>
    * <功能详细描述>
    * @param date   待判断字符串
    * @return      true:是时间;false:不是时间
    */
    public static boolean isDate(String date) {
        date = date.trim();
        try {
            new SimpleDateFormat("yyyy-MM-dd").parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /** <判断字符串是否不为空>
    * <功能详细描述>
    * @param  tester  待判断字符串
    * @return            true:不为空;false:为空
    */
    public static boolean isNotnull(String tester) {
        boolean isNotnull=false;

        if(tester!=null && !tester.trim().equals("")) {
            isNotnull=true;
        }

        return isNotnull;
    }

    /** <判断字符串是否为空>
     * <功能详细描述>
     * @param validatee   待判断字符串
     * @return            true:为空;false:不为空
     */
    public static boolean isNull(String validatee) {
        if(null == validatee || "".equals(validatee.trim())) {
            return true;
        }
        return false;
    }

    /** <判断对象是否为空>
    * <功能详细描述>
    * @param validatee   待判断对象
    * @return            true:为空;false:不为空
    */
    public static boolean isNull(Object validatee) {
        if(null == validatee) {
            return true;
        }
        return false;
    }

    /** <判断对象是否不为空>
    * <功能详细描述>
    * @param validatee   待判断对象
    * @return            true:不为空;false:为空
    */
    public static boolean isNotnull(Object validatee) {
        return !Validators.isNull(validatee);
    }

    /** <判断邮箱地址是否合法>
    * <功能详细描述>
    * @param email     待判断的邮箱地址
    * @return          true:合法的邮箱地址;false:非法的邮箱地址
    */
    public static boolean isEmail(String email) {
        boolean isEmail=false;
        String regex1 = "^([a-zA-Z0-9_\\.\\-\\+])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
        String regex2 = "^([a-zA-Z0-9_\\.\\-\\+])+\\@(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})+$";
        String regex3 = "^([a-zA-Z0-9_\\.\\-\\+])+\\@([a-zA-Z0-9\\-\\_])+$";
        if(    Pattern.matches(regex1, email)
            || Pattern.matches(regex2, email)
            || Pattern.matches(regex3, email)) {
            isEmail=true;
        }
        return isEmail;
    }

    /** <判断用户名是否合法>
    * <用户名由数字,英文和下划线组成,同时长度大于5>
    * @param username     待判断的用户名
    * @return             true:合法的用户名;false:非法的用户名
    */
    public static boolean isUsername(String username) {
        boolean isUsername=true;
        if(Pattern.matches("[a-zA-Z0-9_]{3,30}$", username) && username.length()<3) {
            isUsername=true;
        }
        return isUsername;
    }

    /** <判断IP地址是否合法>
    * <功能详细描述>
    * @param ipstr   待判断的IP地址
    * @return        true:合法的IP地址;false:非法的IP地址
    */
    public static boolean isIPAddress(String ipstr) {
        ipstr = ipstr.trim();
        String regex = "^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$";

        if(!ipstr.matches(regex)){
            return false;
        }

        String[] ips = ipstr.split("\\.");

        for(int i=0 ; i<4; i++){
            int num = Integer.parseInt(ips[i]);
            if(num<0 || num>255){
                return false;
            }
        }

        return true;
    }

    /** <验证输入的对象是不是货币格式>
    * <功能详细描述>
    * @param currency   字符串
    * @return           true:是货币格式;false:不是货币格式
    */
    public static boolean isCurrency(String currency) {

        boolean isCurrency=false;
        if(Pattern.matches("^(-)?\\d+(\\.\\d+)?", currency)) {
            isCurrency=true;
        }
        return isCurrency;
    }

    /**<验证输入字符串是否为IP/掩码格式>
     *
     * @param ipstr
     * @return
     */
	public static boolean isIpSubnet(String ipstr) {
		if (isNull(ipstr)) {
			return false;
		}

		ipstr = ipstr.trim();
		String regex = "^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\/\\d{1,2}$";

		if (!ipstr.matches(regex)) {
			return false;
		}

		String[] ips = ipstr.split("\\.");
		for (int i = 0; i < 4; i++) {
			if (i == 3) {
				String[] temp = ips[i].split("/");
				int tempnum1 = Integer.parseInt(temp[0]);
				int tempnum2 = Integer.parseInt(temp[1]);

				if (tempnum1 < 0 || tempnum1 > 255 || tempnum2 < 0 || tempnum2 > 32) {
					return false;
				}
				continue;
			}

			int num = Integer.parseInt(ips[i]);
			if (num < 0 || num > 255) {
				return false;
			}
		}

		return true;
	}

	public static boolean isIP(String ip) {

    	if(!isNotnull(ip)) return false;

    	if(isIPv4(ip) || isIPv6(ip) || isIP4in6(ip)) {
    		return true;
    	}

    	return false;
    }

    public static boolean isIPv4(String ipv4) {

    	if(!isNotnull(ipv4)) return false;
    	ipv4 = ipv4.trim();
        String regex = "^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$";

        if(!ipv4.matches(regex)){
            return false;
        }

        String[] ips = ipv4.split("\\.");

        for(int i=0 ; i<4; i++){
            int num = Integer.parseInt(ips[i]);
            if(num<0 || num>255){
                return false;
            }
        }

        return true;
    }

    public static boolean isIPv6(String ipv6) {
    	if(!isNotnull(ipv6)) return false;
    	ipv6 = ipv6.trim();
        boolean result = false;
        String regHex = "(\\p{XDigit}{1,4})";
        String regIPv6Full = "^(" + regHex + ":){7}" + regHex + "$";
        String regIPv6AbWithColon = "^(" + regHex + "(:|::)){0,6}" + regHex
                + "$";
        String regIPv6AbStartWithDoubleColon = "^(" + "::(" + regHex
                + ":){0,5}" + regHex + ")$";
        String regIPv6 = "^(" + regIPv6Full + ")|("
                + regIPv6AbStartWithDoubleColon + ")|(" + regIPv6AbWithColon
                + ")$";

        if (ipv6.indexOf(":") != -1) {

        	if (ipv6.length() <= 39) {
                String addressTemp = ipv6;
                int doubleColon = 0;

                while (addressTemp.indexOf("::") != -1) {
                    addressTemp = addressTemp.substring(addressTemp
                            .indexOf("::") + 2, addressTemp.length());
                    doubleColon++;
                }

                if (doubleColon <= 1) {
                    result = ipv6.matches(regIPv6);
                }
            }
        }

        return result;
    }

    public static boolean isIP4in6(String ip) {
    	if(!isNotnull(ip)) return false;
    	ip = ip.trim();
    	String reg = "：^([\\da-fA-F]{1,4}:){6}((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$|^::([\\da-fA-F]{1,4}:){0,4}((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$|^([\\da-fA-F]{1,4}:):([\\da-fA-F]{1,4}:){0,3}((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$|^([\\da-fA-F]{1,4}:){2}:([\\da-fA-F]{1,4}:){0,2}((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$|^([\\da-fA-F]{1,4}:){3}:([\\da-fA-F]{1,4}:){0,1}((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$|^([\\da-fA-F]{1,4}:){4}:((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$";
    	return ip.matches(reg);
    }

    /**
     * 判断是否是标准的url地址
     * @param url
     * @return true ：是标准的url地址　false : 不是标准的url地址
     */
    public static boolean isUrl(String url) {
    	if(!isNotnull(url)) return false;
    	url = url.trim();
    	String regexHttp = "((http://)?([a-z]+[.])|(www.))\\w+[.]([a-z]{2,4})?[[.]([a-z]{2,4})]+((/[\\S&&[^,;\u4E00-\u9FA5]]+)+)?([.][a-z]{2,4}+|/?)";
    	String regexHttps = "((https://)?([a-z]+[.])|(www.))\\w+[.]([a-z]{2,4})?[[.]([a-z]{2,4})]+((/[\\S&&[^,;\u4E00-\u9FA5]]+)+)?([.][a-z]{2,4}+|/?)";
    	if(url.matches(regexHttp)){
    		return true;
    	}
    	if(url.matches(regexHttps)){
    		return true;
    	}
    	return false;
    }

}
