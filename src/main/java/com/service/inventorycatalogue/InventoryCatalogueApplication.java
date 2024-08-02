package com.service.inventorycatalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
//@EnableEurekaClient
@EnableDiscoveryClient
public class InventoryCatalogueApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryCatalogueApplication.class, args);
	}

}
