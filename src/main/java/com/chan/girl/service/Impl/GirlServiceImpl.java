package com.chan.girl.service.Impl;

import com.chan.girl.domain.Girl;
import com.chan.girl.emuns.ResultEmun;
import com.chan.girl.exception.GirlException;
import com.chan.girl.service.GirlService;
import com.chan.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class GirlServiceImpl implements GirlService{

    @Autowired
    private GirlRepository girlRepository;

    //添加两个girl
    @Override
    public int saveTwoGirl() {
        Girl GirlA = new Girl("A",11,100);
        Girl GirlB = new Girl("B",12,120);
        int count = 0;
        Girl A = girlRepository.save(GirlA);
        count++;
        int i = 1/0;
        Girl B = girlRepository.save(GirlB);
        count++;
        return count;
    }

    @Override
    public int getGirlAgeByPrimaryKey(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        int age = girl.getAge();
        if(age < 10) {
            throw new GirlException(ResultEmun.PRIMARY_SCHOOL);
        }
        if(age < 14){
            throw new GirlException(ResultEmun.MIDDLE_SCHOOL);
        }
        if(age < 17) {
            throw new GirlException(ResultEmun.HIGHT_SCHOOL);
        }
        return age;
    }

    @Override
    public Girl getGirlByPrimaryKey(Integer id) {
        return girlRepository.findOne(id);
    }


}