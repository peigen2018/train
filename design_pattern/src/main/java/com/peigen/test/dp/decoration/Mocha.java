package com.peigen.test.dp.decoration;

import com.peigen.test.dp.decoration.base.Beverage;
import com.peigen.test.dp.decoration.base.CondimentDecorator;

public class Mocha extends CondimentDecorator {
    private Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + ",Mocha";
    }

    @Override
    public double cost() {
        return 0.20 + this.beverage.cost();
    }
}
