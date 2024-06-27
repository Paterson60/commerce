package com.service.message.functions;

import com.service.message.dto.InventoryMsgDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class MessageFunctions {

    private static final Logger log = LoggerFactory.getLogger(MessageFunctions.class);

    @Bean
    public Function<InventoryMsgDto, InventoryMsgDto> message(){
            return inventoryMsgDto -> {
                log.info("Quantity of a product is less than 10: " + inventoryMsgDto.toString());
                return inventoryMsgDto;
            };
    }

    @Bean
    public Function<InventoryMsgDto, String> sms(){
        return inventoryMsgDto -> {
            log.info("Sending sms with the details: " + inventoryMsgDto);
            return inventoryMsgDto.sku();
        };
    }
}
