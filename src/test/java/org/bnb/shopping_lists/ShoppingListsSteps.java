package org.bnb.shopping_lists;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.bnb.shopping_list.Context;
import org.bnb.shopping_list.NewShoppingListUseCase;
import org.bnb.shopping_list.ShoppingList;
import org.bnb.shopping_list.User;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingListsSteps {

	private String listName;

	private User user;

	private NewShoppingListUseCase useCase = new NewShoppingListUseCase();

	@Before
	public void setup() {
		Context.shoppingListGateway = new InMemoryShoppingListGateway();
	}

	@Given("^a logged in user (\\w+)$")
	public void givenLoggedInUser(String userName) {
		user = new User(userName);
	}

	@And("^a shopping list's name (\\w+)$")
	public void aShoppingListSName(String listName) {
		this.listName = listName;
	}

	@When("^the user requests new shopping list created with that name$")
	public void theUserRequestsNewShoppingListCreatedWithThatName() {
		useCase.createNewShoppingList(user, listName);
	}

	@Then("^a new shopping list with given name is created for the user$")
	public void aNewShoppingListWithNameNIsCreatedForU() {
		Optional<ShoppingList> shoppingList = Context.shoppingListGateway.findByUserAndName(user, listName);
		assertThat(shoppingList.isPresent()).isTrue();
	}
}
