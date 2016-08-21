package org.bnb.shopping_list;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

interface ShoppingListJpaRepository extends CrudRepository<ShoppingList, String> {
	Optional<ShoppingList> findByListName(String listName);
}
