package designpattern.interfaceorientedprogramming;

public class Player {

    protected String name;
    protected int level;
    protected double attackPower;

    protected AttackBehaviorInterface attckbehavior;

    public void performAttack() {
        attckbehavior.attack();
    }

    public void setPerformAttack(AttackBehaviorInterface attckbehavior) {
        this.attckbehavior = attckbehavior;
    }
}
