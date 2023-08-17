package com.planetpope.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {
  private int x;
  private int y;
  private int sum;

  @Given("x={int}")
  public void x(Integer int1) {
      // Write code here that turns the phrase above into concrete actions
      x = int1;
  }
  @Given("y={int}")
  public void y(Integer int1) {
      // Write code here that turns the phrase above into concrete actions
      y = int1;
  }
  @When("x and y are added")
  public void x_and_y_are_added() {
      // Write code here that turns the phrase above into concrete actions
      Calculator calc = new Calculator();
      sum = calc.add(x,y);
  }
  @Then("the value should be {int}")
  public void the_value_should_be(Integer int1) {
    assertEquals(int1,sum);
  }
}
