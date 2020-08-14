package com.peigen.test.dp.decoration;

import com.peigen.test.dp.decoration.base.Beverage;

public class Test {

    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        System.out.println(beverage.getDescription() + beverage.cost());
    }
}
