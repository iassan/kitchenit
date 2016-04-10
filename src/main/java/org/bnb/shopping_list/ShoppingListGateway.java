package org.bnb.shopping_list;

import java.util.Optional;

public interface ShoppingListGateway {

	Optional<ShoppingList> findByUserAndName(User user, String listName);

	void save(User user, ShoppingList shoppingList);
}
