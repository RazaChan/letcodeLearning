package it.pers.raza;

public class Rotate {
    /**
     * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右轮转 1 步: [7,1,2,3,4,5,6]
     * 向右轮转 2 步: [6,7,1,2,3,4,5]
     * 向右轮转 3 步: [5,6,7,1,2,3,4]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/rotate-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        int i = 4 % 3;
        System.out.println(i);
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate1(nums, 3);
        System.out.println("===");
    }

    // 使用额外数组
    public static void rotate1(int[] nums, int k) {
        int length = nums.length;
        if (k >= length) {
            k = k % length;
        }
        int index = k;
        int[] result = new int[length];
        // 这个值需要交换到第一个位置
        int start = 0;
        while (k > 0) {
            int endStart = length - k;
            result[start] = nums[endStart];
            start++;
            k--;
        }
        for (int i = 0; i < length - index; i++) {
            result[start] = nums[i];
            start++;
        }
        System.out.println(result);
    }

    /**
     * 原地算法 不适应额外数组
     *
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        if (k >= length) {
            k = k % length;
        }
        // 这个值需要交换到第一个位置
        int start = 0;
        while (k > 0) {
            int endStart = length - k;
            int temp = nums[endStart];
            // 把数组全都往后移动一位
            int swap = nums[start];
            int swapTwo;
            for (int i = start; i <= endStart; i++) {
                swapTwo = nums[i];
                nums[i] = swap;
                swap = swapTwo;
            }
            nums[start] = temp;
            start++;
            k--;
        }
    }
}
