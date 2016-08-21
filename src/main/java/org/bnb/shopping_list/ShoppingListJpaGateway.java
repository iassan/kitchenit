package org.bnb.shopping_list;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Optional;

@Repository
public class ShoppingListJpaGateway implements ShoppingListGateway {

	@Resource
	private ShoppingListJpaRepository repository;

	@Override
	public Optional<ShoppingList> findByName(String shoppingListName) {
		return repository.findByListName(shoppingListName);
	}

	@Override
	public ShoppingList save(ShoppingList shoppingList) {
		return repository.save(shoppingList);
	}

	@Override
	public void delete(String shoppingListName) {
		repository.delete(shoppingListName);
	}

	@Override
	public Iterable<ShoppingList> findAll() {
		return repository.findAll();
	}
}
