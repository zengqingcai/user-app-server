package com.user.app.utils;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class HttpClientConfig {

    /**
     *
     */
    public static String ENCODING = "UTF-8";

    /**
     *
     */
    public static String CONTENT_TYPE="application/x-www-form-urlencoded";

    /**
     *
     */
    public static final int MAX_TOTAL = 60;

    /**
     *
     */
    public static final int MAX_PER_ROUTE = 5;

    /**
     *  链接超时
     */
    public static final int CONNECT_TIMEOUT = 20 * 1000;

    /**
     * socket
     */
    public static final int SOCKET_TIMEOUT = 20 * 1000;

    /**
     * 重试次数
     */
    public static final int RETRY_NUM = 8;

    /**
     * 日度累计游客量上报接口
     */
    public static String gateDayUrl = "https://59.63.125.21:10080/upload-data/tourist/real-gate-day";

    /**
     * 当天实时累计游客量上报接口
     */
    public static String peopleNumberUrl = "https://59.63.125.21:10080/upload-data/tourist/real-people-number";

    /**
     * 当天实时累计游客出园人数上报接口
     */
    public static String exitPeopleNumberUrl = "https://59.63.125.21:10080/upload-data/tourist/real-exit-people-number";

    /**
     *浏览器调试页面地址
     */
    public static String debugUrl = "https://59.63.125.21:10080/upload-data/api-doc.html";

    /**
     * 请求头设置
     * appKey:Xr-DYKjdAFqAwf-1cvXcaVpG5WUMkKPwqPRorgA-3aQ
     * @return
     */
    public static Map<String, String> getHeaders(){
        Map<String, String> headers = new HashMap<>();
        headers.put("appKey","Xr-DYKjdAFqAwf-1cvXcaVpG5WUMkKPwqPRorgA-3aQ");
        return headers;
    }
}
