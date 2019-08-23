package designpattern.decortor.demo1;

import java.math.BigDecimal;

public class ACondimentDecorator extends BeverageCondimentDecorator {

    public ACondimentDecorator(Beverage beverage) {
        this.description = "A Condiment";
        this.beverage = beverage;
    }

    public String getDesciption() {

        return beverage.getDescription() + " " + this.description;
    }

    public BigDecimal cost() {

        return beverage.cost().add(new BigDecimal("0.2"));
    }

}
