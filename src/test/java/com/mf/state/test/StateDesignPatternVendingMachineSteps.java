package com.mf.state.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;

import com.mf.state.DispensingState;
import com.mf.state.IdleState;
import com.mf.state.VendingMachine;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "state-design-pattern-vendingMachine.feature")
public class StateDesignPatternVendingMachineSteps {
	private VendingMachine vendingMachine;
	private String selectedItem;
	private boolean itemDispensed;

	@Given("^a vending machine in idle state$")
	public void aVendingMachineInIdleState() {
		vendingMachine = new VendingMachine();
		vendingMachine.setState(new IdleState(vendingMachine));
	}

	@Given("^a vending machine in dispensing state$")
	public void aVendingMachineInDispensingState() {
		vendingMachine = new VendingMachine();
		vendingMachine.setState(new DispensingState(vendingMachine));
	}

	@When("^a user selects an item$")
	public void aUserSelectsAnItem() {
		selectedItem = "Candy";
		itemDispensed = vendingMachine.selectItem(selectedItem);
	}

	@Then("^the vending machine should dispense the selected item$")
	public void theVendingMachineShouldDispenseTheSelectedItem() {
		assertTrue(itemDispensed);
		assertEquals(selectedItem, vendingMachine.getDispensedItem());
	}

	@Then("^the vending machine should not dispense the selected item$")
	public void theVendingMachineShouldNotDispenseTheSelectedItem() {
		assertFalse(itemDispensed);
		assertNull(vendingMachine.getDispensedItem());
	}
}
