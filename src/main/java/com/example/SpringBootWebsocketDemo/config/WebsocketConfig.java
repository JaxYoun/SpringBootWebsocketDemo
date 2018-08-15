package com.example.SpringBootWebsocketDemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @Author：YangJx
 * @Description：
 * @DateTime：2018/3/31 13:59
 */
@Configuration
@EnableWebSocketMessageBroker  //启动websocket功能，默认为STOMP协议实现，所以启动的是STOMP over websocket功能
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");  //在endpoint中发布主题
        config.setApplicationDestinationPrefixes("/app");  //在endpoint上监听指定前缀的客户端请求，用@MessageMapping的方法来处理请求
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").withSockJS();  //启动一个websocket端点服务，提供包括消息队列在内的websocket总体服务
    }

}
