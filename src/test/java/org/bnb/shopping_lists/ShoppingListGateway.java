package org.bnb.shopping_lists;

import java.util.Optional;

public interface ShoppingListGateway {

	Optional<ShoppingList> findByUserAndName(User user, String listName);

	void save(User user, ShoppingList shoppingList);
}
