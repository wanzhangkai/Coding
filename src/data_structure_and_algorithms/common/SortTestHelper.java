package data_structure_and_algorithms.common;

/**
 * @author wanzhangkai@foxmail.com
 * @date 2018/2/4 23:30
 */
public class SortTestHelper {

    private SortTestHelper() {
    }

    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {

        assert rangeL <= rangeR;
        //assert，当内容为true时继续执行，为false时停止执行。

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random()*(rangeR-rangeL+1)+rangeL); //java自动装箱
        }
        return arr;
    }

}