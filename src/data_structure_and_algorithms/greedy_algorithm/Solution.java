package data_structure_and_algorithms.greedy_algorithm;

/**
 * [LeetCode] 392. Is Subsequence
 * Given a string s and a string t, check if s is subsequence of t.
 * You may assume that there is only lower case English letters in both s and t.
 * t is potentially a very long (length ~= 500,000) string, and sis a short string (<=100).
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of
 * the characters without disturbing the relative positions of the remaining characters.
 * (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * Example 1:
 * s = "abc", t = "ahbgdc"
 * <p>
 * Return true.
 * <p>
 * Example 2:
 * s = "axc", t = "ahbgdc"
 * <p>
 * Return false.
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/4/7 16:40
 */
public class Solution {
    public static boolean isSubsequence(String s, String t) {
        int sLength = s.length();     //s的长度
        int tLength = t.length(); //t的长度

        int sIndex = 0;       //记录找到了s的第几个字符
        int tIndex = 0;       //记录遍历到了t的第几个字符

        while (tIndex < tLength) {       //这里用到的贪心算法，就是在t中越先找到 s的字符 那么在t中就更容易的找到 s剩下的字符
            if (sIndex < sLength && (s.charAt(sIndex) == t.charAt(tIndex))) {        //找到一个相等的字符就查找s的下一个字符
                sIndex++;
            }
            tIndex++;
        }
        if (sIndex == sLength) {        //从前往后在t中找到了s的所有字符 。所以存在
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "bhagdc";
        System.out.println(isSubsequence(s, t));
    }

}