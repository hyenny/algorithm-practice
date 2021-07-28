package com.algorithm.linkedlist;

public class ReverseList {
    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        print(reverseList.solve(head));
    }

    public ListNode solve(ListNode s) {
        ListNode next = null;
        ListNode prev = null;
        while(s != null) {
            next = s.next;
            s.next = prev;
            prev = s;
            s = next;
        }
        return prev;
    }

    private static void print(ListNode node) {
        while(node.next != null) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println(node.val);
    }
}
