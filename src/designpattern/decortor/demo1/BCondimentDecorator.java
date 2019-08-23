package designpattern.decortor.demo1;

import java.math.BigDecimal;

public class BCondimentDecorator extends BeverageCondimentDecorator {

    public BCondimentDecorator(Beverage beverage) {
        this.description = "B Condiment";
        this.beverage = beverage;
    }

    public String getDescription() {

        return beverage.getDescription() + " " + this.description;
    }

    public BigDecimal cost() {

        return beverage.cost().add(new BigDecimal("0.4"));
    }
}
