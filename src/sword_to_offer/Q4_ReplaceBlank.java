package sword_to_offer;

/**
 * 替换空格：
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/4 15:52
 */
public class Q4_ReplaceBlank {

    public static String replace(String str) {
        if (str == null) {
            return null;
        }

        //new一个可以append的字符串
        StringBuffer newStr = new StringBuffer();

        //从头开始遍历这个字符串的每一个元素
        //感觉Java实现好简洁啊
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                newStr.append("%20");
            } else {
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }

    public static void main(String[] args) {
        System.out.println(replace("we are friends. "));
    }
}