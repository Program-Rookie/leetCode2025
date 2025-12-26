package com.atvris.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author zjh
 * @date 2025/12/23 10:52
 */
public class LetterCombinations_17 {

     Map<Integer, String> characterMap = new HashMap<>();
     {
        characterMap.put(2, "abc");
        characterMap.put(3, "def");
        characterMap.put(4, "ghi");
        characterMap.put(5, "jkl");
        characterMap.put(6, "mno");
        characterMap.put(7, "pqrs");
        characterMap.put(8, "tuv");
        characterMap.put(9, "wxyz");

    }

    /**
     * 掌握回溯法+哈希表后，这个题目就是秒杀
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        List<String> result = new ArrayList<>();
        List<Character> output = new ArrayList<>();
        backtrack(0, digits, n, output, result);
        return result;
    }

    private void backtrack(int first, String digits, int n, List<Character> output , List<String> result ) {
        if (first == n) {
            result.add(joinCharacter(output));
            return;
        }
        String matchChars = characterMap.get(digits.charAt(first) - '0');
        for (int i = 0; i < matchChars.length(); i ++) {
            output.add(matchChars.charAt(i));
            backtrack(first + 1, digits, n , output, result);
            output.remove(output.size() - 1);
        }
    }

    private String joinCharacter(List<Character> output) {
        String s = "";
        for (int i = 0; i < output.size(); i++) {
            s += output.get(i);
        }
        return s;
    }
}
