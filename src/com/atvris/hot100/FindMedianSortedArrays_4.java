package com.atvris.hot100;

/**
 * 寻找两个正序数组的中位数
 * @author zjh
 * @date 2025/12/23 20:52
 */
public class FindMedianSortedArrays_4 {

    /**
     * 偏笨办法，遍历到中位数所在位置计算
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 区分总长度是奇数还是偶数
        // 奇数是(m + n) / 2 + 1,偶数是 (m + n) / 2, (m + n)/2 + 1
        int m = nums1.length, n = nums2.length;
        // 第一种是On时间复杂度的解法，遍历到中间即可
        int k = (m + n)/2;
        int i = 0, j = 0, idx = 0;
        int pre = -1, cur = -1;
        while (idx <= k) {
            pre = cur;
            // 注意避免越界问题
            if (i < m && (j > n - 1 || nums1[i] <= nums2[j])) {
                cur = nums1[i];
                i++;
            } else {
                cur = nums2[j];
                j++;
            }
            idx++;
        }
        if ( (m + n) % 2 == 1) {
            return cur;
        }
        return (pre + cur)/ 2.0; // 留意这里如果除2会计算成整数
    }
    
    // TODO 二分法
}
