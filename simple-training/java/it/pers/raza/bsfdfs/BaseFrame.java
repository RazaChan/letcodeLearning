package it.pers.raza.bsfdfs;

import it.pers.raza.common.BinTreeNode;

public class BaseFrame {

    // 二叉树遍历框架
    void traverse(BinTreeNode root) {
        traverse(root.lchild);
        traverse(root.rchild);
    }

    // 二维矩阵遍历框架
    // 因为二维矩阵本质上是一幅「图」，所以遍历的过程中需要一个 visited 布尔数组防止走回头路，如果你能理解上面这段代码，那么搞定所有岛屿系列题目都很简单。
    void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            // 超出索引边界
            return;
        }
        if (visited[i][j]) {
            // 已遍历过 (i, j)
            return;
        }
        // 进入节点 (i, j)
        visited[i][j] = true;
        dfs(grid, i - 1, j, visited); // 上
        dfs(grid, i + 1, j, visited); // 下
        dfs(grid, i, j - 1, visited); // 左
        dfs(grid, i, j + 1, visited); // 右
    }
}
