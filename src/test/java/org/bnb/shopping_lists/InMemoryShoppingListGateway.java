package org.bnb.shopping_lists;

import org.bnb.shopping_list.ShoppingList;
import org.bnb.shopping_list.ShoppingListGateway;
import org.bnb.shopping_list.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryShoppingListGateway implements ShoppingListGateway {

	private Map<User, Map<String, ShoppingList>> shoppingLists = new HashMap<>();

	@Override
	public Optional<ShoppingList> findByUserAndName(User user, String listName) {
		return Optional.ofNullable(shoppingLists.getOrDefault(user, new HashMap<>()).get(listName));
	}

	@Override
	public void save(User user, ShoppingList shoppingList) {
		if (!shoppingLists.containsKey(user)) {
			shoppingLists.put(user, new HashMap<>());
		}
		shoppingLists.get(user).put(shoppingList.getListName(), shoppingList);
	}
}
