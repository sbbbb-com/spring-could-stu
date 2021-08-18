package com.yyesw.springcloud.service.impl;

import com.yyesw.springcloud.dao.StorageDao;
import com.yyesw.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/18
 * <br/>Time: 16:46
 */

@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    // 扣减库存
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageDao.decrease(productId, count);
        log.info("------->storage-service中扣减库存结束");

    }
}
