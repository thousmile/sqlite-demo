package com.ifsaid.sqlite.service.impl;

import com.ifsaid.sqlite.entity.DetectClass;
import com.ifsaid.sqlite.mapper.DetectClassMapper;
import com.ifsaid.sqlite.service.DetectClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 检测类 service 层
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/9/11 16:09
 * @version: 1.0
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

@Slf4j
@Service
public class DetectClassServiceImpl implements DetectClassService {

    @Autowired
    private DetectClassMapper baseMapper;

    @Override
    public List<DetectClass> findAll() {
        return baseMapper.findAll();
    }

    @Override
    public DetectClass findById(Integer id) {
        return baseMapper.findById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer save(DetectClass entity) {
        return baseMapper.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer batchSave(List<DetectClass> list) {
        return baseMapper.batchSave(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DetectClass update(DetectClass entity) {
        baseMapper.update(entity);
        return findById(entity.getClassId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteById(Integer id) {
        return baseMapper.deleteById(id);
    }

    @Override
    public Integer count(Integer id) {
        return baseMapper.count(id);
    }

}
