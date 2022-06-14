package com.olivares.store.product.controller;

import com.olivares.store.product.entity.Product;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// https://stackoverflow.com/questions/58547348/how-to-mock-some-beans-but-not-others-in-mockmvc
// https://howtodoinjava.com/spring-boot2/testing/rest-controller-unit-test-example/
class ProductControllerTest extends BaseTest {
    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getProductsList() throws Exception {
        String uri = "/products";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Product[] products = super.mapFromJson(content, Product[].class);
        assertTrue(products.length > 0);
    }

    @Test
    public void updateProduct() throws Exception {
        String uri = "/products/2";
        Product product = new Product();
        product.setName("Lemon");
        String inputJson = super.mapToJson(product);
        //MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put(uri)
        //        .contentType(MediaType.APPLICATION_JSON_VALUE)
        //        .content(inputJson)).andReturn();

        //int status = mvcResult.getResponse().getStatus();
        //assertEquals(200, status);
        //String content = mvcResult.getResponse().getContentAsString();
        //assertEquals(content, "Product is updated successsfully");
    }

    @Ignore
    @Test
    public void deleteProduct() throws Exception {
        String uri = "/products/2";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        //assertEquals(content, "Product is deleted successsfully");
    }
}