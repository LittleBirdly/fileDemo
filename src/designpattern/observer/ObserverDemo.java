package designpattern.observer;

import designpattern.observer.jdk.JdkOb;
import designpattern.observer.jdk.JdkSubject;

public class ObserverDemo {
    public static void main(String... args) {
        //自定义观察者设计模式实现
//        GamerSubject subinstance = new GamerSubject();
//        GamerObServer obinterface = new GamerObServer(subinstance);
//        obinterface.setName("ob1");
//        GamerObServer obinterface1 = new GamerObServer(subinstance);
//        obinterface1.setName("ob2");
//        GamerObServer obinterface2 = new GamerObServer(subinstance);
//        obinterface2.setName("ob3");
//
//        subinstance.setArgs(1,"1",1.1);
//        subinstance.setArgs(2,"2",2.2);
//        subinstance.setArgs(3,"3",3.3);


        //JDK中自带观察者设计模式实现
        JdkSubject sub = new JdkSubject();
        JdkOb ob1 = new JdkOb(sub);
        ob1.setName("1");
        JdkOb ob2 = new JdkOb(sub);
        ob2.setName("2");
        JdkOb ob3 = new JdkOb(sub);
        ob3.setName("3");
        JdkOb ob4 = new JdkOb(sub);
        ob4.setName("4");


        sub.setArgs(1,"1");
        sub.setArgs(2,"2");

    }
}
