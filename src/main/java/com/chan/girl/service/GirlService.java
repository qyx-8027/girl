package com.chan.girl.service;

import com.chan.girl.domain.Girl;

public interface GirlService {
    //添加两个girl
    int saveTwoGirl();
    //根据主键拿取girl的age信息
    int getGirlAgeByPrimaryKey(Integer id) throws Exception;
    //根据主键拿取girl的信息
    Girl getGirlByPrimaryKey(Integer id);
}
