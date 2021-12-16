package Array;

import java.util.BitSet;

public class HashMap_location_of_once_character_50 {
    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar2("abacc"));

    }

    public static int FirstNotRepeatingChar(String str) {
        int[] cnts = new int[128];
        for (int i = 0; i < str.length(); i++) {
            cnts[str.charAt(i)]++;
        }
        // 遍历hash
        for (int i = 0; i < str.length(); i++) {
            if (cnts[str.charAt(i)] == 1)
                return i;
        }
        return -1;
    }

    public static int FirstNotRepeatingChar2(String str) {
        BitSet bs1 = new BitSet(128); // {}
        BitSet bs2 = new BitSet(128);
//        System.out.println("bs1: " + bs1);
//        System.out.println(str.toCharArray()); //abacc
        for (char c : str.toCharArray()) {
            if (!bs1.get(c) && !bs2.get(c))
            {
                System.out.println(bs1.get(c)); //false
                System.out.println(bs2.get(c));//false
                bs1.set(c);     // 0 0 -> 0 1  将指定索引处的位设置为 true。
                System.out.println("=bs1: " + bs1); // {97} - {97, 98} - {97, 98, 99}
            }else if (bs1.get(c) && !bs2.get(c))
            {
                bs2.set(c);     // 0 1 -> 1 1
                System.out.println("=bs2: " + bs1);
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
