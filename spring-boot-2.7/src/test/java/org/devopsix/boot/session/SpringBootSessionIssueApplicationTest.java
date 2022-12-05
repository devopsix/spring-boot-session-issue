package org.devopsix.boot.session;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)

public class SpringBootSessionIssueApplicationTest {

    @Test
    void test(@Autowired TestRestTemplate restTemplate) {
        restTemplate.getForObject("/", Void.class);
    }
}
