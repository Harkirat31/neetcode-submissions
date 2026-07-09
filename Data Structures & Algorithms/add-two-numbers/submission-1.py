# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        head = ListNode()
        temp = head
        carry = 0
        while l1 and l2:
            temp.next = ListNode()
            temp=temp.next
            sum = l1.val + l2.val + carry
            carry = sum//10
            temp.val = sum%10
            l1 = l1.next
            l2 = l2.next
        while l1:
            temp.next = ListNode()
            temp=temp.next
            sum = carry+l1.val
            carry = sum//10
            temp.val = sum%10 
            l1 = l1.next
        while l2:
            temp.next = ListNode()
            temp=temp.next
            sum = carry+l2.val
            carry = sum//10
            temp.val = sum%10 
            l2 = l2.next
        if carry!=0:
            temp.next = ListNode()
            temp=temp.next
            temp.val = carry

        return head.next


                


