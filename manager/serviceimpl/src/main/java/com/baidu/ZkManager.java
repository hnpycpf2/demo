package com.baidu;/**
 * @Author chupengfei
 * @Date 2020/5/14 17:33
 */

import com.baidu.utils.ZookeeperUtil;
import org.I0Itec.zkclient.ZkClient;

/**
 * @Description: TODO
 * @Author dell
 * @Date 2020/5/14
 **/
public class ZkManager {

    public static ZkClient zkClient;

    static
    {
        zkClient = new ZkClient(ZookeeperUtil.connectString, ZookeeperUtil.sessionTimeout);
    }

    public static ZkClient getInstance()
    {
        return zkClient;
    }
}
