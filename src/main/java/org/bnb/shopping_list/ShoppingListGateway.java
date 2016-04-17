package org.bnb.shopping_list;

import java.util.Optional;

public interface ShoppingListGateway {

	Optional<ShoppingList> findByUserAndName(User user, String shoppingListName);

	ShoppingList save(User user, ShoppingList shoppingList);

	void delete(User loggedInUser, String shoppingListName);
}
