package com.wpy.mall.admin;

import java.util.HashMap;
import java.util.Map;

/**
 * @author W
 * @date 2022-02-25
 */
public class Main {
    public static void main(String[] args) {
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
