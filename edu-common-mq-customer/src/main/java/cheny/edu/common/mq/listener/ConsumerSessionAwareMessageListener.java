package cheny.edu.common.mq.listener;

import cheny.edu.common.params.MailParam;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @author ChenYu
 * @description 自定义监听器
 */
@Component
@Slf4j
public class ConsumerSessionAwareMessageListener implements SessionAwareMessageListener<Message> {

    @Resource
    private JmsTemplate activeMqJmsTemplate;

    @Resource
    private Destination sessionAwareQueue;

    @Override
    public synchronized void onMessage(Message message, Session session) {
        try {
            ActiveMQTextMessage msg = (ActiveMQTextMessage) message;
            final String ms = msg.getText();
            System.out.println(ms);
            log.info("==>receive message:" + ms);
            // 转换成相应的对象
            MailParam mailParam = JSONObject.parseObject(ms, MailParam.class);
            if (mailParam == null) {
                return;
            }

            try {
                //此处编写邮件发送的业务逻辑
                log.info("==>发送邮件给{},主题为：{},内容为：{}", mailParam.getTo(), mailParam.getSubject(), mailParam.getContent());

            } catch (Exception e) {
                // 发送异常，重新放回队列
                activeMqJmsTemplate.send(sessionAwareQueue, session1 -> session1.createTextMessage(ms));
                log.error("==>MailException:", e);
            }
        } catch (Exception e) {
            log.error("==>", e);
        }
    }
}
