package com.aaron.algorithm.leecase;

/**
 * lc19. 删除链表的倒数第 N 个结点
 * 
 * @author huangbo
 * @date 2021/10/29
 */
public class LC00019_RemoveNthFromEnd {

    public static void main(String[] args) {

        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = null;
        int n = 2;
        LC00019_RemoveNthFromEnd name = new LC00019_RemoveNthFromEnd();
        System.out.println(name.removeNthFromEnd(head1, n));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode index1 = head, index2 = head;
        for (int i = 0; i < n; i++) {
            index2 = index2.next; // 使得index1与index2之间间隔n-1个节点
        }
        if (index2 == null) {
            return head.next; // 说明删除的是头节点
        }
        while (index2.next != null) { // 将index2移至最后一个节点
            index2 = index2.next;
            index1 = index1.next;
        }
        index1.next = index1.next.next;
        return head;
    }
}
