package com.guo;

public class c {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode a = pHead;
        ListNode b = pHead;
        while(pHead.next != null){
            a = pHead.next;
            b = pHead.next.next;
            if(a==b){
                return a;
            }
        }
        return null;
    }
}
