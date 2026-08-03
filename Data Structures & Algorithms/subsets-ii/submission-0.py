class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res = []
        comb = []
        def helper(i, comb, res, nums):
            if i > len(nums):
                return
            
            if i == len(nums):
                res.append(comb.copy())
                return
            
            comb.append(nums[i])
            
            helper(i+1,comb,res,nums)
            comb.pop()
            while i < len(nums)-1 and nums[i]==nums[i+1]:
                i+=1
            helper(i+1,comb,res,nums)

        helper(0,comb,res,nums)
        return res


        