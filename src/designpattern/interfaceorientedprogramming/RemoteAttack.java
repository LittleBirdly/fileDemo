package designpattern.interfaceorientedprogramming;

public class RemoteAttack implements AttackBehaviorInterface {

    public void attack() {
        System.out.println("this player use the remote attack！");
    }
}
