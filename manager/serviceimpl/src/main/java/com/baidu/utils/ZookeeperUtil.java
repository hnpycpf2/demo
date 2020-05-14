package com.baidu.utils;

public class ZookeeperUtil {

    /** zookeeper服务器地址 */
    public static final String connectString = "182.61.139.206:2181,182.61.139.206:2182,182.61.139.206:2183";
    /** 定义session失效时间 */
    public static final int sessionTimeout = 5000;
    public static final String ROOT_PATH = "/clusterLock";


}