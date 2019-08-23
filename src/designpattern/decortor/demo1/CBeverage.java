package designpattern.decortor.demo1;

import java.math.BigDecimal;

public class CBeverage extends Beverage {

    public CBeverage() {
        description = "C Beverage";
    }

    public BigDecimal cost() {

        return new BigDecimal("2.5");
    }
}
