package it.pers.raza;

import java.sql.ResultSet;

public class SortedSquares {
    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]
     * 排序后，数组变为 [0,1,9,16,100]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/squares-of-a-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] ints = sortedSquares(nums);
        System.out.println(ints);
    }

    // 交换 如果开始的位置和最后一个位置的平方比较，大于等于最后一个，则最后第二个和第一个交换
    // 开始因为一直想用一个数组来解决问题，比较复杂
    //两位一起填有些问题，应该是算最大值，每次只填最后一位，然后已经填到库里面的就从那一边减一
    // for循环能定义两个变量，修改成for循环更加高效
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0, j = n - 1, index = n - 1; i <= j; ) {
            int startSquare = (int) Math.pow(nums[i], 2);
            int endSquare = (int) Math.pow(nums[j], 2);
            if (startSquare >= endSquare) {
                result[index] = startSquare;
                i++;

            } else {
                result[index] = endSquare;
                j--;
            }
            index--;
        }
        return result;
//        int start = 0;
//        int end = nums.length - 1;
//        int[] resut = new int[nums.length];
//        int index = nums.length - 1;
//        while (index >= 0) {
//            int startSquare = (int) Math.pow(nums[start], 2);
//            int endSquare = (int) Math.pow(nums[end], 2);
//            if (startSquare >= endSquare) {
//                resut[index] = startSquare;
//                start++;
//
//            } else {
//                resut[index] = endSquare;
//                end--;
//            }
//            index--;
//        }
//        return resut;
//        while (end >= 2) {
//            int startSquare = (int) Math.pow(nums[start], 2);
//            int endSquare = (int) Math.pow(nums[end], 2);
//            if (startSquare >= endSquare) {
//                if (resut[end] >= startSquare) {
//                    resut[end - 1] = startSquare;
//                    resut[end - 2] = endSquare;
//                } else {
//                    int temp = resut[end];
//                    resut[end] = startSquare;
//                    resut[end - 1] = temp;
//                    resut[end - 2] = endSquare;
//                }
//            } else {
//                // startSquare < endSquare
//                if (resut[end] >= endSquare) {
//                    resut[end - 1] = endSquare;
//                    resut[end - 2] = startSquare;
//                } else {
//                    // startSquare < resut[end] <endSquare
//                    int temp = resut[end];
//                    resut[end] = endSquare;
//                    resut[end - 1] = temp;
//                    resut[end - 2] = startSquare;
//                }
//            }
//            end--;
//            start++;
//        }
//        return resut;
    }
}
