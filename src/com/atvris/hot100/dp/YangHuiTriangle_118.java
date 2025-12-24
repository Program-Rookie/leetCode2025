package com.atvris.hot100.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 * https://leetcode.cn/problems/pascals-triangle/description/?envType=study-plan-v2&envId=top-100-liked
 * @author zjh
 * @date 2025/12/24 18:55
 */
public class YangHuiTriangle_118 {

    /**
     * 秒了
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        int i = 1;
        List<Integer> preLine = new ArrayList<>();
        while(i <= numRows) {
            List<Integer> line = new ArrayList<>();
            for (int k = 0; k < i;k++) {
                if (k == 0 || k == i - 1) {
                    line.add(1);
                } else {
                    line.add(preLine.get(k - 1) + preLine.get(k));
                }
            }
            result.add(line);
            preLine = line;
            i++;
        }
        return result;
    }
}
