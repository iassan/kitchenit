package org.bnb.shopping_list;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private String username;

	public User() {
	}

	public User(String username) {
		this.username = username;
	}
}
