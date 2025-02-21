package com.mapkloud.product_service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mapkloud.product_service.dto.ProductRequest;
import com.mapkloud.product_service.repository.ProductRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private MongoTemplate mongoTemplate;

	@Container
	static GenericContainer<?> mongoDBContainer = new GenericContainer<>("mongo:6.0")
			.withExposedPorts(27017).withEnv("MONGO_INITDB_DATABASE", "product-service");

	@BeforeAll
	static void setup() {
		mongoDBContainer.start();
	}

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
		dynamicPropertyRegistry.add("spring.data.mongodb.uri",
				() -> "mongodb://" + mongoDBContainer.getHost() + ":" + mongoDBContainer.getMappedPort(27017));
	}

	@Test
	void testMongoDBConnection() {
		assertNotNull(mongoTemplate);
	}

	@Test
	void shouldCreateProduct() throws Exception {
		ProductRequest productRequest = getProductRequest();
		String productRequestString = objectMapper.writeValueAsString(productRequest);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
						.contentType(MediaType.APPLICATION_JSON)
						.content(productRequestString))
				.andExpect(status().isCreated());
	}

	private ProductRequest getProductRequest() {
		return ProductRequest.ProductRequestBuilder.aProductRequest()
				.name("Iphone 13")
				.description("Iphone 13 desc")
				.price(BigDecimal.valueOf(1200))
				.build();
	}
}
