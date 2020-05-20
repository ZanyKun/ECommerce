package com.b13;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import brave.sampler.Sampler;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableElasticsearchRepositories
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
//	@Bean
//	public Client client() throws UnknownHostException {
//	    Settings settings = Settings.builder()
//	             .put("client.transport.sniff", true)
//	             .put("path.home", "C:\\kibana-7.6.2-windows-x86_64\\elasticsearch-7.6.2")
//	                .put("cluster.name", "cluster-2").build();
//	    TransportClient client = new PreBuiltTransportClient(settings);
//	     client.addTransportAddress(new TransportAddress(new InetSocketAddress("localhost", 9300)));
//	     return client;
//	}
//	
//	@Bean
//	public ElasticsearchOperations elasticsearchTemplate() throws UnknownHostException {
//	    return new ElasticsearchTemplate(client());
//	}
}
