package it.pers.raza.deep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permute {
    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * nums=[1,2,3,4]
     * 1,2
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/permutations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * <p>
     * 遍历框架
     * void traverse(TreeNode root) {
     * for (TreeNode child : root.childern) {
     * // 前序位置需要的操作
     * traverse(child);
     * // 后序位置需要的操作
     * }
     * }
     * <p>
     * for 选择 in 选择列表:
     * # 做选择
     * 将该选择从选择列表移除
     * 路径.add(选择)
     * backtrack(路径, 选择列表)
     * # 撤销选择
     * 路径.remove(选择)
     * 将该选择再加入选择列表
     */

    List<List<Integer>> res = new LinkedList<>();

    /**
     * 使用回溯算法相当与暴力穷举法，试错然后回归，
     * 转化成多叉树，进入节点前选择路径，出节点后撤销路径走下一个分支
     * @param nums
     * @return
     */
    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        // 「路径」中的元素会被标记为 true，避免重复使用
        boolean[] used = new boolean[nums.length];

        backtrack(nums, track, used);
        return res;
    }

    // 路径：记录在 track 中
// 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
// 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (used[i]) {
                // nums[i] 已经在 track 中，跳过
                continue;
            }
            // 做选择
            track.add(nums[i]);
            used[i] = true;
            // 进入下一层决策树
            backtrack(nums, track, used);
            // 取消选择
            track.removeLast();
            used[i] = false;
        }
    }
}
