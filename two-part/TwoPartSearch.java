public class TwoPartSearch {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6, 7, 8};
//        int search = search(nums, 2);
        int i = searchInsert(nums, 0);
        System.out.println(i);
    }

    public static int search(int[] nums, int target) {
        if (nums.length <= 0) {
            return -1;
        }
        return search(nums, target, 0, nums.length - 1);

    }

    public static int search(int[] nums, int target, int start, int end) {
        int middle = (start + end) / 2;
        if (nums[middle] == target) {
            return middle;
        }
        if (start == end) {
            return -1;
        }
        if (start + 1 == end) {
            middle++;
            start++;
        }
        if (nums[middle] < target) {
            return search(nums, target, middle, end);
        } else {
            return search(nums, target, start, middle);
        }
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 请必须使用时间复杂度为 O(log n) 的算法。
     * <p>
     *  
     * <p>
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/search-insert-position
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * nums = [1,3,5,6], target = 7
     * 输出: 4
     */

    public static int searchInsert(int[] nums, int target) {
        int endIndex = nums.length;
        int startIndex = 0;
        int middle;
        while (true) {
            middle = (endIndex - startIndex) / 2 + startIndex;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                startIndex = middle;
            } else {
                endIndex = middle;
            }
            if (startIndex + 1 == endIndex && startIndex == middle) {
                return startIndex + 1;
            }
            if (startIndex == middle && startIndex == endIndex) {
                return startIndex;
            }
        }
    }
}
