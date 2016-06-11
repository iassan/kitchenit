package org.bnb.shopping_list;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Repository
public class ShoppingListJpaGateway implements ShoppingListGateway {

	@Resource
	private ShoppingListJpaRepository repository;

	@Override
	public Optional<ShoppingList> findByUserAndName(User user, String shoppingListName) {
		return repository.findByOwnerAndListName(user, shoppingListName);
	}

	@Override
	public ShoppingList save(User user, ShoppingList shoppingList) {
		shoppingList.setOwner(user);
		return repository.save(shoppingList);
	}

	@Override
	public void delete(User user, String shoppingListName) {
		repository.delete(shoppingListName);
	}

	@Override
	public List<ShoppingList> findByUser(User user) {
		return repository.findByOwner(user);
	}
}
