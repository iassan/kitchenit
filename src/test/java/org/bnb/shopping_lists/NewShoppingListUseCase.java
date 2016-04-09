package org.bnb.shopping_lists;

public class NewShoppingListUseCase {

	public void createNewShoppingList(User user, String listName) {
		ShoppingList shoppingList = new ShoppingList(listName);
		Context.shoppingListGateway.save(user, shoppingList);
	}
}
