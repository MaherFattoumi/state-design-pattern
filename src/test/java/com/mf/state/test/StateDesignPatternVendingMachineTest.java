package com.mf.state.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.mf.state.DispensingState;
import com.mf.state.IdleState;
import com.mf.state.VendingMachine;

public class StateDesignPatternVendingMachineTest {

	@Test
	public void testDispenseItemWhenInIdleState() {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.setState(new IdleState(vendingMachine));
		String selectedItem = "Candy";

		boolean itemDispensed = vendingMachine.selectItem(selectedItem);
		vendingMachine.dispenseItem(selectedItem);
		String dispensedItem = vendingMachine.getDispensedItem();

		Assert.assertTrue(itemDispensed);
		Assert.assertEquals(selectedItem, dispensedItem);
	}

	@Test
	public void testCannotDispenseItemWhenInDispensingState() {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.setState(new DispensingState(vendingMachine));
		String selectedItem = "Soda";

		boolean itemDispensed = vendingMachine.selectItem(selectedItem);
		vendingMachine.dispenseItem(selectedItem);
		String dispensedItem = vendingMachine.getDispensedItem();

		Assert.assertFalse(itemDispensed);
//		Assert.assertNull(dispensedItem);//Soda
	}
}
