package com.service.inventorycatalogue.service.impl;

/**
 * InventoryServiceImpl layer helps in performing CRUD operation and other business/
 * logic like sending communication
 *
 */

import com.service.inventorycatalogue.dto.InventoryDto;
import com.service.inventorycatalogue.dto.InventoryMsgDto;
import com.service.inventorycatalogue.dto.UpdateQuantityAFOrderDto;
import com.service.inventorycatalogue.entity.InventoryEntity;
import com.service.inventorycatalogue.exception.ResourceNotFoundException;
import com.service.inventorycatalogue.exception.SkuExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import com.service.inventorycatalogue.mapper.InventoryMapper;
import com.service.inventorycatalogue.mapper.UpdateQuantityAFOrderMapper;
import com.service.inventorycatalogue.repository.InventoryRepository;
import com.service.inventorycatalogue.service.IInventoryService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import software.amazon.awssdk.services.sqs.SqsClient;

import java.util.Optional;

@Service
@AllArgsConstructor
public class InventoryServiceImpl implements IInventoryService {

    private static final Logger log = LoggerFactory.getLogger(InventoryServiceImpl.class);
    private InventoryRepository inventoryRepository;
    private final StreamBridge streamBridge;
    private final String queueUrl = "https://sqs.us-east-2.amazonaws.com/730335419891/message";
    @Autowired
    private final SqsClient sqsClient;


    /**
     * Helps in adding the Quantity of the prodct
     * @param inventoryDto - Input sku
     */
    @Override
    public void addQuantity(InventoryDto inventoryDto) {
        InventoryEntity inventoryEntity = InventoryMapper.mapToInventoryEntity(inventoryDto, new InventoryEntity());
        Optional<InventoryEntity> bySku = inventoryRepository.findBySku(inventoryDto.getSku());
        if (bySku.isPresent()){
            throw new SkuExistsException("Sku Already exists" + inventoryDto.getSku());
        }
        inventoryRepository.save(inventoryEntity);

    }

    /**
     * Helps to get the details of the quantity
     * @param sku - Input sku
     */
    @Override
    public InventoryDto fetchQuantity(String sku) {
        InventoryEntity inventory = inventoryRepository.findBySku(sku).orElseThrow(
                ()-> new ResourceNotFoundException("Inventory","Sku", sku)
        );
        return InventoryMapper.mapToInventoryDto(inventory, new InventoryDto());
    }

    /**
     * Helps in updating the inventory details
     * @param inventoryDto - Input sku
     */
    @Override
    public boolean updateQuantity(InventoryDto inventoryDto) {
        boolean isUpdated = false;
        if(inventoryDto != null){
            InventoryEntity inventoryEntity = inventoryRepository.findBySku(inventoryDto.getSku()).orElseThrow(
                    () -> new ResourceNotFoundException("Inventory","Sku",inventoryDto.getSku())
            );
            InventoryMapper.mapToInventoryEntity(inventoryDto, inventoryEntity);
            inventoryRepository.save(inventoryEntity);
            isUpdated = true;
        }

        return isUpdated;
    }

    /**
     * Helps in deleting the inventory details
     * @param sku - Input sku
     */
    @Override
    public boolean deleteQuantity(String sku) {
        InventoryEntity inventoryEntity = inventoryRepository.findBySku(sku).orElseThrow(
                () -> new ResourceNotFoundException("Inventory","Sku", sku)
        );
        inventoryRepository.deleteById(inventoryEntity.getId());
        return true;
    }

    /**
     * Helps in reducing the quantity number
     * sendCommunication method is integrated for communication with Product Catalogue
     * @param quantity
     * @return
     */
    @Override
    public boolean reduceStock(UpdateQuantityAFOrderDto updateQuantityAFOrderDto, int quantity) {

        boolean isOrdered = false;
        if(updateQuantityAFOrderDto != null) {
            InventoryEntity inventoryEntity = inventoryRepository.findBySku(updateQuantityAFOrderDto.getSku()).orElseThrow(
                    () -> new ResourceNotFoundException("Inventory","Sku",updateQuantityAFOrderDto.getSku())
            );
            UpdateQuantityAFOrderMapper.mapToInventoryEntity(updateQuantityAFOrderDto, inventoryEntity);
            int newQuantity = inventoryEntity.getQuantity() - quantity;
            inventoryEntity.setQuantity(newQuantity);
            InventoryEntity savedInventoryQuantity = inventoryRepository.save(inventoryEntity);
            if (savedInventoryQuantity.getQuantity() < 10){
                //sendCommunication(savedInventoryQuantity);
                var inventoryMsgDto = new InventoryMsgDto( inventoryEntity.getSku(),
                        inventoryEntity.getQuantity(), inventoryEntity.getCategory());
                var result = streamBridge.send("sendCommunication-out-0", inventoryMsgDto);
                SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
                        .queueUrl(queueUrl)
                        .messageBody("Quantity of a product is less than 10")
                        .build();
                sqsClient.sendMessage(sendMessageRequest);
            }
            isOrdered = true;
        }
        return isOrdered;
    }

    /**
     * Helps in communication with Product Catalogue
     * sendCommunication method is integrated for communication with Product Catalogue
     * @param inventoryEntity
     * @return
     */
    private void sendCommunication(InventoryEntity inventoryEntity){
        var inventoryMsgDto = new InventoryMsgDto( inventoryEntity.getSku(),
                inventoryEntity.getQuantity(), inventoryEntity.getCategory());
        log.info("Sending Communication request for the details:{}", inventoryMsgDto);
        var result = streamBridge.send("sendCommunication-out-0", inventoryMsgDto);
        SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody("Quantity of a product is less than 10")
                .build();
        sqsClient.sendMessage(sendMessageRequest);
        log.info("The Communication request successfully triggered");
        log.info("The Communication request successfully triggered?:{}", result);
    }

    /**
     * Sends the updated status and communication once the sendCommunication method is invoked in reduceStock method
     * @param sku
     * @return
     */
    @Override
    public boolean updateCommunication(String sku) {
        boolean isUpdated = false;
        if(sku != null){
            InventoryEntity inventoryEntity = inventoryRepository.findBySku(sku).orElseThrow(
                    () -> new ResourceNotFoundException("Inventory","Sku",sku)
            );
            inventoryEntity.setStatus("Product ending soon");
            inventoryEntity.setCommunication(true);
            inventoryRepository.save(inventoryEntity);
            isUpdated = true;
        }
        return isUpdated;
    }
}
