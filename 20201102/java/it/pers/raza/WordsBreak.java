package it.pers.raza;

import java.util.*;
import java.util.stream.Collectors;

public class WordsBreak {


//    给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
//    说明：
//    分隔时可以重复使用字典中的单词。
//    你可以假设字典中没有重复的单词。
//    示例 1：
//    输入:
//    s = "catsanddog"
//    wordDict = ["cat", "cats", "and", "sand", "dog"]
//    输出:
//            [
//              "cats and dog",
//              "cat sand dog"
//            ]
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/word-break-ii
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static void main(String[] args) {
        List<String> strings = wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
        System.out.println(strings);
//        List<String> strings2 = wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));
//        System.out.println(strings2);
//        List<String> strings1 = wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
//        System.out.println(strings1);
    }

//
//    public static List<String> wordBreak(String letters, List<String> wordDict) {
//        // 输出字符串数组，则每个字符串是拼接完再加入数组
//        // 字符串必须是顺序根据空格分割的
//        Set<String> wordDictSet = Arrays.stream(String.join("", wordDict).split("")).collect(Collectors.toSet());
//        Set<String> lettersSet = Arrays.stream(letters.split("")).collect(Collectors.toSet());
//        lettersSet.removeAll(wordDictSet);
//        if (lettersSet.size() > 0) {
//            return new ArrayList<>();
//        }
//        List<String> result = new ArrayList<>();
//        for (String word : wordDict) {
//            if (letters.startsWith(word)) {
//                result.add(word);
//            }
//        }
//        return getSentences(result, letters, wordDict);
//    }
//
//    public static List<String> getSentences(List<String> sentences, String letters, List<String> wordDict) {
//        boolean continueSpilt = false;
//        String tempLetters;
//        int index = 0;
//        for (int i = 0; i < sentences.size(); i++) {
//            index = 0;
//            String sentence = sentences.get(i);
//            tempLetters = letters.substring(sentence.replaceAll(" ", "").length());
//            if (tempLetters.length() == 0) {
//                continue;
//            }
//            for (String word : wordDict) {
//                if (tempLetters.startsWith(word)) {
//                    if (index == 0) {
//                        sentences.set(i, sentence + " " + word);
//                        continueSpilt = true;
//                        index++;
//                    } else {
//                        sentences.add(sentence + " " + word);
//                        continueSpilt = true;
//                    }
//                }
//            }
//            if (index == 0) {
//                sentences.remove(i);
//                i--;
//            }
//        }
//        if (!continueSpilt) {
//            return sentences;
//        }
//        return getSentences(sentences, letters, wordDict);
//    }
//[
//        "pine apple pen apple",
//        "pineapple pen apple",
//        "pine applepen apple"
//        ]


    public static List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> map = new HashMap<>();
        List<List<String>> wordBreaks = backtrack(s, s.length(), new HashSet<>(wordDict), 0, map);
        List<String> breakList = new LinkedList<>();
        for (List<String> wordBreak : wordBreaks) {
            breakList.add(String.join(" ", wordBreak));
        }
        return breakList;
    }

    public static List<List<String>> backtrack(String s, int length, Set<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
        if (!map.containsKey(index)) {
            List<List<String>> wordBreaks = new LinkedList<>();
            if (index == length) {
                wordBreaks.add(new LinkedList<>());
            }
            for (int i = index + 1; i <= length; i++) {
                String word = s.substring(index, i);
                if (wordSet.contains(word)) {
                    List<List<String>> nextWordBreaks = backtrack(s, length, wordSet, i, map);
                    for (List<String> nextWordBreak : nextWordBreaks) {
                        LinkedList<String> wordBreak = new LinkedList<String>(nextWordBreak);
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    }
                }
            }
            map.put(index, wordBreaks);
        }
        return map.get(index);
    }


}
