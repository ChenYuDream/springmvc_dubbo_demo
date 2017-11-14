package cheny.edu.web.controller;

import cheny.edu.common.dto.Result;
import cheny.edu.common.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录控制器
 *
 * @author yu_chen
 * @create 2017-11-14 16:24
 **/
@Controller
@RequestMapping("login")
public class LoginController {

    /**
     * 跳转到登录页面
     * @return
     */
    @GetMapping("page")
    public String toPage() {
        return "back/login";
    }

    /**
     * 检查用户登录名密码
     *
     * @param user
     * @return
     */
    @PostMapping("check")
    @ResponseBody
    public Result checkUser(User user) {

        return new Result();
    }

    /**
     * 注销登录
     * @return
     */
    @GetMapping("logout")
    public String logout() {
        return "";
    }
}
