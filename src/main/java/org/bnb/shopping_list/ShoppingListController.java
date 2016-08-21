package org.bnb.shopping_list;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingListController {

	@RequestMapping("/shoppingLists")
	public Iterable<ShoppingList> allShoppingLists() {
		return Context.shoppingListGateway.findAll();
	}
}
