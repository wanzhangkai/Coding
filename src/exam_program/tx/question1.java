package exam_program.tx;

/**
 * 1. 请找出一个字符串中最长连续升序的子字符串。
 * 例如：给定字符串 adgcefhkbp 的话，cefhk 就是目标子字符串。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/28 16:05
 */
public class Question1 {

    public static String solution1(String str) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < str.length(); i++) {
            StringBuffer tempSb = new StringBuffer();
            tempSb.append(str.charAt(i));
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) < str.charAt(j - 1)) {
                    break;
                }
                tempSb.append(str.charAt(j));
            }
            if (tempSb.length() >= sb.length()) {
                sb = tempSb;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "adgcefhkbp";
        System.out.println(solution1(a));
    }

}