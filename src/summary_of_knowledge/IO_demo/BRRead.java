package summary_of_knowledge.IO_demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 使用 BufferedReader 在控制台读取字符
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/2 14:15
 */
public class BRRead {

    public static void main(String args[]) throws IOException {
        char c;
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new
                InputStreamReader(System.in));
        System.out.println("输入字符, 按下 'q' 键退出。");
        // 读取字符
        do {
            c = (char) br.read();
            if (c != 'q') {
                System.out.println(c);
            }
        } while (c != 'q');
    }

}