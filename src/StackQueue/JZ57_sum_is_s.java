package StackQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JZ57_sum_is_s {
    public static void main(String[] args) {
        int target = 15;
        int[][] continuousSequence = findContinuousSequence(target);
        for (int i = 0; i < continuousSequence.length; i++) {
            System.out.println(Arrays.toString(continuousSequence[i]));
        }
//        System.out.println(continuousSequence[0]); // [ [] [] ]

//        System.out.println(Arrays.toString(findContinuousSequence(target)));
//        List<int[]> res = new ArrayList<>();
//        System.out.println(res.toArray(new int[0][]));


    }

    public static int[][] findContinuousSequence(int target) {
        // 双指针/滑动窗口
        int i = 1, j = 2, s = 3; // s是元素和
        // 存出结果的二维数组构建
        List<int[]> res = new ArrayList<>();
        // 控制循环 条件是 i<j
        while (i < j) {
            // 相等
            if (s == target) {
                // 一维数组 ans ，最后添加到res里面
                int[] ans = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    ans[k - i] = k;
                }
                res.add(ans);
            }

            // 注意判定的顺序，要先判定是否大于target，再判定是否小于target
            if (s >= target) {
                // 注意这个顺序！
                s -= i;
                i++;

            }
            // 不相等
            if (s < target) {
                // 注意这个顺序！
                j++;
                s += j;
            }
        }
        // 返回值
        return res.toArray(new int[0][]); // ArrayList转int[][]
    }
}
