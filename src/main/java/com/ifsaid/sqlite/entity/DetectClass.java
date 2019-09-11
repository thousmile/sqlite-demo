package com.ifsaid.sqlite.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * All rights Reserved, Designed By www.fujica.com.cn
 *
 * @description: 检测点
 * @author: Wang Chen Chen<932560435@qq.com>
 * @date: 2019/9/11 16:00
 * @version: 1.0
 * @copyright: 2019 http://www.fujica.com.cn/ Inc. All rights reserved.
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DetectClass implements Serializable {

    /**
     * @description: 检测类 id
     * @author: Wang Chen Chen <932560435@qq.com>
     * @date: 2019/6/4 10:21
     */
    private Integer classId;

    /**
     * @description: 检测类 对应spring ioc容器中的bean名称
     * @author: Wang Chen Chen <932560435@qq.com>
     * @date: 2019/6/4 10:21
     */
    private String beanName;

    /**
     * @description: 检测类 描述
     * @author: Wang Chen Chen <932560435@qq.com>
     * @date: 2019/6/4 10:21
     */
    private String description;

    /**
     * @description: 检测类，全路径
     * @author: Wang Chen Chen <932560435@qq.com>
     * @date: 2019/6/4 10:21
     */
    private String classPath;

    /**
     * @description: 最后一次修改时间
     * @author: Wang Chen Chen <932560435@qq.com>
     * @date: 2019/6/4 10:21
     */
    private Long updateTime;

    /**
     * @description: 创建时间
     * @author: Wang Chen Chen <932560435@qq.com>
     * @date: 2019/6/4 10:21
     */
    private Long createTime;


}
