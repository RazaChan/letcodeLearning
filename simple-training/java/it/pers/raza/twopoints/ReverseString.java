package it.pers.raza.twopoints;

public class ReverseString {
    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
     * <p>
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = ["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/reverse-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        String[] s = {"h", "e", "l", "l", "o"};
        String[] r = {"o", "l", "l", "e", "h"};
        reverseString(s);
        System.out.println(s);
        ;
    }

    public static void reverseString(String[] s) {
        int n = s.length - 1;
        for (int i = 0, j = n; i <= j; ) {
            if (s[i] == s[j]) {
                i++;
                j--;
            } else {
                String temp = s[j];
                s[j] = s[i];
                s[i] = temp;
            }
        }
    }
}
