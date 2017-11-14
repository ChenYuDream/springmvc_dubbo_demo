package cheny.edu.web.controller;

import cheny.edu.common.dto.Result;
import cheny.edu.common.po.User;
import cheny.edu.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yu_chen
 * @create 2017-11-08 18:21
 **/
@Controller
@RequestMapping("user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 跳转到用户表单页
     *
     * @return
     */
    @GetMapping("form")
    public String toUserForm(String id, Model model) {
        if (StringUtils.isNotEmpty(id)) {
            User user = userService.selectUserById(id);
            model.addAttribute("user", user);
        }
        return "back/user_form";
    }

    /**
     * @return
     */
    @PostMapping("list")
    @ResponseBody
    public Result selectAll() {
        List<User> users = null;
        try {
            users = userService.selectAll();
        } catch (Exception e) {
            log.error("查询用户列表异常 e={}", e);
        }
        return new Result(users);
    }

}
