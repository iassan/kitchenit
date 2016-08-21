package org.bnb.shopping_list;

import java.util.Optional;

public interface ShoppingListGateway {

	Optional<ShoppingList> findByName(String shoppingListName);

	ShoppingList save(ShoppingList shoppingList);

	void delete(String shoppingListName);

	Iterable<ShoppingList> findAll();
}
