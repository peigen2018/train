package com.peigen.test.dp.decoration.base;

public abstract class Beverage {
    protected String description = "Unknow Beverage";

    public String getDescription() {
        return this.description;
    }

    public abstract double cost();
}
