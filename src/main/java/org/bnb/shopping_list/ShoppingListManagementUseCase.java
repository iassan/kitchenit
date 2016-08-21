package org.bnb.shopping_list;

public class ShoppingListManagementUseCase {

	public void createNewShoppingList(String listName) {
		ShoppingList shoppingList = new ShoppingList(listName);
		Context.shoppingListGateway.save(shoppingList);
	}

	public void deleteList(String shoppingListName) {
		Context.shoppingListGateway.delete(shoppingListName);
	}

	public void addItemToList(String shoppingListName, String itemName, int quantity) {
		Context.shoppingListGateway.findByName(shoppingListName)
				.map(sl -> sl.add(itemName, quantity))
				.map(sl -> Context.shoppingListGateway.save(sl));
	}

	public void removeItemFromList(String shoppingListName, String itemName) {
		Context.shoppingListGateway.findByName(shoppingListName)
				.map(sl -> sl.remove(itemName))
				.map(sl -> Context.shoppingListGateway.save(sl));
	}
}
