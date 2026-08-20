class Solution {
    public int longestConsecutive(int[] nums) {
       // Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set  = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int res = 0;
        for(int num: nums){
            int l = 0;
            if(!set.contains(num-1)){
                while(set.contains(num)){
                    l++;
                    num++;
                }
                res = Math.max(res,l);
            }
        }
        return res;
        
    }
}
