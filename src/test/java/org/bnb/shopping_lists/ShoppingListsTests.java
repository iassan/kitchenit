package org.bnb.shopping_lists;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "org.bnb.shopping_lists", features = "src/test/resources/scenarios")
public class ShoppingListsTests {

}
