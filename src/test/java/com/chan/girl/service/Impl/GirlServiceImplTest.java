package com.chan.girl.service.Impl;

import com.chan.girl.domain.Girl;
import com.chan.girl.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceImplTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void getGirlByPrimaryKey() throws Exception {
        Girl girl = girlService.getGirlByPrimaryKey(8);
        Assert.assertEquals(new Integer(18),girl.getAge());
    }

}