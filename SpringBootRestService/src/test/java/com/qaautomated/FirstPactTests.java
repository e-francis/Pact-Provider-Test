package com.qaautomated;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.qaautomated.controller.LibraryController;
import com.qaautomated.controller.ProductsPrices;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslJsonArray;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit.MockServerConfig;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;


@SpringBootTest
@ExtendWith(PactConsumerTestExt.class)
public class FirstPactTests {
	
	@Autowired
	private LibraryController libraryC;
	
	@Pact(consumer = "BooksDetails")
	public RequestResponsePact pactAllToysDetails(PactDslWithProvider builder) {
		return builder.given("toys details")
		.uponReceiving("Getting all toys details")
		.path("/allToysDetails")
		.willRespondWith()
		.status(200)
		.body(PactDslJsonArray.arrayMinLike(2)
				.stringType("toy_name")
				.stringType("id")
				.integerType("price", 100)
				.stringType("category").closeObject()).toPact();
	}
	
	
	
	
	@Test
	@PactTestFor(pactMethod="priceAllToysDetails", port="9191")
	@MockServerConfig(port = "9191")
	public void testPrice(MockServer mocserver) throws JsonMappingException, JsonProcessing {
		
		String expectedjson = "{\"booksPrice\":100,\"toysPrice\":200}";
		libraryC.setBaseUrl(mocserver.getUrl());
		ProductsPrices pp = libraryC.getProductPrices();
		ObjectMapper obj = new ObjectMapper();
		String actualjson = obj.writeValueAsString(pp);
		Assertions.assertEquals(expectedjson, actualjson);
		
		
	}

}
