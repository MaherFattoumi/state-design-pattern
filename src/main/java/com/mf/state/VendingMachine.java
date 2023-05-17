package com.mf.state;

public class VendingMachine {
    private VendingMachineState state;
    private String dispensedItem;

    public VendingMachine() {
        dispensedItem = null;
    }

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public boolean selectItem(String item) {
        return state.selectItem(item);
    }

    public void dispenseItem(String item) {
        dispensedItem = item;
        state.dispenseItem();
    }

    public String getDispensedItem() {
        return dispensedItem;
    }
}