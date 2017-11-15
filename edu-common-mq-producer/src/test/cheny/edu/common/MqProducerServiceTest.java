package cheny.edu.common;

import cheny.edu.common.mq.MqProducerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author yu_chen
 * @create 2017-11-15 15:53
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-context.xml", "classpath:spring/spring-mq.xml"})
@Slf4j
public class MqProducerServiceTest {

    @Resource
    private MqProducerService mqProducerService;

    @Test
    public void testSendMessage() {

        mqProducerService.sendMessage("asd");
    }
}
