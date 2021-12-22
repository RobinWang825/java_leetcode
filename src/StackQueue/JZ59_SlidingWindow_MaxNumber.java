package StackQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class JZ59_SlidingWindow_MaxNumber {
    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        int size = 3;
        System.out.println(maxInWindows(num,size));
        // 调用Array.toString(a)，返回一个包含数组元素的字符串，这些元素被放置在括号内，并用逗号分开
        System.out.println(Arrays.toString(maxSlidingWindow(num,size)));

    }
    // 牛客 定义是ArrayList<Integer> 的解法
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (size > num.length || size < 1)
            return ret;
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);  /* 大顶堆 */
        for (int i = 0; i < size; i++)
            heap.add(num[i]);
        ret.add(heap.peek());
        // 控制条件 j<nums.length
        for (int i = 0, j = i + size; j < num.length; i++, j++) {            /* 维护一个大小为 size 的大顶堆 */
            heap.remove(num[i]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }
    // LeetCode 定义是 int[] 的解法
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1,o2)->o2-o1);// 大顶堆
        // 存储结果
        int[] ret = new int[nums.length-k+1];
        // ArrayList<Integer> ret = new ArrayList<>();

        // 边界条件
        if(k>nums.length || k<1){
            return new int[0];
        }

        //添加, 窗口还未形成
        int index=0;
        for(int i=0;i<k;i++){
            heap.add(nums[i]);
            // ret.add(heap.peek());
        }
        ret[index++] = heap.peek();

        //滑动
        // 控制条件 j<nums.length
        for(int i=0,j=i+k;j<nums.length;i++,j++){
            heap.remove(nums[i]);
            heap.add(nums[j]);
            ret[index++] = heap.peek();
            // ret.add(heap.peek());
        }
        return ret;

    }

}
