package it.pers.raza;

public class TwoSum {
    /**
     * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
     * <p>
     * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
     * <p>
     * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
     * <p>
     * 你所设计的解决方案必须只使用常量级的额外空间。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 输入：numbers = [2,7,11,15], target = 9
     * 输出：[1,2]
     * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        int[] num = {5, 25, 75};
        int[] ints = twoSum(num, 100);
        System.out.println(ints);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length - 1;
        int[] result = new int[2];
        for (int i = 0, j = 1; i <= n - 1; ) {
            if ((numbers[i] + numbers[j]) == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            }
            if (j == n) {
                ++i;
                j = i + 1;
            } else {
                j++;
            }
        }
        return result;
    }
}
