package org.bnb.shopping_list;

import java.util.Optional;

public class ShoppingListManagementUseCase {

	public void createNewShoppingList(User user, String listName) {
		ShoppingList shoppingList = new ShoppingList(listName);
		Context.shoppingListGateway.save(user, shoppingList);
	}

	public void addItemToList(String shoppingListName, String itemName, int quantity) {
		User user = Context.loggedInUser;
		Optional<ShoppingList> optionalShoppingList = Context.shoppingListGateway.findByUserAndName(user, shoppingListName);
		if (optionalShoppingList.isPresent()) {
			ShoppingList shoppingList = optionalShoppingList.get();
			shoppingList.add(itemName, quantity);
			Context.shoppingListGateway.save(user, shoppingList);
		}
	}
}
