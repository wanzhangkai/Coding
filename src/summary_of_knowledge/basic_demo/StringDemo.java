package summary_of_knowledge.basic_demo;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/16 21:44
 */
public class StringDemo {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("wan");
        sb.append("zhang");
        sb.insert(1, "a");
        System.out.println(sb);

        StringBuilder sb2 = new StringBuilder();
        sb2.append("wan");
        sb2.append("zhang");
        sb2.insert(0, "a");
        System.out.println(sb2);
    }
}