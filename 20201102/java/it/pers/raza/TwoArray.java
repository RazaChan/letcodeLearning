package it.pers.raza;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoArray {
//    给定两个数组，编写一个函数来计算它们的交集
//    示例 1：
//
//    输入：nums1 = [1,2,2,1], nums2 = [2,2]
//    输出：[2]
//    示例 2：
//
//    输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//    输出：[9,4]
//             
//
//    说明：
//
//    输出结果中的每个元素一定是唯一的。
//    我们可以不考虑输出结果的顺序。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num1:nums1){
            set1.add(num1);
        }
        for (int num2:nums2){
            if (set1.contains(num2)){
                set2.add(num2);
            }
        }
        int[] reslut =new int[set2.size()];
        int i = 0;
        for (int num:set2){
            reslut[i] = num;
            i++;
        }
       return reslut;
    }

    public int[] intersection1(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num1:nums1){
            set1.add(num1);
        }
        for (int num2:nums2){
            if (set1.contains(num2)){
                set2.add(num2);
            }
        }
        int[] reslut =new int[set2.size()];
        int i = 0;
        for (int num:set2){
            reslut[i] = num;
            i++;
        }
        return reslut;
    }
}
