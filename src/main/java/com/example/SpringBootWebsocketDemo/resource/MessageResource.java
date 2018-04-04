package com.example.SpringBootWebsocketDemo.resource;

import com.example.SpringBootWebsocketDemo.entity.Greeting;
import com.example.SpringBootWebsocketDemo.entity.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @Author：YangJx
 * @Description：
 * @DateTime：2018/4/1 19:14
 */
@Controller
public class MessageResource {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }

}
