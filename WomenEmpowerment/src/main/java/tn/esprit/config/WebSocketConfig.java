package tn.esprit.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import tn.esprit.ws.DataHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    /**
     * http:localhost:9091/data
     * @param webSocketHandlerRegistryregistry
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistryregistry) {
webSocketHandlerRegistryregistry.addHandler(new DataHandler(),"/data");
    }

    @Bean
    DataHandler getDataHandler(){

        return new DataHandler();
    }


}
