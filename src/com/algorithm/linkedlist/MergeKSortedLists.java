package com.algorithm.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(7));
        ListNode[] lists = {l1, l2, l3};
        ListNode result = mergeKSortedLists.solve_heap(lists);
        print(result);
    }

    public ListNode solve(ListNode[] lists) {
        List<Integer> arrayList = new ArrayList<>();
        for (ListNode node : lists) {
            while(node.next != null) {
                arrayList.add(node.val);
                node = node.next;
            }
            arrayList.add(node.val);
        }
        Collections.sort(arrayList);

        ListNode newHead = new ListNode(0);
        ListNode result = newHead;
        for (int i = 0; i < arrayList.size(); i++) {
            newHead.next = new ListNode(arrayList.get(i));
            newHead = newHead.next;
        }

        return result.next;
    }

    public ListNode solve_heap(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode node : lists) {
            while(node.next != null) {
                pq.offer(node.val);
                node = node.next;
            }
            pq.offer(node.val);
        }

        ListNode newHead = new ListNode(0);
        ListNode result = newHead;
        while(!pq.isEmpty()) {
            int val = pq.poll();
            newHead.next = new ListNode(val);
            newHead = newHead.next;
        }

        return result.next;
    }

    private static void print(ListNode node) {
        while(node.next != null) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println(node.val);
    }
}

