package data_structure_and_algorithms.greedy_algorithm;

import java.util.Arrays;

/**
 * 贪心算法-分饼干给每个不同贪心的小朋友
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/4/7 16:04
 */
public class AssignCookies {

    public static int solution(int[] greedy, int[] cookies) {

        //先对两个数组排序
        Arrays.sort(greedy);
        Arrays.sort(cookies);

        int gi = greedy.length - 1, ci = cookies.length - 1;
        int res = 0;
        while (gi >= 0 && ci >= 0) {
            //如果最大的cookies能满足最贪心的小朋友则res++
            if (cookies[ci] >= greedy[gi]) {
                res++;
                ci--;
                gi--;
            } else {
                gi--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] greedy = {1, 2, 3};
        int[] cookies = {0, 1, 1, 1};
        System.out.println(solution(greedy, cookies));
    }

}