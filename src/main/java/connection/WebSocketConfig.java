package connection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myHandler(), "/myHandler").addInterceptors(new HttpSessionHandshakeInterceptor()).setAllowedOrigins("http://localhost");
        registry.addHandler(updateHandler(), "/updates").addInterceptors(new HttpSessionHandshakeInterceptor()).setAllowedOrigins("http://192.168.1.11:8080/socketTest");
    }

    @Bean
    public WebSocketHandler myHandler() {
        return new MyHandler();
    }
    
    @Bean
    public WebSocketHandler updateHandler() {
    	return new UpdateHandler();
    }
    
    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(8192);
        container.setMaxBinaryMessageBufferSize(8192);
        return container;
    }
}