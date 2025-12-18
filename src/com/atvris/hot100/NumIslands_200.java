package com.atvris.hot100;

/**
 * 岛屿数量
 * @author zjh
 * @date 2025/12/18 14:40
 */
public class NumIslands_200 {

    /**
     * CASE
     * 1 1 1
     * 0 1 0
     * 1 1 1
     */
    /**
     * 第一种自己的笨办法，深度优先遍历
     */
    public static int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for(int j = 0; j < n;j++) {
            for (int i = 0; i < m; i++) {
                boolean mat = dfs(i, j , grid, visited);
                if (mat) {
                    res++;
                }
            }
        }
        return res;
    }

    private static boolean dfs(int i, int j, char[][] grid, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (grid[i][j] == '1') {
            dfs(i + 1, j, grid, visited);
            dfs(i, j + 1, grid, visited);
            dfs(i - 1, j, grid, visited);
            dfs(i, j - 1, grid, visited);
            return true;
        }
        return false;
    }
    
    static class UnionS {
        int[] parent; // 记录父节点
        
        public UnionS(char[][] grid) {
            int m = grid.length, n = grid[0].length;
            parent = new int[m * n]; // 记录父节点
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j; // 初始化
                    } else {
                        parent[i * n + j] = -1; // 避免parent[0][0] = 0混淆
                    }
                }
            }
        }
        
        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }
        
        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                // 以一种规则认定并查集的头：谁是先遍历的谁是头
                if (px < py) {
                    parent[py] = px;
                } else {
                    parent[px] = py;
                }
            }
        }
    }
    
    // 并查集，官解改了原数组，自己想一种解法
    public static int numIslandsV2(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        UnionS unionS = new UnionS(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    union(i, j, grid, unionS);
                }
            }
        }
        int allCount = 0;
        for (int i = 0; i < m * n; i++) {
            if (unionS.parent[i] == i) {
                allCount += 1;
            }
        }
        return allCount;
    }
    
    private static void union(int i, int j, char[][] grid, UnionS unionS) {
        int m = grid.length;
        int n = grid[0].length;
        // 只需要向右或向下遍历
        if (i < m - 1 && grid[i + 1][j] == '1') {
            unionS.union(i * n + j, (i + 1) * n + j);
        }
        if (j < n - 1 && grid[i][j + 1] == '1') {
            unionS.union(i * n + j, i * n + (j + 1));
        }
    }
    
    public static void main(String[] args) {
        
    }
}
