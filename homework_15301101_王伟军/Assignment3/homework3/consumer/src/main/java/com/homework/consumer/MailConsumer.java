package com.homework.consumer;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.homework.model.Mail;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
public class MailConsumer {

    Logger logger = LoggerFactory.getLogger(MailConsumer.class);

    @KafkaListener(topics = "testTopic")
    public void listen(ConsumerRecord<?, String> record) throws InterruptedException {
        Mail mail = JSONUtil.toBean(record.value(), Mail.class);
        logger.info("收到kafka消息，消息内容为：{}" ,mail);
        while (true) {
            HttpResponse response = HttpRequest.post("http://gougouchat.cn/mail/sendmail.php")
                    .body(mail.toString()).execute();
            logger.info("response is {}",response);
            logger.info("{}",response.body().trim());
            String body =response.body().trim();
            if (response.isOk() && body.contains("success")) {
                break;
            }
            logger.warn("sleep");
            TimeUnit.SECONDS.sleep(30);
        }

    }
}