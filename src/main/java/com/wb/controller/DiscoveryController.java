package com.wb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/discovery")
public class DiscoveryController {

    @Autowired
    private DiscoveryClient discoveryClient;



    // 从nacos中获取某服务信息
    @RequestMapping("/getServerList")
    @ResponseBody
    public List<ServiceInstance> getServerList(){
        return discoveryClient.getInstances("spring-boot-provider");
    }
}
