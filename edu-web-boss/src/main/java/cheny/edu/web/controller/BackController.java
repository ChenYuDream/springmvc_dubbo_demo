package cheny.edu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台页面
 *
 * @author yu_chen
 * @create 2017-11-14 16:48
 **/
@Controller
@RequestMapping("back")
public class BackController {

    /**
     * 跳转到后台主页面
     *
     * @return
     */
    @GetMapping("main")
    public String toMain() {
        return "back/main";
    }

    @GetMapping("user")
    public String toUserList() {
        return "back/user_list";
    }
}
