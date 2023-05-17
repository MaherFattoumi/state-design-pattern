package com.mf.state;

public class IdleState implements VendingMachineState {
    private final VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public boolean selectItem(String item) {
        vendingMachine.setState(new DispensingState(vendingMachine));
        return true;
    }

    @Override
    public void dispenseItem() {
        throw new IllegalStateException("Cannot dispense item in idle state");
    }
}