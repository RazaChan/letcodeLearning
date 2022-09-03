package it.pers.raza;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class FreedomRing {
//    电子游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。
//
//    给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
//
//    最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
//
//    旋转 ring 拼出 key 字符 key[i] 的阶段中：
//
//    您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
//    如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
//    示例：
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/freedom-trail
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//    输入: ring = "godding", key = "gd"
//    输出: 4
//    解释:
//    对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。
//    对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
//    当然, 我们还需要1步进行拼写。
//    因此最终的输出是 4。

    public static void main(String[] args) {
        String ring = "godding";
        String key = "gd";
        int rotateSteps = findRotateSteps(ring, key);
        System.out.println(rotateSteps);
    }

    public static int findRotateSteps(String ring, String key) {
        if (ring == null || key == null) return 0;
        int m = ring.length();
        int n = key.length();
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (key.charAt(i) == ring.charAt(j)) {
                    if (i == 0) {
                        result[i][j] = Math.min(j, m - j);//first char
                    } else {
                        for (int k = 0; k < m; k++) {
                            //it can ring clockwise or anticlockwise from k to j
                            if (result[i - 1][k] != Integer.MAX_VALUE)
                                result[i][j] = Math.min(result[i][j], result[i - 1][k] + Math.min(Math.abs(j - k), m - Math.abs(j - k)));
                        }
                    }
                }
            }
        }
        int ans = result[n - 1][0];
        for (int j = 1; j < m; j++) {
            if (ans > result[n - 1][j])
                ans = result[n - 1][j];
        }
        return ans + n;
    }

    List<Integer>[] pos = new List[26];
    int[][] dp;

    public int findRotateSteps1(String ring, String key) {
        int n = ring.length(), m = key.length();
        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            pos[ring.charAt(i) - 'a'].add(i);
        }
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(n, 0, key, 0);
    }

    public int dfs(int n, int now, String key, int index) {
        if (index == key.length()) {
            return 0;
        }
        if (dp[now][index] > 0) {
            return dp[now][index];
        }
        List<Integer> list = pos[key.charAt(index) - 'a'];
        int min = 0xfffff;
        for (Integer one : list) {
            int dis = 1 + Math.min(Math.abs(now - one), n - Math.abs(now - one)) + dfs(n, one, key, index + 1);
            if (dis < min) {
                min = dis;
            }
        }
        dp[now][index] = min;
        return min;
    }
}
