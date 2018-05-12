package com.example.waiter;

import java.util.function.Supplier;

class SupplierObject {
    Supplier<Boolean> item;

    public SupplierObject(boolean val) {
        this.item = () -> val;
    }

    public void setItem(boolean val) {
        this.item = () -> val;
    }

    public Supplier<Boolean> getItem() {
        return this.item;
    }

    @Override
    public String toString() {
        return "() -> " + this.getItem().get().toString();
    }
}
