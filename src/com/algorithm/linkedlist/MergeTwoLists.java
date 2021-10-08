package com.algorithm.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * [leetcode] 21. Merge Two Sorted Lists
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        mergeTwoLists.solve(l1, l2);
    }

    public ListNode solve(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;

        ListNode one = l1;
        ListNode two = l2;

        // ListNode의 val을 일차원 배열로 다 담는다.
        List<Integer> mergedList = new ArrayList<>();
        merge(one, mergedList);
        merge(two, mergedList);

        // val을 오름차순 정렬한다.
        Collections.sort(mergedList);

        // 정렬된 일차원 배열을 순회하여 ListNode에 담는다.
        ListNode head = new ListNode(0);
        ListNode result = head;
        for (int i = 0; i < mergedList.size(); i++) {
            head.next = new ListNode(mergedList.get(i));
            head = head.next;
        }

        return result.next;
    }

    private void merge(ListNode listNode, List<Integer> arr) {
        if (listNode == null) return;

        while(listNode.next != null) {
            arr.add(listNode.val);
            listNode = listNode.next;
        }
        arr.add(listNode.val);

    }
}
