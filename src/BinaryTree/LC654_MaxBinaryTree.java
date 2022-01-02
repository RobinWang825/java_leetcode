package BinaryTree;

/** 654. 最大二叉树
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 *
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC654_MaxBinaryTree {
    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        TreeNode treeNode = constructMaximumBinaryTree(nums);
        System.out.println(treeNode.val);
    }


    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums,0,nums.length-1);
    }
    public static TreeNode build(int[] nums, int low, int high)
    {
        // base case
        if(low>high) return null;
        // 找数组最大值
        int maxVal = nums[low];
        int index = low;
        for(int i = low; i<=high;i++)
        {
            if(nums[i] > maxVal)
            {
                maxVal = nums[i];
                index = i;
            }
        }
        // // 找到数组中的最大值和对应的索引
        // int index = -1, maxVal = Integer.MIN_VALUE;
        // for (int i = low; i <= high; i++) {
        //     if (maxVal < nums[i]) {
        //         index = i;
        //         maxVal = nums[i];
        //     }
        // }
        // 构造根节点
        TreeNode root = new TreeNode(maxVal);
        // 左右子树递归
        root.left = build(nums, low,index - 1);
        root.right = build(nums, index+1, high);
        return root;
    }
}
