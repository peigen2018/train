package com.pg.demo.algorithm.formula;

import com.pg.demo.algorithm.formula.domain.formula.FormulaProcessor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Formula {

    public static void main(String[] args) {

        String formula = "{a} * {b} + {c} * {d} + ({a} * {b})";


        Map<String, BigDecimal> params = new HashMap<>();
        params.put("a",new BigDecimal(1));
        params.put("b",new BigDecimal(2));
        params.put("c",new BigDecimal(3));
        params.put("d",new BigDecimal(4));

        System.out.println(FormulaProcessor.excute(formula, params));

    }
}
