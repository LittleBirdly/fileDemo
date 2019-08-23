package designpattern.decortor.demo1;

import java.math.BigDecimal;

public class ABeverage extends Beverage {

    public ABeverage() {
        description = "A Beverage";
    }

    public BigDecimal cost() {

        return new BigDecimal("1.0");
    }
}
