package designpattern.observer.diy;

public class GamerObServer implements ObInterface, DisplayInterface{

    private int arg1;
    private String arg2;
    private double arg3;
    private String name;

    public GamerObServer(SubjectInterface subject) {
        subject.registObserver(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void update(SubjectInterface subject, Object... args) {
        if(null != subject && null != args) {
            if(null != args[0]) {
                this.arg1 = Integer.parseInt(args[0].toString());
            }
            if(null != args[1]) {
                this.arg2 = args[1].toString();
            }
            if(null != args[2]) {
                this.arg3 = Double.parseDouble(args[2].toString());
            }

            display();
        }
    }

    public void display() {
        System.out.println("this observer is " + this.name + " and this arg1 is " + arg1 + ", this arg2 is " + arg2 + ", this arg3 is " + arg3);
    }
}
