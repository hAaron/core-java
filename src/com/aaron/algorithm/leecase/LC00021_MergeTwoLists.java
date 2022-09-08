package com.aaron.algorithm.leecase;

/**
 * lc21. 合并两个有序链表
 * 
 * @author huangbo
 * @date 2021/11/2
 */
public class LC00021_MergeTwoLists {

    public static void main(String[] args) {}

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}
