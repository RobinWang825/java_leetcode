package Array;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/** JZ 56 II. 数组中数字出现的次数 II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 */
public class SingleNumber_56 {
    public static void main(String[] args) {
        int[] nums = {3,4,3,3};
        System.out.println(singleNUmber1(nums));
    }

    /**
     * HashMap通用解法，找只出现1次的key；136题，剑指56都可以
     * @param nums
     * @return
     */
    public static int singleNUmber1(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums.length-1; i >=0; --i) {
            int key = nums[i];
//            if (!map.containsKey(key)) {
//                map.put(key, 1);
//            }else {
//                map.put(key,map.get(key)+1 );
//            }
            // 优化上面的if else
            // getOrDefault: 返回 key 相映射 的 value，如果给定的 key 在映射关系中找不到，则返回指定的默认值。
            map.put(key,map.getOrDefault(key,0)+1);
        }
        // 遍历Map 使用 Set<Map.Entry<K，V>> entrySet() 返回此映射中包含的映射关系的set视图。
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getValue()==1){
                return entry.getKey();
            }
        }
        return -1;

    }

    /**
     * 超出内存限制了  BitSet 怎么会这样 bitset不是节省空间的吗
     * @param nums
     * @return
     */
    public static int singleNUmber(int[] nums){

        BitSet bs1 = new BitSet(128); // {}
        BitSet bs2 = new BitSet(128); // {}
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!bs1.get(num) && !bs2.get(num)){
                bs1.set(num);
            }else if(bs1.get(num) && !bs2.get(num)){
                bs2.set(num);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (bs1.get(num) ^ bs2.get(num)){
                return num;
            }
        }
        return 1;

    }

}
