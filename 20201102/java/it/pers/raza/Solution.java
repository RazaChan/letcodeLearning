package it.pers.raza;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    Map<String, Set<String>> map;
    int finalCount;

    /**
     * index -> dist
     * map -> char -> index
     *
     * 重复的字符，最短路径通过map维护： a->b, b的下标
     * 最短路径矩阵，维护每个节点到其他节点的最短路径
     *
     * 总步数由旋转步数+按下拼写组成
     * 另外，ring和key的第一个字符匹配，只需按下拼写一步（或许这一步是算在dict矩阵里的）
     * 拼写的步骤等于key的长度
     * @param ring
     * @return
     */
    public int findRotateSteps(String ring, String key) {
        String[] ringChar = ring.split("");
        // 字符下标
        map = new HashMap<>();
        for (int i = 0; i < ringChar.length - 1; i++) {
            for (int j = i; j < ringChar.length; j++) {
                Set<String> indexList = map.getOrDefault(ringChar[i] + ringChar[j], new HashSet<>());
                indexList.add(i + "," + j);
                map.put(ringChar[i] + ringChar[j], indexList);
                map.put(ringChar[j] + ringChar[i], indexList);
            }
        }
        countStep(ring, key, 0, 0, 0);
        System.out.println(" =======> end: finalCount");
        return finalCount;
    }

    private void countStep(String ring, String key, int keyIdx, int ringIdx, int count) {
        String[] ringChar = ring.split("");
        String[] keyChar = (ringChar[0] + key).split("");
        if(keyIdx >= keyChar.length - 1) {
            finalCount = (finalCount == 0 || finalCount > (count + key.length())) ? (count + key.length()) : finalCount;
            return;
        }
        String distKey = keyChar[keyIdx] + keyChar[keyIdx + 1];
        Set<String> targetCharIdxList = map.get(distKey);
        for (String idxGroup : targetCharIdxList) {
            String[] idxs = idxGroup.split(",");
            if (ringIdx == Integer.parseInt(idxs[0]) || ringIdx == Integer.parseInt(idxs[1])) {
                int newCount = count + Math.min(Integer.parseInt(idxs[1])-Integer.parseInt(idxs[0]), ringChar.length - (Integer.parseInt(idxs[1]) - Integer.parseInt(idxs[0])));
                int newRingIdx = Integer.parseInt(idxs[1]);
                int newKeyIdx = keyIdx + 1;
                countStep(ring, key, newKeyIdx, newRingIdx, newCount);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findRotateSteps("godding", "gd"));
        System.out.println(new Solution().findRotateSteps("avcbegfvhsfb", "abe"));
        System.out.println(new Solution().findRotateSteps("edcba", "abcde"));
    }
}