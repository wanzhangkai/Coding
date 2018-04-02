package exam_program.qunar;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/4/2 16:53
 */
public class Main2 {
    int N = 20;

    int[] array = {1, 2, 3, 4, 8, 10};

    public static void main(String[] args) {
        new Main2().run();
    }

    public void run() {

        int startNum = 0;
        int endNum = array.length;


        for (int i = startNum; i < endNum; i++) {
//            String tempStr = "{ " + array[i] + ",";
            int sum = 0;
            sum += array[i];
            printStr(sum);
            int tempI = i;
            goOn(++tempI, endNum, sum);
        }
    }

    public String goOn(int start, int end, int sum) {

        for (int i = start; i < end; i++) {
            int temp = sum;
            temp += array[i];
            if (printStr(temp) == "perfect") {
                return "perfect";
            }
            String temp1 = printStr(temp);
            goOn(++i, end, temp);
        }
        return null;

    }

    public String printStr(int sum) {
        String perfect = "perfect";
        if (sum == N) {
            return perfect;
        }
        return null;
    }
}
