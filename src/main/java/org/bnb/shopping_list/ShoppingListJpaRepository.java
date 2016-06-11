package org.bnb.shopping_list;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ShoppingListJpaRepository extends CrudRepository<ShoppingList, String> {

	Optional<ShoppingList> findByOwnerAndListName(User user, String listName);

	List<ShoppingList> findByOwner(User user);
}
