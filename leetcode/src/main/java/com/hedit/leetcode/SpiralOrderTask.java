package com.hedit.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Y
 * Created on 2024-08-22 16:34
 * @description 54, 矩阵循环
 */
/*给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

 示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]

 示例 2：

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]

 提示：

 m == matrix.length
 n == matrix[i].length
 1 <= m, n <= 10
 -100 <= matrix[i][j] <= 100

 Related Topics 数组 矩阵 模拟 👍 1741 👎 0*/
public class SpiralOrderTask {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));
    }


        public static List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> target = new ArrayList<>();

            int u = 0;
            int r = matrix[0].length - 1;
            int d = matrix.length - 1;
            int l = 0;

            while (true) {
                for (int i = l; i <= r; i++) {
                    target.add(matrix[u][i]);
                }
                if (++u > d) {
                    break;
                }
                for (int i = u; i <= d; i++) {
                    target.add(matrix[i][r]);
                }
                if (--r < l) {
                    break;
                }
                for (int i = r; i >= l; i--) {
                    target.add(matrix[d][i]);
                }
                if (--d < u) {
                    break;
                }
                for (int i = d; i >= u; i--) {
                    target.add(matrix[i][l]);
                }
                if (++l > r) {
                    break;
                }
            }


            return target;
        }

}
