# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def merge2Lists(self,l1,l2):
        merged = ListNode(0)
        pointer = merged
        while l1 and l2:
            if l1.val<=l2.val:
                pointer.next = l1
                pointer = pointer.next
                l1 = l1.next
            else:
                pointer.next = l2
                pointer = pointer.next
                l2 = l2.next
        if l1:
            pointer.next = l1
        if l2:
            pointer.next = l2

        return merged.next
        


    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        
        if len(lists)==0:
            return None
        if len(lists)==1:
            return lists[0] if len(lists[0])>0 else none
        
        
        
        for i in range(1,len(lists)):
            lists[i] = self.merge2Lists(lists[i-1],lists[i])
        
        if lists[len(lists)-1]:
            return lists[len(lists)-1]
        else:
            return None


        
        