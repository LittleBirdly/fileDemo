package designpattern.decortor.demo1;

import java.math.BigDecimal;

public class BBeverage extends Beverage{

    public BBeverage() {
        description = "B Beverage";
    }

    public BigDecimal cost() {

        return new BigDecimal("2.0");
    }
}
