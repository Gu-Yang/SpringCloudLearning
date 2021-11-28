package com.gy.springcloud.alibaba.service.impl;

import com.gy.springcloud.alibaba.dao.AccountDao;
import com.gy.springcloud.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("  ------> Account Service Amount decrease start <------  ");
        //模拟超时异常，全局事务回滚
        //暂停几秒钟线程
//        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
        accountDao.decrease(userId,money);
        log.info("  ------> Account Service Amount decrease end <------  ");
    }
}
