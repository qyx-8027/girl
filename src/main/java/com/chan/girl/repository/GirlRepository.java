package com.chan.girl.repository;

import com.chan.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,Integer>{


    /*
    * 通过年龄查询girl
    * */
    List<Girl> findByAge(Integer age);

    /*
    * 通过罩杯查询girl
    * */
    List<Girl> findByCupSize(String cupSize);

}
