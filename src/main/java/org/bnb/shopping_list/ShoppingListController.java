package org.bnb.shopping_list;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShoppingListController {

	@RequestMapping("/shoppingLists")
	public List<ShoppingList> allShoppingLists() {
		return Context.shoppingListGateway.findByUser(new User("dummy"));
	}
}
