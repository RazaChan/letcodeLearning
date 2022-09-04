package it.pers.raza.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckInclusion {
    /**
     * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
     * <p>
     * 换句话说，s1 的排列之一是 s2 的 子串 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s1 = "ab" s2 = "eidbaooo"
     * 输出：true
     * 解释：s2 包含 s1 的排列之一 ("ba").
     * 示例 2：
     * <p>
     * 输入：s1= "ab" s2 = "eidboaoo"
     * 输出：false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/permutation-in-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
//        System.out.println(checkInclusion("abc", "bbbca"));
        System.out.println(checkInclusionNormal("abc", "bbbca"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        // 先截取同样的长度比较不同的字符有多少个
        int[] recode = new int[26];
        int base = 97;
        for (int i = 0; i <= n - 1; i++) {
            // 两个数组一个向数组内加元素，另外一个是被减的元素，每个位置都为0则表示同样长度内字符串完全相同
            --recode[s1.codePointAt(i) - base];
            ++recode[s2.codePointAt(i) - base];
        }
        int diif = 0;
        for (int i : recode) {
            if (i != 0) {
                diif++;
            }
        }
        if (diif == 0) {
            return true;
        }
        for (int i = 1, j = n; j <= s2.length() - 1; ) {
            int i1 = s2.codePointAt(i - 1);
            int j1 = s2.codePointAt(j);
            // 判断说明时候dff需要+1是个，问题，只有原来为0 的时候才需要+1，因为来为0那么不管++还是--都必然不为0
            if (recode[i1 - base] == 0) {
                diif++;
            }
            --recode[i1 - base];
            if (recode[i1 - base] == 0) {
                diif--;
            }
            if (recode[j1 - base] == 0) {
                diif++;
            }
            ++recode[j1 - base];
            if (recode[j1 - base] == 0) {
                diif--;
            }
            i++;
            j++;
            if (diif == 0) {
                return true;
            }
        }
        return false;
    }


    public static boolean checkInclusionNormal(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, count = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    count++;
                }
            }
            //只有在right - left == need.size()的情况下才有可能有符合条件的解
            // 此时窗口刚好和s1的长度相等,进行逻辑处理之后左边窗口往右滑动，内循环结束之后右边窗口也同等滑动
            while (right - left == s1.length()) {
                if (count == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        count--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return false;
    }

    // 子串排列表示字符一致但是顺序可以不同
    // 从子串入手，首先说明长度一致，截取的长度是一致的窗口长度固定
    // 最关键的是如何判断两个同样长度的字符串如何判断元素是否完全相等
    // 判断遍历判断字符串是否相等一般来说要么全部排序一遍再判断是否相等，或者判断一轮删掉一个元素
    // 此种方法不够巧妙，且在数组过长的情况下性能极差

    // 全是字母的情况下可以使用asiic码来比较，但是如果为中文字符的情况下如何判断还待讨论 TODO 用map处理试试
//    public static boolean checkInclusion(String s1, String s2) {
//        if (s1.length() > s2.length()) {
//            return false;
//        }
//        int n = s1.length();
//        for (int i = 0, j = n; j <= s2.length(); ) {
//            // 整个窗口往后滑，当且仅当窗口内的值在s1中都对应唯一值
//            if (isWordsEqual(s1, s2.substring(i, j))) {
//                return true;
//            } else {
//                i++;
//                j++;
//            }
//        }
//        return false;
//    }
//
//    public static boolean isWordsEqual(String s1, String s2) {
//        char[] chars = s1.toCharArray();
//        char[] chars1 = s2.toCharArray();
//        return Arrays.equals(chars1, chars);
//    }

}
