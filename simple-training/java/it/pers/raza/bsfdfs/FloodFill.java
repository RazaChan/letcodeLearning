package it.pers.raza.bsfdfs;

public class FloodFill {
    /**
     * 输入: image = [[1,1,1],[1,1,0],[1,0,1]]，sr = 1, sc = 1, newColor = 2
     * 输出: [[2,2,2],[2,2,0],[2,0,1]]
     * 解析: 在图像的正中间，(坐标(sr,sc)=(1,1)),在路径上所有符合条件的像素点的颜色都被更改成2。
     * 注意，右下角的像素没有更改为2，因为它不是在上下左右四个方向上与初始点相连的像素点。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/flood-fill
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
//        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] image = { {0, 0, 0}, {0, 0, 0}};
        floodFill(image, 0, 0, 2);
        System.out.println("==");
    }

    // 定义此数组用于取上下左右四个方向的值
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};
    // 广度优先
    public static void bfsFirst(int[][] image, int sr, int sc, int color){

    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // 用于记录节点是否被访问过
        boolean[][] visited = new boolean[image.length][image[0].length];
        int oldColor = image[sr][sc];
        dfs(image, sr, sc, visited, oldColor, color);
        return image;
    }

    public static void dfs(int[][] grid, int i, int j, boolean[][] visited, int oldColor, int color) {
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
        if (grid[i][j] == oldColor) {
            grid[i][j] = color;
        } else {
            return;
        }
        dfs(grid, i - 1, j, visited, oldColor, color); // 上
        dfs(grid, i + 1, j, visited, oldColor, color); // 下
        dfs(grid, i, j - 1, visited, oldColor, color); // 左
        dfs(grid, i, j + 1, visited, oldColor, color); // 右
    }
}
