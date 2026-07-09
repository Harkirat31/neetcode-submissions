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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode temp  = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        int x = len-n-1;
        temp = head;
        while(x>0){
            x--;
            temp = temp.next;
        }
       
        if(x==-1){
            return head.next;
        }
        temp.next = temp.next.next;
        return head;

    }
}
