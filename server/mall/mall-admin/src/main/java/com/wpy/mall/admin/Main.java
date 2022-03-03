package com.wpy.mall.admin;

import net.sf.jsqlparser.statement.merge.Merge;

import java.util.*;

/**
 * @author W
 * @date 2022-02-25
 */
public class Main {
    public static void main(String[] args) {
        int[] t1 = new int[]{1,2,3,0,0,0};
        int[] t2 = new int[]{2,5,6};
        merge(t1,3,t2,3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - n];
        }
        int start = 0, end = 0;
        while ( start < m + n) {
            if (nums1[start] <= nums1[end]) {
                end++;
                if (end == m + n) {
                    start++;
                    end = start + 1;
                }
            } else {
                int t = nums1[end];
                nums1[end] = nums1[start];
                nums1[start] = t;
                start ++;
                end = start + 1;
            }
        }
    }


}
