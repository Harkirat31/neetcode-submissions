class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
    
        def helper(i,nums):
            if (i==len(nums)):
                return [[]]

            permResult = []
            perms = helper(i+1,nums)
            
            for p in perms:
                for j in range(len(p)+1):
                    copy = p.copy()
                    copy.insert(j,nums[i])
                    permResult.append(copy)
            return permResult
        
        return helper(0,nums)
                





        