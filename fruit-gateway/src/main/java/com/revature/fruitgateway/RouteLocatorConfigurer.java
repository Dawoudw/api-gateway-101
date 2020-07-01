package com.revature.fruitgateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfigurer {
  @Value("${SERVICE_URLS_BANANA}")
  private String bananaUrl;

  @Value("${SERVICE_URLS_APPLE}")
  private String appleUrl;

  @Bean
  public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    System.out.println("Configuring routes");
    return builder.routes()
      .route(r -> r.path("/banana-service")
        .filters(f -> f.rewritePath("/banana-service", "/banana"))
        .uri(bananaUrl)
        .id("banana_route")
      )
      .route(r -> r.path("/apple-service")
        .filters(f -> f.rewritePath("/apple-service", "/apple"))
        .uri(appleUrl)
        .id("apple_route")
      )
      .build();
  }
}
