package org.bnb.shopping_lists;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.bnb.shopping_list.Context;
import org.bnb.shopping_list.ShoppingList;
import org.bnb.shopping_list.ShoppingListManagementUseCase;
import org.bnb.shopping_list.User;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingListsSteps {

    private String shoppingListName;

    private User user;

    private ShoppingListManagementUseCase shoppingListManagementUseCase = new ShoppingListManagementUseCase();
    private String itemName;
    private int quantity;

    @Before
    public void setup() {
        Context.shoppingListGateway = new InMemoryShoppingListGateway();
    }

    @Given("^a logged in user$")
    public void givenLoggedInUser() {
        user = new User("Thor");
        Context.loggedInUser = user;
    }

    @And("^a shopping list's name$")
    public void aShoppingListSName() {
        this.shoppingListName = "Test list";
    }

    @When("^the user requests new shopping list created with that name$")
    public void theUserRequestsNewShoppingListCreatedWithThatName() {
        shoppingListManagementUseCase.createNewShoppingList(user, shoppingListName);
    }

    @Then("^a new shopping list with given name is created for the user$")
    public void aNewShoppingListWithNameNIsCreatedForU() {
        Optional<ShoppingList> shoppingList = Context.shoppingListGateway.findByUserAndName(user, shoppingListName);
        assertThat(shoppingList.isPresent()).isTrue();
    }

    @And("^a shopping list$")
    public void aShoppingList() throws Throwable {
        shoppingListName = "Test list";
        ShoppingList shoppingList = new ShoppingList(shoppingListName);
        Context.shoppingListGateway.save(user, shoppingList);
    }

    @And("^the user has rights to modify this list$")
    public void theUserHasRightsToModifyThisList() {
        // user owns the list, noting else needs to be done
    }

    @When("^the user requests adding quantity of item to the list$")
    public void theUserRequestsAddingQuantityOfItemToTheList() {
        itemName = "Cucumber";
        quantity = 1;
        shoppingListManagementUseCase.addItemToList(shoppingListName, itemName, quantity);
    }

    @Then("^this new item is added to the list with given quantity$")
    public void thisNewItemIsAddedToTheListWithGivenQuantity() {
        ShoppingList shoppingList = Context.shoppingListGateway.findByUserAndName(user, shoppingListName).get();

        assertThat(shoppingList.contains(itemName)).isTrue();
        assertThat(shoppingList.getItemQuantity(itemName)).isEqualTo(quantity);
    }

    @And("^the user has rights to delete this list$")
    public void theUserHasRightsToDeleteThisList() {
        // user owns the list, noting else needs to be done
    }

    @When("^the user requests deleting the list$")
    public void theUserRequestsDeletingTheList(){
        shoppingListManagementUseCase.deleteList(shoppingListName);
    }

    @Then("^this list is deleted$")
    public void thisListIsDeleted(){
        Optional<ShoppingList> shoppingList = Context.shoppingListGateway.findByUserAndName(user, shoppingListName);

        assertThat(shoppingList.isPresent()).isFalse();
    }

    @And("^this list contains the item$")
    public void thisListContainsTheItem() {
        ShoppingList shoppingList = Context.shoppingListGateway.findByUserAndName(user, shoppingListName).get();
        shoppingList.add(itemName, 1);
        Context.shoppingListGateway.save(user, shoppingList);
    }

    @When("^the user requests removing the item from the list$")
    public void theUserRequestsRemovingTheItemFromTheList() {
        shoppingListManagementUseCase.removeItemFromList(shoppingListName, itemName);
    }

    @Then("^the list no longer contains the item$")
    public void theListNoLongerContainsTheItem() {
        ShoppingList shoppingList = Context.shoppingListGateway.findByUserAndName(user, shoppingListName).get();
        assertThat(shoppingList.contains(itemName)).isFalse();
    }
}
