package designpattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

public class JdkOb implements Observer {

    private int arg1;
    private String arg2;
    private String name;

    public JdkOb(Observable observable) {
        observable.addObserver(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void update(Observable observable, Object arg) {
        if(null != observable) {
            JdkSubject ob = (JdkSubject) observable;
            this.arg1 = ob.getArg1();
            this.arg2 = ob.getArg2();

            display();
        }
    }

    public void display() {
        System.out.println("this Ob is " + name + " and this arg1 is " + arg1 + ", arg2 is " + arg2);
    }
}
