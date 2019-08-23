package designpattern.decortor.demo1;

import java.math.BigDecimal;

public abstract class Beverage {

    protected String description;

    public String getDescription() {

        return description;
    }

    public abstract BigDecimal cost();

}
