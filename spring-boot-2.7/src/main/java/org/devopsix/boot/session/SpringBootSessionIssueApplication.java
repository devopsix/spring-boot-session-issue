package org.devopsix.boot.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

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
