package com.liuwill.demo.controller;

import com.liuwill.demo.service.DemoService;
import com.liuwill.demo.service.DemoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/10/26.
 */
@RestController
public class DemoController {
    @Autowired
    private DemoService demoService;

    @Autowired
    private DemoUserService demoCommonService;

    @RequestMapping("/demo")
    public Map index() {
        Map resultMap = new HashMap();
        resultMap.put("status","success");
        resultMap.put("content",demoService.getString());
        return resultMap;
    }

    @RequestMapping(value = "/mobile/{mobile:.+}", method = RequestMethod.GET)
    public Object getSingleLoanItem(@PathVariable("mobile") String mobile) {
        Map resultMap = new HashMap();
        resultMap.put("status","success");
        resultMap.put("content",demoCommonService.getUserByMobile(mobile));
        return resultMap;
    }
}
