package com.atguigu.springcloud.service;


import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;


import javax.annotation.Resource;
import java.util.List;


public interface PaymentService {

    public void create(Payment payment);

    public Payment getPaymentById(long id);

    public void update(Payment payment);

    public void delete(Long id);

    public List<Payment> list();
}
