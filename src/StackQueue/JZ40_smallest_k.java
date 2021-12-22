package StackQueue;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class JZ40_smallest_k {
    public static void main(String[] args) {
        int[] nums = {4,5,1,6,2,7,3,8};
        int k = 4;
        System.out.println(GetLeastNumbers_Solution(nums,k)); //[4, 3, 1, 2]

    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
        if (k > nums.length || k <= 0)
            return new ArrayList<>();
        //  PriorityQueue 默认是小顶堆，可以在在初始化时使用 Lambda 表达式 (o1, o2) -> o2 - o1 来实现大顶堆。
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(); // 默认是小顶堆，可以用来求【最大的k个数】
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o1 - o2); // 小顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1); //大顶堆
        // 使用大顶堆。在添加一个元素之后，如果大顶堆的大小大于 K，那么将大顶堆的堆顶元素去除，也就是将当前堆中值最大的元素去除，从而使得留在堆中的元素都比被去除的元素来得小。
        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);
    }
}
