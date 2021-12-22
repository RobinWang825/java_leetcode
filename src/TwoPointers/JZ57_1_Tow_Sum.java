package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;

public class JZ57_1_Tow_Sum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums,target)));
//        System.out.println(twoSum(nums,target));

        System.out.println(FindNumbersWithSum(nums,target));
    }
    // leetcode   int[] 返回值
    public static int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        while(i<j){
            int cur = nums[i]+nums[j];
            if(cur == target){
                return new int[] {nums[i],nums[j]};
            }
            if(cur < target){
                i++;
            }
            else {
                j--;
            }
        }
        return new int[0];
    }

    // 牛客   ArrayList返回值
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int i =0,j= array.length-1;
        // 存储结果
        ArrayList<Integer> ret = new ArrayList<>();
        while(i<j){
            int cur = array[i]+array[j];
            if(cur == sum){
                // 数组 转为 list集合
                ret.add(array[i]);
                ret.add(array[j]);
                return ret;
//                return new ArrayList<>(Arrays.asList(array[i],array[j]));
            }
            if (cur<sum){
                i++;
            }
            else {
                j--;
            }
        }

        return new ArrayList<>();
    }


}
