package com.yuandw.study.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @Author: yuandw@19pay.com.cn
 * 创建时间：2023-3-14 18:05
 * @Description:获取下一个发薪日的日期
 *      发工资是每个月15号 如果15号是周末 则调整为上一个周五
 */
public class PayAdjuster implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        LocalDate from = LocalDate.from(temporal);
        from = from.withDayOfMonth(15);
        if(from.getDayOfWeek().equals(DayOfWeek.SUNDAY) || from.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
            from = from.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        }
        return from;
    }
}
