package com.example.Coffee.controller;

import com.example.Coffee.entity.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MenuControllerTest {

    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:"+port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }
    @Test
    void findAll() {
        ResponseEntity<Menu[]> response =
                testRestTemplate.getForEntity("/api/menus",Menu[].class);

        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(200,response.getStatusCodeValue());

        List<Menu> menus = Arrays.asList(response.getBody());
        System.out.println(menus.size());
    }

    @Test
    void findOneById() {
        ResponseEntity<Menu> response =
                testRestTemplate.getForEntity("/api/menus/0",Menu.class);

        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
    }

    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json= """
                {
                      "idMenu": null,
                      "day": "2024-03-11",
                      "dishes": [
                        "Poke de pasta, arroz, quinoa, lechuga y vegetal, atún, pollo.",
                        "Ñoquis con salsa de tomate natural, parmesano y panceta frita",
                        "Merluza con ensalada patatas, arroz, alcachofas o aros de cebolla",
                        "Alubias blancas con mix de setas y jamón"
                      ],
                      "price": 6.9
                    }
                """;

        HttpEntity<String> request = new HttpEntity<>(json,headers);

        ResponseEntity<Menu> response = testRestTemplate.exchange("/api/menus",HttpMethod.POST, request,Menu.class);

        Menu result = response.getBody();

        assertEquals(6.9,result.getPrice());
    }
}