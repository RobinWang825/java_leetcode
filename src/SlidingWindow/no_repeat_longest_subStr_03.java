package SlidingWindow;

import java.util.HashMap;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class no_repeat_longest_subStr_03 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

    }
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        // 定义 左指针，最大长度
        int left = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {

            // map中包含，左指针右移，滑动窗口
            if (map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i))+1);
            }
            // map中不包含 put进去，计算最大长度
            map.put(s.charAt(i),i); // {a=0,i=0}
            maxLength = Math.max(i-left+1,maxLength);
        }
        return maxLength;

    }
}
