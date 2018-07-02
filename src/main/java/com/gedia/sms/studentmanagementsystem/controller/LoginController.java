package com.gedia.sms.studentmanagementsystem.controller;

import com.gedia.sms.studentmanagementsystem.common.ResultValue;
import org.springframework.web.bind.annotation.*;

/**
 * 登陆接口
 *
 * @author jiwenquan
 * @create 2018/6/28 16:58
 */
@RestController
@RequestMapping("/sms/login")
public class LoginController {

    @RequestMapping(value = "/doLogin", method = RequestMethod.GET)
    public ResultValue toLogin(@RequestParam String userName, @RequestParam String password) {
        return new ResultValue(true, "登陆成功！");
    }

    @GetMapping(value = "/doLogout")
    public ResultValue toLogout() {
        return new ResultValue(true, "登出成功！");
    }
}
