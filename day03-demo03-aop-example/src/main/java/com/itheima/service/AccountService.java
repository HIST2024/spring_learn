package com.itheima.service;

/**
 * @author codermao
 * @date 2023/2/21 20:10
 */
public interface AccountService {
    //有返回值
    String findAll();

    String findById(Integer id);
    //有参数
    void insert(String str);

    void update();
    void delete();
}
