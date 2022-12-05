package org.devopsix.boot.session;

import jakarta.servlet.http.HttpSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootSessionIssueApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSessionIssueApplication.class, args);
	}

	@GetMapping("/")
	public void dummyEndpoint(HttpSession session) {
		session.setAttribute("foo", "bar");
	}
}
