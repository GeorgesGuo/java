package com.guo;

import java.util.Arrays;
import java.util.Random;

public class j {

 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

    public static class Solution {

        public static ListNode EntryNodeOfLoop(ListNode pHead)
        {

            ListNode fast = pHead;
            ListNode slow = pHead;
            while (fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
                if(fast == slow){
                    break;
                }
            }
            //没有环返回null；
            if(fast == null || fast.next == null){
                return null;
            }
            slow = pHead;
            while (fast != slow){
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
