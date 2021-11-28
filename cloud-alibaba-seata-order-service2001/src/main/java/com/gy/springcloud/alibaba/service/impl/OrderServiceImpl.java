package com.gy.springcloud.alibaba.service.impl;

import com.gy.springcloud.alibaba.dao.OrderDao;
import com.gy.springcloud.alibaba.domain.Order;
import com.gy.springcloud.alibaba.service.AccountService;
import com.gy.springcloud.alibaba.service.OrderService;
import com.gy.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StorageService storageService;
    @Autowired
    private AccountService accountService;

    @Override
    @GlobalTransactional
    public void create(Order order) {
        log.info("------> 1. Create new order <------");
        orderDao.create(order);

        log.info("------> 2. Reduce the number of storage <------");
        storageService.decrease(order.getProductId(), order.getCount());

        log.info("------> 3. Reduce the amount of account <------");
        accountService.decrease(order.getUserId(), order.getMoney());

        log.info("------> 4. Update the status of order <------");
        orderDao.update(order.getUserId(), 0);

        log.info("------> 5. Done <------");
    }
}
