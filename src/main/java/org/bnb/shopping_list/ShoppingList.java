package org.bnb.shopping_list;

import java.util.HashMap;
import java.util.Map;

public class ShoppingList {

	private String listName;
	private Map<String, Integer> items;

	public ShoppingList(String listName) {
		this.listName = listName;
		items = new HashMap<>();
	}

	public String getListName() {
		return listName;
	}

	public ShoppingList add(String itemName, int quantity) {
		items.merge(itemName, quantity, Integer::sum);
		return this;
	}

	public ShoppingList remove(String itemName) {
		items.remove(itemName);
		return this;
	}

	public boolean contains(String itemName) {
		return items.containsKey(itemName);
	}

	public Integer getItemQuantity(String itemName) {
		return items.getOrDefault(itemName, 0);
	}
}
