package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        paymentService.create(payment);
        return new CommonResult(200,"插入mysqlOK",payment);
    }

    @GetMapping(value = "/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable long id){
        Payment payment = paymentService.getPaymentById(id);
        return new CommonResult(200,"查询成功",payment);
    }

    @DeleteMapping(value = "/payment/delete/{id}")
    public void delete(@PathVariable long id){
        paymentService.delete(id);
    }

    @PutMapping(value = "/payment/update")
    public void update(@RequestBody Payment payment){
        paymentService.update(payment);
    }

    @GetMapping(value = "/payment/getAll")
    public List<Payment> getAll(){
        return paymentService.list();
    }
}
