package summary_of_knowledge.IO_demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 不输入数组个数n，来输入数组的方法
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/4/2 1:35
 */
public class OutputArrayByNoN {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String a = in.nextLine();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < a.length(); i++) {
                StringBuilder sb = new StringBuilder();
                while (i < a.length() && a.charAt(i) != ' ') {
                    sb.append(a.charAt(i));
                    i++;
                }
                if (sb.length() != 0) {
                    list.add(Integer.parseInt(sb.toString()));
                }
            }
            int[] arr = new int[list.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = list.get(i);
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
                System.out.print(" ");
            }
        }
    }

}