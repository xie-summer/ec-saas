package com.yjg.ec.platform.erp.integration.auth.util;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * IP校验
 */
public class IPUtils {
    /**
     * ip校验
     *
     * @param s
     * @return Boolean
     */
    public static Boolean isIpAddress(String s) {
        String regex = "(((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        return m.matches();
    }

    /**
     * 获取客户端ip
     *
     * @param request
     * @return String
     */
    public static String getClientAddress(HttpServletRequest request) {
        String address = request.getHeader("X-Forwarded-For");
        if (address != null && isIpAddress(address)) {
            return address;
        }
        return request.getRemoteAddr();
    }
}
