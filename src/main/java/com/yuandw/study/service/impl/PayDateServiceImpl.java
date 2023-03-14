package com.yuandw.study.service.impl;

import com.yuandw.study.service.PayDateService;
import com.yuandw.study.utils.PayAdjuster;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * @Author: yuandw@19pay.com.cn
 * 创建时间：2023-3-14 18:16
 * @Description: 发薪日期计算service接口实现
 */
@Service
public class PayDateServiceImpl implements PayDateService {

    /**
     * 获取下一个发薪日的日期
     * 发工资是每个月15号 如果15号是周末 则调整为上一个周五
     *
     * @param date
     * @return
     */
    @Override
    public LocalDate getPayDate(LocalDate date) {
        LocalDate payDate = LocalDate.from(new PayAdjuster().adjustInto(date));
        return payDate;
    }
}
