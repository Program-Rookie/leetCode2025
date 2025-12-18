package com.atvris.hot100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 腐烂的橘子
 * @author zjh
 * @date 2025/12/18 15:43
 */
public class OrangesRotting_994 {

    /*
        2 1 1       2 2 1       2 2 2   2 2 2
        0 1 1       0 1 1       0 2 1   0 2 2
        1 0 1       1 0 1       1 0 1   1 0 1
     */
    // DFS，把腐烂的橘子放在队列里，每轮把腐烂的橘子依次取出来，腐化附件的橘子后把这一轮新腐烂的橘子再放回去
    // 直到队列为空，或者新鲜橘子都已腐烂（注意因为有空格子存在，新鲜橘子不一定被腐化）
    public static int orangesRotting(int[][] grid) {
        int newOrangeCount = 0;
        int m = grid.length, n = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(i * n + j);
                } else if (grid[i][j] == 1) {
                    newOrangeCount++;
                }
            }
        }
        int count = 0;
        // 队列不为空，且还有新鲜橘子时
        while(!queue.isEmpty() && newOrangeCount != 0) {
            int size = queue.size();
            count++;
            for (int k = 0; k < size; k++) {
                // 取出腐烂的橘子
                Integer poll = queue.poll();
                // 计算下标
                int i = poll / n, j = poll % n;
                // 污染四周的新鲜橘子，并把他们放进去
                if (i > 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    queue.offer((i - 1) * n + j);
                    newOrangeCount--;
                }
                if (j > 0 && grid[j][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    queue.offer(i * n + j - 1);
                    newOrangeCount--;
                }
                if (i < m -1 && grid[i + 1][j] == 1) {
                    grid[i][j] = 2;
                    queue.offer((i + 1) * n + j);
                    newOrangeCount--;
                }
                if (j < n -1 && grid[i][j + 1] == 1) {
                    grid[i][j] = 2;
                    queue.offer(i * n + j + 1);
                    newOrangeCount--;
                }
            }
        }
        return newOrangeCount > 0 ? -1 : count;
    }
}
