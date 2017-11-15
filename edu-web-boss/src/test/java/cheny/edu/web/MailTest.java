package cheny.edu.web;

import cheny.edu.common.mq.MqProducerService;
import cheny.edu.common.params.MailParam;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yu_chen
 * @create 2017-11-15 17:55
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-context-all.xml"})
@Slf4j
public class MailTest {
    @Autowired
    private MqProducerService mqProducerService;

    @Test
    public void sendMail() {
        MailParam mailParam = new MailParam("740350460@qq.com", "第一次发邮件", "明天开会");
        mqProducerService.sendMessage(JSONObject.toJSONString(mailParam));
    }
}
