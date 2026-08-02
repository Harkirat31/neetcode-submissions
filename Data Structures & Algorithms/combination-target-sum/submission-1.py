class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        comb = []

        def combination(i,res,comb,target):    
            if sum(comb)>target:
                return
            if sum(comb)==target:
                res.append(comb.copy())
                return
            if i >= len(nums):
                return
            
            comb.append(nums[i])

            combination(i,res,comb,target)
            comb.pop()
            combination(i+1,res,comb,target)
        
        combination(0,res,comb,target)
        return res
            
            
            


        