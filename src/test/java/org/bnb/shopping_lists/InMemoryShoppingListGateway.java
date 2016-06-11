package org.bnb.shopping_lists;

import org.bnb.shopping_list.ShoppingList;
import org.bnb.shopping_list.ShoppingListGateway;
import org.bnb.shopping_list.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryShoppingListGateway implements ShoppingListGateway {

	private Map<User, Map<String, ShoppingList>> shoppingLists = new HashMap<>();

	@Override
	public Optional<ShoppingList> findByUserAndName(User user, String shoppingListName) {
		return Optional.ofNullable(shoppingLists.getOrDefault(user, new HashMap<>()).get(shoppingListName));
	}

	@Override
	public ShoppingList save(User user, ShoppingList shoppingList) {
		if (!shoppingLists.containsKey(user)) {
			shoppingLists.put(user, new HashMap<>());
		}
		shoppingLists.get(user).put(shoppingList.getListName(), shoppingList);
		return shoppingList;
	}

	@Override
	public void delete(User user, String shoppingListName) {
		if (shoppingLists.containsKey(user)) {
			shoppingLists.get(user).remove(shoppingListName);
		}
	}

	@Override
	public List<ShoppingList> findByUser(User user) {
		return new ArrayList<>(shoppingLists.get(user).values());
	}
}
