package exam_program.shenzhouxinxi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 神州信息笔试题2道：
 * 输入一段字符串，字符串中只包含大小写字母。
 * 要求完成函数删除给定字符串中出现次数最少的字符。
 * 输出删除完的字符串。如果有多个出现次数一样的字符，
 * 都认为最少，一并删除。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/4/1 20:34
 */
public class Main {

    public static String solution(String str) {
        char[] chars = new char[500];
        char[] charArr = str.toCharArray();
        int max = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < charArr.length; i++) {
            int tempCount = (int) ++chars[charArr[i]];
            if (tempCount >= max) {
                if (tempCount > max)
                    set.clear();
                max = tempCount;
                set.add(charArr[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        Object[] arr = set.toArray();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j <= max; j++) {
                sb.append((arr[i]).toString());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String str = in.next();
            System.out.println(solution(str));
        }
    }

}