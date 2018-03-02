package summary_of_knowledge.IO_demo;

import java.io.*;

/**
 * 使用 BufferedReader 在控制台读取字符
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/2 14:23
 */
public class BRReadLines {

    public static void main(String args[]) throws IOException {
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new
                InputStreamReader(System.in));
        String str;
        System.out.println("Enter lines of text.");
        System.out.println("Enter 'end' to quit.");
        do {
            str = br.readLine();
            if (!str.equals("end"))
                System.out.println(str);
        } while (!str.equals("end"));
    }

}