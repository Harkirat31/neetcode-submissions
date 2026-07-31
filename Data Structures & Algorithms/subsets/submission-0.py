class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        curr = []

        def backtrack(i,res,curr):
            if i >= len(nums):
                res.append(curr.copy())
                return
            
            curr.append(nums[i])

            backtrack(i+1,res,curr)
            curr.pop()
            backtrack(i+1,res,curr)
        
        backtrack(0,res,curr)
        return res

        