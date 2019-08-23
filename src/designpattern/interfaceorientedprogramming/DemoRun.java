package designpattern.interfaceorientedprogramming;

public class DemoRun {

    public static void main(String ...args) {
        Player player1 = new PersonPlayer(new RemoteAttack());
        Player player2 = new RobortPlayer(new ShortAttack());

        player1.performAttack();
        player2.performAttack();
        player1.setPerformAttack(new ShortAttack());
        player1.performAttack();

    }
}
