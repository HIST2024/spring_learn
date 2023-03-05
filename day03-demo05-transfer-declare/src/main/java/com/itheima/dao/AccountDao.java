package com.itheima.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface AccountDao {
    //转出
    @Update("update account set money = money - #{money} where id = #{outId}")
    int outMoney(@Param("outId") int outId, @Param("money")double money);
    //转入
    @Update("update account set money = money + #{money} where id = #{inId}")
    int inMoney(@Param("inId") int inId, @Param("money")double money);
}
