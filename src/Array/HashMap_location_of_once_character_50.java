package Array;

import java.util.BitSet;

/**
 * 剑指50 - 第一个只出现一次的字符
 * 在一个长为 字符串中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 */
public class HashMap_location_of_once_character_50 {
    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar2("abaccc"));

    }

    public static int FirstNotRepeatingChar(String str) {
        // ASCII 码只有 128 个字符，因此可以使用长度为 128 的整型数组来存储每个字符出现的次数。
        int[] cnts = new int[128];
        for (int i = 0; i < str.length(); i++) {
            cnts[str.charAt(i)]++;
        }
        // 遍历hash
        for (int i = 0; i < str.length(); i++) {
            if (cnts[str.charAt(i)] == 1)
                return i;
//                return s.charAt(i);
        }
        return -1;
    }

    public static int FirstNotRepeatingChar2(String str) {
        BitSet bs1 = new BitSet(128); // {}
        BitSet bs2 = new BitSet(128);
        for (char c : str.toCharArray()) {
            if (!bs1.get(c) && !bs2.get(c))
            { // get: 返回指定索引处的位值。
                bs1.set(c);     // 0 0 -> 0 1  将指定索引处的位设置为 true。
//                System.out.println("=bs1: " + bs1); // {97} - {97, 98} - {97, 98, 99}
            }else if (bs1.get(c) && !bs2.get(c))
            {
                bs2.set(c);     // 0 1 -> 1 1
//                System.out.println("=bs2: " + bs1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (bs1.get(c) && !bs2.get(c))  // 0 1
                return i;
        }
        return -1;
    }

}
