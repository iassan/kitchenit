package org.bnb.shopping_list;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@SpringBootApplication
public class Application {

	@Resource
	private ShoppingListGateway shoppingListGateway;

	@PostConstruct
	public void init() {
		Context.shoppingListGateway = shoppingListGateway;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
