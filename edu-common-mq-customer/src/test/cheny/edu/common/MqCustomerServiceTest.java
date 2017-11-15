package cheny.edu.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yu_chen
 * @create 2017-11-15 15:53
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-context.xml", "classpath:spring/spring-mq.xml"})
@Slf4j
public class MqCustomerServiceTest {

    @Test
    public void test() {

    }
}
