/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    public ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode merged = new ListNode(0);
        ListNode pointer = merged;
        while (l1!=null && l2!=null){
            if (l1.val<=l2.val){
                pointer.next = l1;
                pointer = pointer.next;
                l1=l1.next;
            }else{
                pointer.next = l2;
                pointer = pointer.next;
                l2=l2.next;
            }

        }
        if(l1!=null){
                pointer.next = l1;
        }
        if(l2!=null){
                pointer.next = l2;
        }
        return merged.next;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        for(int i =1 ; i<lists.length ; i++){
            lists[i] = merge2Lists(lists[i-1],lists[i]);
        }
        return lists[lists.length-1];
    }
}
