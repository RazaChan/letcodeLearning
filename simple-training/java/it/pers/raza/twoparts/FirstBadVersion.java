package it.pers.raza.twoparts;

public class FirstBadVersion {
    //    你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
//
//    假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
//
//    你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
//
//             
//    示例 1：
//
//    输入：n = 5, bad = 4
//    输出：4
//    解释：
//    调用 isBadVersion(3) -> false
//    调用 isBadVersion(5) -> true
//    调用 isBadVersion(4) -> true
//    所以，4 是第一个错误的版本。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode.cn/problems/first-bad-version
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5};


        int i = firstBadVersion(0, 2126753390);
        System.out.println(i);
    }

    // 临界点是当前是错误版本但是前面的一个版本是正确版本
    // 考虑超长的情况，
//    public static int firstBadVersion(int curIndex, int all) {
//        boolean isBadVersion = isBadVersion(curIndex);
//        if (isBadVersion) {
//            if (curIndex <= 1) {
//                return curIndex;
//            } else if (!isBadVersion(curIndex - 1)) {
//                return curIndex;
//            }
//            return firstBadVersion(curIndex / 2, all);
//        } else {
//            if (isBadVersion(curIndex + 1)) {
//                return curIndex + 1;
//            }
//            if (curIndex <= 1) {
//                return curIndex;
//            }
//            return firstBadVersion((all - curIndex) / 2 + curIndex, all);
//        }
//    }  5和9


    // 前文思路错误，还是需要两个指针，不断向中间移动
    // 取中间值需要防止超长所以不能简单（startIndex+endIndex）/2=》（endIndex-startIndex）/2+startIndex
    public static int firstBadVersion(int startIndex, int endIndex) {
        if (endIndex - startIndex == 1) {
            return endIndex;
        }
        int middle = (endIndex - startIndex) / 2 + startIndex;
        boolean isBadVersion = isBadVersion(middle);
        if (isBadVersion) {
            return firstBadVersion(startIndex, middle);
        } else {
            return firstBadVersion(middle, endIndex);
        }
    }

    public static boolean isBadVersion(int version) {
        return version >= 1702766719;
    }
}
