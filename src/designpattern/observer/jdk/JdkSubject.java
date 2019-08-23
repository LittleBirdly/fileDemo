package designpattern.observer.jdk;

import java.util.Observable;

public class JdkSubject extends Observable {

    private int arg1;
    private String arg2;

    public void setArgs(int arg1, String arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        argsChanged();
    }

    public int getArg1() {

        return arg1;
    }

    public String getArg2() {

        return arg2;
    }

    public void argsChanged() {
        setChanged();
        notifyObservers();
    }

}
