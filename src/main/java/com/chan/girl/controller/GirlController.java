package com.chan.girl.controller;

import com.chan.girl.Util.ResultUtil;
import com.chan.girl.domain.Girl;
import com.chan.girl.domain.Result;
import com.chan.girl.emuns.ResultEmun;
import com.chan.girl.service.GirlService;
import com.chan.girl.repository.GirlRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/girlController")
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    @Autowired
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);


    /*
    * 查询所有girl
    * */
    @GetMapping("/getGirlList")
    public List<Girl> getGirlList() {
        //System.out.println("访问/Controller/getGirlList...");
        logger.info("----访问/Controller/getGirlList...----");
        return girlRepository.findAll();
    }
    /*
    * 根据主键查询girl
    * */
    @GetMapping("/getGirlByPrimaryKey")
    public Girl getGirlByPrimaryKey(Integer id) {
        return girlRepository.findOne(id);
    }
    /*
    * 保存girl
    * 异常处理
    * */
    @PostMapping("/saveGirl")
    public Result saveGirl(@Valid Girl girl, BindingResult bindingResult) {
        Girl girl1 = girlRepository.save(girl);
        return ResultUtil.success(ResultEmun.SUCCESS,girl1);
    }
    /*
    * 修改girl
    * */
    @PutMapping("/updateGirl")
    public Girl updateGirl(Girl girl) {
        return girlRepository.saveAndFlush(girl);
    }
    /*
    * 根据主键删除girl
    * */
    @DeleteMapping("/deleteGirlByPrimaryKey")
    public void deleteGirlByPrimaryKey(Integer id) {
        girlRepository.delete(id);
    }
    /*
    * 删除girl
    * */
    @DeleteMapping("/deleteGirl")
    public void deleteGirl(Girl girl) {
        girlRepository.delete(girl);    //同样是根据对象中id删除
    }

    /*
    * 通过年龄查询girl
    * */
    @GetMapping("/selectGirlsByAge")
    public List<Girl> selectGirlsByAge(Integer age) {
        return girlRepository.findByAge(age);
    }

    /*
    * 通过罩杯查询girl
    * */
    @GetMapping("/selectGirlsByCupSize")
    public List<Girl> selectGirlsByCupSize(String cupSize) {
        return girlRepository.findByCupSize(cupSize);
    }

    /*
    * 添加两个girl
    * */
    @PostMapping("/saveTwoGirl")
    public int saveTwoGirl(){
        return girlService.saveTwoGirl();
    }

    @GetMapping("/getGirlAgeByPrimaryKey")
    public int getGirlAgeByPrimaryKey(Integer id) throws Exception {
        return girlService.getGirlAgeByPrimaryKey(id);
    }
}
