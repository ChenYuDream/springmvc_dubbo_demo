package wusc.edu.web.boss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wusc.edu.facade.user.service.UserService;

import javax.annotation.Resource;

/**
 * @author yu_chen
 * @create 2017-11-08 18:21
 **/
@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("l")
    public String toIndex() {

        return "index";
    }

    @RequestMapping("and")
    @ResponseBody
    public int and(int x, int y) {
        return userService.and(x, y);
    }

    @RequestMapping("sub")
    @ResponseBody
    public int sub(int x, int y) {
        return userService.sub(x, y);
    }
}
