package designpattern.decortor;

import designpattern.decortor.demo1.*;

public class DecoratorDemo {
    public static void main(String... args) {
        ABeverage a = new ABeverage();
        ACondimentDecorator ac = new ACondimentDecorator(a);
        ACondimentDecorator ac2 = new ACondimentDecorator(ac);
        CCondimentDecorator cc = new CCondimentDecorator(ac2);

        System.out.println("this beverage price is " + cc.cost());

        BBeverage b = new BBeverage();
        BCondimentDecorator bc = new BCondimentDecorator(b);
        BCondimentDecorator bc2 = new BCondimentDecorator(bc);

        System.out.println("this beverage price is " + bc2.cost());


    }
}
