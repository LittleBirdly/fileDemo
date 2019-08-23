package designpattern.decortor.demo1;

import java.math.BigDecimal;

public class CCondimentDecorator extends BeverageCondimentDecorator{

    public CCondimentDecorator(Beverage beverage) {
        this.description = "C Condiment";
        this.beverage = beverage;
    }

    public String getDescription() {

        return beverage.getDescription() + " " + this.description;
    }

    public BigDecimal cost() {

        return beverage.cost().add(new BigDecimal("0.3"));
    }
}
