package it.pers.raza.bsfdfs;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
//        int i = maxAreaOfIsland(grid);
//        System.out.println(i);
        System.out.println(maxAreaOfIslandByBfs(grid));
    }

    // 广度优先
    public static int maxAreaOfIslandByBfs(int[][] grid) {
        int result = 0;
        for (int i = 0; i <= grid.length - 1; i++) {
            for (int j = 0; j <= grid[0].length - 1; j++) {
                Queue<Integer> queuei = new LinkedList<Integer>();
                Queue<Integer> queuej = new LinkedList<Integer>();
                queuei.offer(i);
                queuej.offer(j);
                int cur = 0;
                while (!queuei.isEmpty()) {
                    int pollj = queuej.poll();
                    int polli = queuei.poll();
                    int[][] derecation = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
                    if (pollj < 0 || polli < 0 || polli >= grid.length || pollj >= grid[0].length || grid[polli][pollj] != 1) {
                        continue;
                    }
                    cur++;
                    grid[polli][pollj] = 0;
                    for (int k = 0; k < 4; k++) {
                        queuei.offer(polli + derecation[k][0]);
                        queuej.offer(pollj + derecation[k][1]);
                    }
                }
                result = Math.max(cur, result);
            }
        }
        return result;
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for (int i = 0; i <= grid.length - 1; i++) {
            for (int j = 0; j <= grid[0].length - 1; j++) {
                result = Math.max(result, dfs(grid, i, j));
            }
        }
        return result;
    }

    public static int dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 超出索引边界
            return 0;
        }
        // 进入节点 (i, j)
        // 如果节点不为0 则继续遍历且岛屿数目+1
        if (grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int up = dfs(grid, i - 1, j);
        int down = dfs(grid, i + 1, j);
        int left = dfs(grid, i, j - 1);
        int right = dfs(grid, i, j + 1);
        return up + down + left + right + 1;
    }


    static int maxArea = 0;
// 辣不辣东思路，找到当前到岛屿同时将响铃到岛屿用海水淹没
//    public static int dfs(int[][] grid, int i, int j, int curCount) {
//        int m = grid.length, n = grid[0].length;
//        if (i < 0 || j < 0 || i >= m || j >= n) {
//            // 超出索引边界
//            return 0;
//        }
//        // 进入节点 (i, j)
//        // 如果节点不为0 则继续遍历且岛屿数目+1
//        if (grid[i][j] == 1) {
//            return curCount++;
//        }
//        int up = dfs(grid, i - 1, j, curCount);
//        int down = dfs(grid, i + 1, j, curCount);
//        int left = dfs(grid, i, j - 1, curCount);
//        int right = dfs(grid, i, j + 1, curCount);
//        maxArea = Math.max(maxArea, up + down + left + right);
//        return maxArea;
//    }
}
