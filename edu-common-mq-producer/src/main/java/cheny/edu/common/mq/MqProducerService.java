package cheny.edu.common.mq;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @author yu_chen
 * @create 2017-11-15 15:42
 **/
@Service("mqProducerService")
public class MqProducerService {

    @Resource
    private JmsTemplate activeMqJmsTemplate;

    /**
     * 发送消息.
     *
     * @param message mq 消息内容 格式为json
     */
    public void sendMessage(final String message) {
        activeMqJmsTemplate.send(session -> session.createTextMessage(message));

    }
}
