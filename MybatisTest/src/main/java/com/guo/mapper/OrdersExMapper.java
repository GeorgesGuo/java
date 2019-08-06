package com.guo.mapper;

import com.guo.po.Orders;
import com.guo.po.OrdersEx;

import java.util.List;

public interface OrdersExMapper {
    public List<OrdersEx> queryOrderUser() throws Exception;

    public List<Orders> queryOrderUserResultMap() throws Exception;
}
