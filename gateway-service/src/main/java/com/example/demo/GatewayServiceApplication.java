package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;

@SpringBootApplication
@EnableHystrix
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	@Bean
	RouteLocator staticRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r->r
						.path("/muslim/**")
						.filters(f->f
								.addRequestHeader("x-rapidapi-host", "muslimsalat.p.rapidapi.com")
								.addRequestHeader("x-rapidapi-key", "b865b12b7fmsh2bd837bb5f5ca22p1c752cjsn330a34aec823")
								.rewritePath("/muslim/(?<segment>.*)", "/${segment}")
								.hystrix(h->h
										.setName("muslimSalat")
										.setFallbackUri("forward:/defaultSalat")
										)
								)
						.uri("https://muslimsalat.p.rapidapi.com")
						.id("r1"))
				.route(r->r
						.path("/getMsgs/**")
						.filters(f->f
								.addRequestHeader("x-rapidapi-host", "ajith-messages.p.rapidapi.com")
								.addRequestHeader("x-rapidapi-key", "b865b12b7fmsh2bd837bb5f5ca22p1c752cjsn330a34aec823")
								.addRequestParameter("category", "Random")
								.rewritePath("/getMsgs/(?<segment>.*)", "/${segment}")
								.hystrix(h->h
										.setName("RandomMsg")
										.setFallbackUri("forward:/defaultMsg")
										)
								)
						.uri("https://ajith-messages.p.rapidapi.com/getMsgs")
						.id("r2"))
				.build();
	}
	
	@Bean
	DiscoveryClientRouteDefinitionLocator dymanicRoute(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp) {
		return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
	}
}
