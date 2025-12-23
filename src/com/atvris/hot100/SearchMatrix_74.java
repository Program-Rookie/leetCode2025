package com.atvris.hot100;

/**
 * 搜索二维矩阵
 * @author zjh
 * @date 2025/12/23 16:40
 */
public class SearchMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 列二分 然后 行二分
        int m = matrix.length, n = matrix[0].length;
        int rowLeft = 0, rowRight = m - 1;
        while(rowLeft < rowRight) { // 不做=。避免死循环
            int rowMid = rowLeft + (rowRight - rowLeft + 1)/2; // +1避免死循环
            if (matrix[rowMid][0] == target) {
                return true;
            } else if (matrix[rowMid][0] > target) {
                rowRight = rowMid - 1;
            } else if (matrix[rowMid][0] < target) {
                rowLeft = rowMid;
            }
        }
        int columnLeft = 0, columnRight = n -1;
        while(columnLeft <= columnRight) {
            int colMid = columnLeft + (columnRight - columnLeft)/2;
            if (matrix[rowLeft][colMid] == target) {
                return true;
            } else if (matrix[rowLeft][colMid] < target) {
                columnLeft = colMid + 1;
            } else {
                columnRight = colMid - 1;
            }
        }
        return false;
    }

    public boolean searchMatrixV2(int[][] matrix, int target) {
        // 一次二分
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = matrix[mid / n][mid % n];
            if (val == target) {
                return true;
            } else
            if (val < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
