package org.bnb.shopping_list;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.util.HashMap;
import java.util.Map;

@Entity
public class ShoppingList {

	@Id
	@Column(name = "listName")
	private String listName;

	@Transient
	private Map<String, Integer> items;

	@ManyToOne
	private User owner;

	public ShoppingList() {
	}

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

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public User getOwner() {
		return owner;
	}
}
