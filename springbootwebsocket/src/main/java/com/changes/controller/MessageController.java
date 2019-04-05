package com.changes.controller;

import com.changes.util.RequestMessage;
import com.changes.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName MessageController
 * @Description TODO
 * @Author LiuJunJie
 * @Date 2019/4/4 16:35
 * @Version 1.0
 * @Company WH_tepia
 **/
@RestController
public class MessageController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/getData")
    @SendTo("/topic/say")
    public ResponseMessage broadCast(@RequestBody RequestMessage requestMessage){
        ResponseMessage r = new ResponseMessage();
        r.setCode(200);
        r.setResult("receive:"+requestMessage.getStcd());
        return r;
    }

    /**
     * Description //定时推送消息
     * @Author LiuJunJie
     * @Date 17:10 2019/4/4
     * @param
     * @return void
     */
    @Scheduled(fixedRate = 1000)
    public void callback(){
        messagingTemplate.convertAndSend("/topic/callback",new Date());
    }


}
