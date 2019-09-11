package com.ifsaid.sqlite.mapper;

import com.ifsaid.sqlite.entity.DetectClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 用一句话描述该文件做什么
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/9/11 16:02
 * @version: 1.0
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

@Mapper
public interface DetectClassMapper {

    /**
     * @description: 查看所有数据，当数据量大的时候避免使用
     * @author: Wang Chen Chen <932560435@qq.com>
     * @date: 2019/4/18 11:50
     */
    List<DetectClass> findAll();

    /**
     * @description: 根据ID查询数据
     * @author: Wang Chen Chen <932560435@qq.com>
     * @date: 2019/4/18 11:50
     */
    DetectClass findById(Integer id);

    /**
     * @description: 新增数据
     * @author: Wang Chen Chen <932560435@qq.com>
     * @date: 2019/4/18 11:50
     */
    Integer save(DetectClass entity);

    /**
     * @description: 批量新增数据
     * @author: Wang Chen Chen <932560435@qq.com>
     * @date: 2019/4/18 11:50
     */
    Integer batchSave(List<DetectClass> list);

    /**
     * @description: 修改数据，必须带 ID
     * @author: Wang Chen Chen <932560435@qq.com>
     * @date: 2019/4/18 11:50
     */
    Integer update(DetectClass entity);

    /**
     * @description: 根据ID删除数据
     * @author: Wang Chen Chen <932560435@qq.com>
     * @date: 2019/4/18 11:50
     */
    Integer deleteById(Integer id);

    /**
     * @description: 根据ID判断数据是否存在
     * @author: Wang Chen Chen <932560435@qq.com>
     * @date: 2019/4/18 11:50
     */
    Integer count(Integer id);


}
