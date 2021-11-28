package com.gy.springcloud.alibaba.service;

import com.gy.springcloud.alibaba.dao.StorageDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("  ------> Storage Service decrease start <------  ");
        storageDao.decrease(productId, count);
        log.info("  ------> Storage Service decrease end <------  ");
    }
}
