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

    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = res;
            res = head;
            head = temp;
        }
        return res;
    }
}
