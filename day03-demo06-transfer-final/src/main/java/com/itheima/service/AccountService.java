package com.itheima.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

public interface AccountService {
    @Transactional(
            isolation = Isolation.DEFAULT,
            timeout = 10,
            readOnly = false
    )
    void transfer(int outId,int inId,double money);
}
