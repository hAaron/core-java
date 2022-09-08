package com.aaron.algorithm.leecase;

/**
 * lc24. 两两交换链表中的节点
 * 
 * @author huangbo
 * @date 2021/11/12
 */
public class LC00024_SwapPairs {
    public static void main(String[] args) {
        System.out.println("222");
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
