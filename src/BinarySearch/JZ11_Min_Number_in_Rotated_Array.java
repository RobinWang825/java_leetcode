package BinarySearch;

/**
 * JZ11 旋转数组的最小数字
 * 比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的
 */
public class JZ11_Min_Number_in_Rotated_Array {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        int[] nums2 = {1, 1, 1, 0, 1};
        int[] nums3 = {3, 2, 1, 5, 4};
//        System.out.println(minNumberInRotateArray(nums));
        System.out.println(minNumberInRotateArray(nums2));// 0
//        System.out.println(minNumberInRotateArray(nums3));

    }

    public static int minNumberInRotateArray(int[] nums) {
        // 边界情况
        if (nums.length == 0) {
            return 0;
        }
        // 二分查找
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            // 如果l = m = h 无法确定较小值在哪半边，需要使用顺序查找
            // ⚠️注意，这3个情况，不能写成3种if，不然 <=的情况会执行，造成错误
            if (nums[l] == nums[m] && nums[m] == nums[h]) {
                return minNumberOrderFind(nums, l, h);
            } else if (nums[m] <= nums[h]) {
                h = m;
            } else //  (nums[m] > nums[h])
            {
                l = m + 1;
            }
        }
        return nums[l];
    }

    public static int minNumberOrderFind(int[] nums, int l, int h) {
        for (int i = l; i < h; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[l];
    }
}
