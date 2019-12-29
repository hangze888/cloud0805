package com.atguigu.springcloud.dao;


import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentDao {

    public void create(Payment payment);

    public Payment getPaymentById(long id);

    public void delete(Long id);

    public void update(Payment payment);

    public List<Payment> getAll();
}
