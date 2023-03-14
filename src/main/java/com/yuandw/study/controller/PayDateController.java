package com.yuandw.study.controller;


import com.yuandw.study.service.PayDateService;
import com.yuandw.study.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

/**
 * @Author: yuandw@19pay.com.cn
 * 创建时间：2023-3-14 18:09
 * @Description:
 */
@Controller
@SuppressWarnings("all")
public class PayDateController {

    @Autowired
    PayDateService payDateService;
    /**
     * 获取发薪日期
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/get/payInfo")
    public ResponseData<String> payInfo() {
        LocalDate of2 = LocalDate.of(2023, 3, 14);
        LocalDate aa = payDateService.getPayDate(of2);
        return new ResponseData("10000", "success",aa);
    }
}
