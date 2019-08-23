package designpattern.observer.diy;

public class GamerSubject extends Subject {

    private int arg1 = 1;
    private String arg2 = "2";
    private double arg3 = 3.1;

    public void notifyObservers() {
        if(isChanged()) {
            for (ObInterface observer : obList) {
                observer.update(this, arg1, arg2, arg3);
            }

            clearChanged();
        }

    }

    public int getArg1() {

        return arg1;
    }

    public String getArg2() {

        return arg2;
    }

    public double getArg3() {

        return arg3;
    }

    public void setArgs(int arg1, String arg2, double arg3) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.arg3 = arg3;
        argsChanged();
    }

    public void argsChanged() {
        setChanged();
        notifyObservers();
    }
}
