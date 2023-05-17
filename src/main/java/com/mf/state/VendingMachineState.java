package com.mf.state;

public interface VendingMachineState {
    boolean selectItem(String item);
    void dispenseItem();
}