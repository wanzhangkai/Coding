package exam_program.meituan;

import java.util.Scanner;

/**
 * 大富翁游戏，玩家根据骰子的点数决定走的步数，
 * 即骰子点数为1时可以走一步，点数为2时可以走两步，
 * 点数为n时可以走n步。求玩家走到第n步
 * （n<=骰子最大点数且是方法的唯一入参）时，
 * 总共有多少种投骰子的方法。
 * 类似变态小跳蛙？
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/3/21 23:50
 */
public class MonopolyGame {

    public int solution(int n) {
        if (n <= 0) {
            return 0;
        }
        return (int) Math.pow(2, n - 1);
    }

    int sum = 0;

    public int solution1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1){
            return 1;
        }
        sum = 2*solution1(n - 1);
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        MonopolyGame mg = new MonopolyGame();
        System.out.println(mg.solution1(n));
    }

//    public static void main(String[] args) {
//        for (int i = 0; i <= 6; i++) {
//            switch (i) {
//                case 1:
//                    System.out.println(solution(1));
//                    break;
//                case 2:
//                    System.out.println(solution(2));
//                    break;
//                case 3:
//                    System.out.println(solution(3));
//                    break;
//                case 4:
//                    System.out.println(solution(4));
//                    break;
//                case 5:
//                    System.out.println(solution(5));
//                    break;
//                case 6:
//                    System.out.println(solution(6));
//                    break;
//                default:
//                    break;
//            }
//        }
//    }

}