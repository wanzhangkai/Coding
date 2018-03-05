package main.java.ioc.interfaces;

public class OneInterfaceImpl implements OneInterface {

    public void say(String arg) {
        System.out.println("ServiceImpl say: " + arg);
    }

}
