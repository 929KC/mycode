package com.kc.gobang.config;

import com.kc.gobang.handler.GameHandle;
import com.kc.gobang.handler.MatchHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;


@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Autowired
    private MatchHandler matchHandler;
    @Autowired
    private GameHandle gameHandle;
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // 通过 .addInterceptors(new HttpSessionHandshakeInterceptor() 这个操作来把 HttpSession 里的属性放到 WebSocket 的 session 中
        // 参考: https://docs.spring.io/spring-framework/docs/5.0.7.RELEASE/spring-framework-reference/web.html#websocket-server-handshake
        // 然后就可以在 WebSocket 代码中 WebSocketSession 里拿到 HttpSession 中的 attribute.
        registry.addHandler(matchHandler, "/findMatch")
                .addInterceptors(new HttpSessionHandshakeInterceptor());
        registry.addHandler(matchHandler, "/game")
                .addInterceptors(new HttpSessionHandshakeInterceptor());
    }
}
