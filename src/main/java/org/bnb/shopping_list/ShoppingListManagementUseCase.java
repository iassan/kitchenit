package org.bnb.shopping_list;

public class ShoppingListManagementUseCase {

	public void createNewShoppingList(User user, String listName) {
		ShoppingList shoppingList = new ShoppingList(listName);
		Context.shoppingListGateway.save(user, shoppingList);
	}

	public void deleteList(String shoppingListName) {
		Context.shoppingListGateway.delete(Context.loggedInUser, shoppingListName);
	}

	public void addItemToList(String shoppingListName, String itemName, int quantity) {
		User user = Context.loggedInUser;
		Context.shoppingListGateway.findByUserAndName(user, shoppingListName)
				.map(sl -> sl.add(itemName, quantity))
				.map(sl -> Context.shoppingListGateway.save(user, sl));
	}

	public void removeItemFromList(String shoppingListName, String itemName) {
		User user = Context.loggedInUser;
		Context.shoppingListGateway.findByUserAndName(user, shoppingListName)
				.map(sl -> sl.remove(itemName))
				.map(sl -> Context.shoppingListGateway.save(user, sl));
	}
}
