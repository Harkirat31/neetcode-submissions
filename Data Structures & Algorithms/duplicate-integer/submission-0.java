class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i: nums){
            set.add(i);
        }
        if (nums.length==set.size()){
            return false;
        }else{
            return true;
        }
        
    }
}