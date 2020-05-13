package com.baidu;/**
 * @Author chupengfei
 * @Date 2020/5/11 17:00
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @Author dell
 * @Date 2020/5/11
 **/
@RestController
@ResponseBody
@RequestMapping("/")
public class Controller {

    @Autowired
    public DemoService demoService;
    @RequestMapping("index")
    public Map<String, Object> index()
    {
        String s = demoService.get();
        Map<String, Object> map = new HashMap<>();
        map.put("test", s);
        return  map;
    }
}
