package com.contaazul.controller;

import com.contaazul.Application;
import com.contaazul.controller.dto.Instruction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class RobotControllerTest {

    @LocalServerPort
    Integer port;

    @Autowired
    TestRestTemplate restTemplate;
    
    Instruction instruction;

    @AfterEach
    void tearDown() {
        instruction = null;
    }

    @Test
    @DisplayName("[integration] - Should move with a right rotation and return '(2,0,S)'")
    void test_case_1() {

        instruction = new Instruction("MMRMMRMM");

        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:" + port + "/v1/robots", instruction, String.class);
        String result = response.getBody();
        String expected = "(2,0,S)";

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("[integration] - Should move to the left and return '(0,2,W)'")
    void test_case_2() {

        instruction = new Instruction("MML");

        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:" + port + "/v1/robots", instruction, String.class);
        String result = response.getBody();
        String expected = "(0,2,W)";

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("[integration] - Should do repetition of the request with a leftward movement and return '(0,2,W)'")
    void test_case_3() {

        instruction = new Instruction("MML");

        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:" + port + "/v1/robots", instruction, String.class);
        String result = response.getBody();
        String expected = "(0,2,W)";

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("[integration] - Should execute Invalid command and return 'http 400'")
    void test_case_4() {

        instruction = new Instruction("AAA");

        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:" + port + "/v1/robots", instruction, String.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    @DisplayName("[integration] - Should execute Invalid position and return 'http 400'")
    void test_case_5() {

        instruction = new Instruction("MMMMMMMMMMMMMMMMMMMMMMMM");

        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:" + port + "/v1/robots", instruction, String.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}