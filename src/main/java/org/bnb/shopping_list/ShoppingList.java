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

	public void add(String itemName, int quantity) {
		items.put(itemName, quantity);
	}

	public Map<String, Integer> getItems() {
		return items;
	}

	public boolean contains(String itemName) {
		return items.containsKey(itemName);
	}
}
