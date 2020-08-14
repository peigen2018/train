package com.peigen.test.dp.decoration;

import com.peigen.test.dp.decoration.base.Beverage;

public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "HouseBlend";
    }

    @Override
    public double cost() {
        return .99;
    }
}
