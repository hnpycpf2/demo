package com.baidu;/**
 * @Author chupengfei
 * @Date 2020/5/11 20:43
 */

import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author dell
 * @Date 2020/5/11
 **/
public class DemoServiceImpl  implements DemoService{

    @Override
    public String get() {

     /*JedisCluster.getInstance().set("test1", "1");*/
        String test1 = JedisCluster.getInstance().get("test1");
        return test1;
    }
}
