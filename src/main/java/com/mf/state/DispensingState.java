package com.mf.state;

public class DispensingState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public DispensingState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public boolean selectItem(String item) {
        return false;
    }

    @Override
    public void dispenseItem() {
        // Dispense the item
    }
}