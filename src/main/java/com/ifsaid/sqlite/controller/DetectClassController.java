package com.ifsaid.sqlite.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ifsaid.sqlite.entity.DetectClass;
import com.ifsaid.sqlite.service.DetectClassService;
import com.ifsaid.sqlite.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 流程点控制器类
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/9/11 16:16
 * @version: 1.0
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

@Slf4j
@RequestMapping("class")
@RestController
public class DetectClassController {

    @Autowired
    private DetectClassService classService;

    @GetMapping
    public JsonResult findById(@RequestParam("classId") Integer classId) {
        log.info("get ID : {}", classId);
        return JsonResult.success(classService.findById(classId));
    }

    @GetMapping("/all")
    public JsonResult<Page> findAll(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size) {
        PageInfo<Object> pageInfo = PageHelper
                .startPage(page, size)
                .doSelectPageInfo(classService::findAll);
        log.info("Page :  {}  , Size : {}", page, size);
        return JsonResult.success(pageInfo);
    }

    @PostMapping
    public JsonResult save(@RequestBody DetectClass detectClass) {
        log.info("save : {}", detectClass);
        return JsonResult.success(classService.save(detectClass));
    }

    @PutMapping
    public JsonResult update(@RequestBody DetectClass detectClass) {
        log.info("update : {}", detectClass);
        return JsonResult.success(classService.update(detectClass));
    }

    @DeleteMapping
    public JsonResult delete(@RequestParam("classId") Integer classId){
        log.info("delete ID : {}", classId);
        return JsonResult.success(classService.deleteById(classId));
    }

}
