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

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        return getFromTwoStrs(strs,0,strs.length - 1);
    }

    private String getFromTwoStrs(String[] strs, int left, int right) {
        if (left == right) {
            return strs[right];
        }
        int middle = (right - left) / 2 + left;
        String leftStr = getFromTwoStrs(strs,left,middle);
        String rightStr = getFromTwoStrs(strs,middle,right);
        return getCommonStr(leftStr,rightStr);
    }

    private String getCommonStr(String leftStr, String rightStr) {
        int minLen = Math.min(leftStr.length(),rightStr.length());
        int res = 0;
        for (; res < minLen; res++) {
            if (leftStr.charAt(res) == rightStr.charAt(res)) {
                continue;
            }
        }
        return leftStr.substring(0,res);
    }
}
