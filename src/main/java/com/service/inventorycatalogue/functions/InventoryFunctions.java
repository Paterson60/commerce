package com.service.inventorycatalogue.functions;
/**
 * Consumes the message from message artifact of the queue message
 *
 */
import com.service.inventorycatalogue.service.IInventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class InventoryFunctions {

    private static final Logger log = LoggerFactory.getLogger(InventoryFunctions.class);

    @Bean
    public Consumer<String> updateCommunication(IInventoryService iInventoryService){
        return sku -> {
            log.info("Updating Communication status: " + sku);
            iInventoryService.updateCommunication(sku);
        };
    }
}
