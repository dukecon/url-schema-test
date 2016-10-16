package org.dukecon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UrlSchemaApplication {

	@RequestMapping("/")
	public String root() {
		return "root";
	}


	@RequestMapping("/index.html")
	public String index() {
		return "index.html";
	}


	@RequestMapping("/public/index.html")
	public String publicIndex() {
		return "public/index.html";
	}


	@RequestMapping("/rest")
	public String rest() {
		return "rest/conferences/...";
	}

	public static void main(String[] args) {
		SpringApplication.run(UrlSchemaApplication.class, args);
	}
}
