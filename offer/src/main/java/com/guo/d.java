package com.guo;

public class d {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = (getLength(pHead1));
        int len2 = (getLength(pHead2));
        ListNode a = pHead1;
        ListNode b = pHead2;
        if(len1 == 0 || len2 == 0){
            return null;
        }
        if(len1 > len2){
            while((len1-len2)!=0){
                a = a.next;
                len1 --;
            }
        }else if(len2 >len1){
            while((len2 - len1)!=0){
                b = b.next;
                len2 --;
            }
        }
        while(a!=b){
            if(a.next!= null||b.next!= null){
                a = a.next;
                b = b.next;
            }else{
                return null;
            }
        }
        return a;
    }
    public static int getLength(ListNode pHead){
        int len = 0;
        while(pHead!= null){
            len++;
            pHead = pHead.next;
        }
        return len;
    }
}
