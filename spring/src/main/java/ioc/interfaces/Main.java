package main.java.ioc.interfaces;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/5 10:18
 */
public class Main {

    public static void main(String[] args) {
        OneInterface oif = new OneInterfaceImpl();
        oif.say("baobao");
    }

}