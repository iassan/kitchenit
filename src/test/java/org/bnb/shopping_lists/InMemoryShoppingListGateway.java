package org.bnb.shopping_lists;

import org.bnb.shopping_list.ShoppingList;
import org.bnb.shopping_list.ShoppingListGateway;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class InMemoryShoppingListGateway implements ShoppingListGateway {

	private Map<String, ShoppingList> shoppingLists = new HashMap<>();

	@Override
	public Optional<ShoppingList> findByName(String shoppingListName) {
		return Optional.ofNullable(shoppingLists.get(shoppingListName));
	}

	@Override
	public ShoppingList save(ShoppingList shoppingList) {
		shoppingLists.put(shoppingList.getListName(), shoppingList);
		return shoppingList;
	}

	@Override
	public void delete(String shoppingListName) {
		shoppingLists.remove(shoppingListName);
	}

	@Override
	public Iterable<ShoppingList> findAll() {
		return shoppingLists.values();
	}
}
