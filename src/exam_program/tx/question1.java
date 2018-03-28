package exam_program.tx;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 请找出一个字符串中最长连续升序的子字符串。
 * 例如：给定字符串 adgcefhkbp 的话，cefhk 就是目标子字符串。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/28 16:05
 */
public class Question1 {

    //O(n)
    public static List<String> solution(String str) {
        if (str == null) {
            return null;
        }

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            StringBuilder tempSb = new StringBuilder();
            tempSb.append(str.charAt(i));
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) < str.charAt(j - 1)) {
                    break;
                }
                tempSb.append(str.charAt(j));
                i = j;
            }
            if (tempSb.length() == sb.length()) {
                sb = tempSb;
                list.add(tempSb.toString());
            }
            if (tempSb.length() > sb.length()) {
                sb = tempSb;
                list.clear();   //如果后面有更长的则清空list
                list.add(tempSb.toString());
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String a = "adgcefhkbp";
        List<String> s = solution(a);
        for (String i : s) {
            System.out.println(i);
        }

        String b = "abedkfghcp";
        List<String> s2 = solution(b);
        for (String i : s2) {
            System.out.println(i);
        }
    }

}