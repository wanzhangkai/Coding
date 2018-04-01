package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/4/2 1:42
 */
public class Test {

    public static void main(String[] args) {
        String a = "1 2 345 6 7";
        List<Integer> list = new ArrayList<>();



        list.add(Integer.parseInt(String.valueOf(a.charAt(1))) );
        System.out.println(list.get(0));
    }
}