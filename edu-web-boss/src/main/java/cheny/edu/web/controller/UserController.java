package cheny.edu.web.controller;

import cheny.edu.common.dto.Result;
import cheny.edu.common.mq.MqProducerService;
import cheny.edu.common.params.MailParam;
import cheny.edu.common.po.User;
import cheny.edu.service.UserService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private MqProducerService mqProducerService;

    /**
     * 跳转到用户表单页
     * 编辑
     *
     * @return
     */
    @GetMapping("form/{id}")
    public String toUserForm(Model model, @PathVariable("id") String id) {
        if (StringUtils.isNotEmpty(id)) {
            User user = userService.selectUserById(id);
            model.addAttribute("user", user);
        }
        return "back/user_form";
    }

    /**
     * 添加
     *
     * @return
     */
    @GetMapping("form")
    public String toUserForm() {
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

    /**
     * 保存
     *
     * @return
     */
    @PostMapping("save")
    @ResponseBody
    public Result saveUser(User user) {
        if (StringUtils.isNotEmpty(user.getId())) {
            //更新
            try {
                userService.updateUser(user);
            } catch (Exception e) {
                log.error("更新用户失败 user={},e={}", user, e);
            }
        } else {
            //保存
            user.setPassword("666666");
            try {
                userService.saveUser(user);
            } catch (Exception e) {
                log.error("保存用户失败 user={},e={}", user, e);
            }
        }
        return new Result();
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @GetMapping("delete/{id}")
    @ResponseBody
    public Result deleteUserById(@PathVariable("id") String id) {
        try {
            userService.deleteUserById(id);
        } catch (Exception e) {
            log.error("删除用户失败 id={},e={}", id, e);
        }
        return new Result();
    }

    /**
     * 发送邮件
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("mail/send/{id}")
    public Result sendMail(@PathVariable("id") String id) {
        User user = userService.selectUserById(id);
        MailParam mailParam = new MailParam(user.getEmail(), "第一次发邮件", "明天开会");
        mqProducerService.sendMessage(JSONObject.toJSONString(mailParam));
        return new Result();
    }
}
