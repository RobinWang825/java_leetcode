package BinarySearch;

/**
 *  JZ53 数字在升序数组中出现的次数
 */
public class JZ53_num_Count_in_SortedArray {
    public static void main(String[] args) {
//        int[] array = {1,2,3,3,3,3,998,999};
        int[] array = {1,2,3};
        int K = 4;
        System.out.println(GetNumberOfK(array,K));
    }
    // 解法2：二分查找
    public static int GetNumberOfK(int [] array , int K) {
        int first = binarySearch(array, K);
        System.out.println("first: "+first);
        int last = binarySearch(array, K + 1);  // 找到第一个比K值大的下标
        System.out.println("last: "+last); // 下标
        // first == array.length 说明数组中没有K这个值，找不到
        return (first == array.length || array[first] != K) ? 0 : last - first;

    }
    private static int binarySearch(int[] nums, int K) {
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= K)
                h = m;
            else
                l = m + 1;
        }
        return l; // 返回下标
    }

    // 解法1：暴力
    public static int GetNumberOfKMethod1(int [] array , int K) {
        //解法1：暴力   时间复杂度O(n)， 空间复杂度O(1)
         int ret = 0;
         for(int val : array)
         {
             if(val == K){
                 ++ret;
             }
         }
         return ret;
    }
}
