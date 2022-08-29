public class ReverseWords {
    /**
     * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     * 示例 2:
     * <p>
     * 输入： s = "God Ding"
     * 输出："doG gniD"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/reverse-words-in-a-string-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String vs = "s'teL ekat edoCteeL tsetnoc";
        String s1 = reverseWords(s);
        System.out.println(vs.equals(s1));
    }

    public static String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= s1.length - 1; i++) {
            reverseWord(s1[i], sb);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static void reverseWord(String s, StringBuffer sb) {
        int n = s.length();
        for (int i = n; i >= 1; i--) {
            sb.append(s.substring(i - 1, i));
        }
    }
}
