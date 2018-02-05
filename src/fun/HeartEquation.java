package fun;

/**
 * 心形方程：
 * (x^2 + y^2 - 1)^3 - (x^2)*(y^3) = 0
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/5 14:07
 */
public class HeartEquation {

    public static void main(String[] args) {

        for (double y = 1.3; y >= -1.1; y -= 0.06) {
            for (double x = -1.2; x <= 1.2; x += 0.017) {
                //0.015
                if (Math.pow((x * x + y * y - 1.0), 3) - x * x * y * y * y <= 0.0) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}