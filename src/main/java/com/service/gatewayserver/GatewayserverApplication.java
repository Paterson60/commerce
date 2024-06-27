package com.service.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}

	/**
	 * Helps in defining a new the api path in GatewayServer/
	 * instead of directly hitting any endpoints of Product and Inventory
	 */
	@Bean
	public RouteLocator ecommerceRouteConfig(RouteLocatorBuilder routeLocatorBuilder){
		return routeLocatorBuilder.routes()
				.route(p -> p
						.path("/service/productcatalogue/**")
						.filters(f -> f.rewritePath("/service/productcatalogue/(?<segment>.*)","/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://PRODUCTCATALOGUE"))
				.route(p -> p
						.path("/service/inventorycatalogue/**")
						.filters(f -> f.rewritePath("/service/inventorycatalogue/(?<segment>.*)","/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						.uri("lb://INVENTORYCATALOGUE")).build();
	}

}
