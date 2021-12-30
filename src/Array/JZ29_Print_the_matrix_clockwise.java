package Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * JZ29 顺时针打印矩阵
 * 可以看一下JZ04: 二维数组中的查找
 */
public class JZ29_Print_the_matrix_clockwise {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(spiralOrder0(matrix)));

//        System.out.println(spiralOrder(matrix));
//        int[][] ints = new int[0][0];
//        System.out.println(spiralOrder(ints));

//        ArrayList<Integer> objects = new ArrayList<>();
//        System.out.println(objects); // []

    }

    public static int[] spiralOrder0(int[][] matrix) {
        // 这里要处理一下 边界情况，不然后面 ret 数组长度为0时会报边界错误
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int[] ret = new int[matrix.length*matrix[0].length];
        // 初始化
        int r1 = 0, c1 = 0;
        int r2 = matrix.length - 1;
        int c2 = matrix[0].length - 1;
        int index = 0;
        // 循环，边界条件
        while (r1 <= r2 && c1 <= c2) {
            // r1 上
            for (int i = c1; i <= c2; i++) {
                ret[index++] = matrix[r1][i];
            }
            // c2 右   注意 i=r1+1 不然会重复添加四角的值
            for (int i = r1 + 1; i <= r2; i++) {
                ret[index++] = matrix[i][c2];
            }
            // r2 下    判断 r1和r2
            if (r2 > r1)
//            if (r1 != r2)
            {
                for (int i = c2 - 1; i >= c1; i--) {
                    ret[index++] = matrix[r2][i];
                }
            }
            // c1 左
            if (c1 < c2)
//            if (c1 != c2)
            {
                for (int i = r2 - 1; i > r1; i--) {
                    ret[index++] = matrix[i][c1];
                }
            }
            r1++;
            c2--;
            r2--;
            c1++;
        }
        return ret;
    }

    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        // 这里要处理一下 边界情况，不然后面 ret 数组长度为0时会报边界错误
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        // 存储结果
//        int[] ret = new int[];
        ArrayList<Integer> ret = new ArrayList<>();
        // 初始化
        int r1 = 0, c1 = 0;
        int r2 = matrix.length - 1;
        int c2 = matrix[0].length - 1;
        // 循环，边界条件
        while (r1 <= r2 && c1 <= c2) {
            // r1 上
            for (int i = c1; i <= c2; i++) {
                ret.add(matrix[r1][i]);
            }
            // c2 右   注意 i=r1+1 不然会重复添加四角的值
            for (int i = r1 + 1; i <= r2; i++) {
                ret.add(matrix[i][c2]);
            }
            // r2 下    判断 r1和r2
            if (r2 > r1)
//            if (r1 != r2)
            {
                for (int i = c2 - 1; i >= c1; i--) {
                    ret.add(matrix[r2][i]);
                }
            }
            // c1 左
            if (c1 < c2) {
                for (int i = r2 - 1; i > r1; i--) {
                    ret.add(matrix[i][c1]);
                }
            }
            r1++;
            c2--;
            r2--;
            c1++;
        }
        return ret;
    }


}
