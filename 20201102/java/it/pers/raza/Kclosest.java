package it.pers.raza;

import java.util.*;
import java.util.stream.Collectors;

public class Kclosest {

//    我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
//
//            （这里，平面上两点之间的距离是欧几里德距离。）
//
//    你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
//
//             
//
//    示例 1：
//
//    输入：points = [[1,3],[-2,2]], K = 1
//    输出：[[-2,2]]
//    解释：
//            (1, 3) 和原点之间的距离为 sqrt(10)，
//            (-2, 2) 和原点之间的距离为 sqrt(8)，
//    由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
//    我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
//    示例 2：
//
//    输入：points = [[3,3],[5,-1],[-2,4]], K = 2
//    输出：[[3,3],[-2,4]]
//            （答案 [[-2,4],[3,3]] 也会被接受。）
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static void main(String[] args) {
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
//        kClosest(points, 2);
    }

    public static int[][] kClosest1(int[][] points, int K) {
        Map<Double, List<int[]>> levelmap = new HashMap<>();
        List<int[]> temp;
        double sqrt;
        for (int[] point : points) {
            sqrt = Math.pow(point[0], 2) + Math.pow(point[1], 2);
            if (levelmap.containsKey(sqrt)) {
                levelmap.get(sqrt).add(point);
            } else {
                temp = new ArrayList<>();
                temp.add(point);
                levelmap.put(sqrt, temp);
            }
        }
        List<Map.Entry<Double, List<int[]>>> collect = levelmap.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());
        if (points.length < K) {
            K = points.length;
        }
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < collect.size(); i++) {
            result.addAll(collect.get(i).getValue());
        }
        int[][] p = new int[K][];
        for (int i=0;i<K;i++){
            p[i] = result.get(i);
        }
        return p;
    }

    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                return (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]);
            }
        });
        return Arrays.copyOfRange(points, 0, K);
    }

    public int[][] kClosest2(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] array1, int[] array2) {
                return array2[0] - array1[0];
            }
        });
        for (int i = 0; i < K; ++i) {
            pq.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
        }
        int n = points.length;
        for (int i = K; i < n; ++i) {
            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (dist < pq.peek()[0]) {
                pq.poll();
                pq.offer(new int[]{dist, i});
            }
        }
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; ++i) {
            ans[i] = points[pq.poll()[1]];
        }
        return ans;
    }
}
