package com.atguigu.spring.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class OrderController {

    //private static final String Payment_URL = "http://localhost:8003";
    public static final String Payment_URL = "http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "consumer/payment/create")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(Payment_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping(value = "consumer/payment/get/{id}")
    public CommonResult get(@PathVariable long id){
        return restTemplate.getForObject(Payment_URL+"/payment/getPaymentById/"+id,CommonResult.class,id);
    }

    @GetMapping(value = "consumer/payment/delete/{id}")
    public String delete(@PathVariable long id){
        restTemplate.delete(Payment_URL+"/payment/delete/"+id,id);
        return "删除成功";
    }

    @GetMapping(value = "consumer/payment/update")
    public String update(Payment payment){
        restTemplate.put(Payment_URL+"/payment/update",payment);
        return "修改成功";
    }

    @GetMapping(value = "consumer/payment/getAll")
    public List<Payment> getAll(){
        return restTemplate.getForObject(Payment_URL+"/payment/getAll",List.class);
    }
}
