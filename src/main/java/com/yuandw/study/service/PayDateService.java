package com.yuandw.study.service;

import java.time.LocalDate;

/**
 * @Author: yuandw@19pay.com.cn
 * 创建时间：2023-3-14 18:15
 * @Description: 发薪日期计算service接口
 */
public interface PayDateService {
    /**
     * 获取下一个发薪日的日期
     * 发工资是每个月15号 如果15号是周末 则调整为上一个周五
     *
     * @param date
     * @return
     */
     LocalDate getPayDate(LocalDate date);
}
