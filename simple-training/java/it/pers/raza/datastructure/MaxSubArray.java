package it.pers.raza.datastructure;

public class MaxSubArray {

    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 子数组 是数组中的一个连续部分。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/maximum-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 最大连续子数的和，那么连续子数的数量不确定，最大可以是数组长度，最小包含一个元素，那么可以分为固定长度的子数最大和是多少，然后去增加子数
     *
     * @param args
     * @return
     */
    public static void main(String[] args) {
        int[] nums = {-2, 1};
        int i = maxSubArray(nums);
        System.out.println(i);
    }

    /**
     * 从第一个数开始相加，如果前面的数加上当前的数比当前数小，则前面的数是负反馈，可以舍弃不要，从当前数重新开始计算
     * @param nums
     * @return
     */
//    public int maxSubArray(int[] nums) {
//
//        int pre = 0, maxAns = nums[0];
//        for (int x : nums) {
//            pre = Math.max(pre + x, x);
//            maxAns = Math.max(maxAns, pre);
//        }
//        return maxAns;
//    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        int temp = 0;
        int length = nums.length - 1, total = length;
        for (int i = 0; length >= 0; ) {
            temp = calArray(nums, i, i + length);
            max = Math.max(max, temp);
            // 当长度+i等于数组长度的时候需要重新开始
            if (i + length == total) {
                length--;
                i = 0;
            } else {
                i++;
            }
        }
        return max;
    }

    public static int calArray(int[] nums, int head, int end) {
        int amount = 0;
        for (int i = head; i <= end; i++) {
            amount = amount + nums[i];
        }
        return amount;
    }
}
