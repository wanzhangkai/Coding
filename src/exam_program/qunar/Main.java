package exam_program.qunar;

import java.util.Scanner;

/**
 * 包机切位是去哪儿网机票事业部非常重要的机票售卖方式，
 * 通常一架飞机如果航司的收益管理人员没有信心将绝大多数坐位卖出去，
 * 那么就会依靠类似去哪儿网的旅行平台或者旅行社分别承包一部分坐位来销售，
 * 航司销售人员则借此降低了航线亏损风险。
 * 如果n家包机商中的i家恰好将飞机的m个坐位全部承包完，没有任何多余或者不足，
 * 则是一次完美的包机切位，输出 perfect，否则就不够完美，输出 good，
 * 航司还需要自己销售一部分座位。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/4/2 15:24
 */
public class Main {


    public static void goOn(int start, int end, String str){

        for(int i = start; i <= end; i ++){

            String temp = str;
            temp += " " + i + ",";
            printStr(temp);
            int tempI = i;
            goOn(++ tempI, end, temp);
    }

    }

    public static void printStr(String str){
        str = str.substring(0, str.length() -1) + "}";
        System.out.println(str);
    }


    public static String solution(int m, int[] arr) {
        String good = "good";
        String perfect = "perfect";


        int startNum = 1;
        int endNum = 4;

        for(int i = startNum ; i <= endNum; i ++){
            String tempStr = "{ " + i + ",";
            printStr(tempStr);
            int tempI = i;

            goOn(++ tempI, endNum, tempStr);
        }


        return good;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);



        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            String a = solution(m, arr);
            System.out.println(a);
        }
    }

}