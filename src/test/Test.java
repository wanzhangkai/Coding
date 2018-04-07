package test;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/4/2 1:42
 */
public class Test {

    static boolean foo(char c) {
        System.out.print(c);
        return true;
    }

    public static void main(String[] args) {
        int i = 0;
        for (foo('A'); foo('B') && i < 2; foo('C')) {
            i++;


            foo('D');
        }
    }
}