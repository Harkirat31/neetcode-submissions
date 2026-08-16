class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map =  new HashMap<>();
        for(String s : strs){
            int[] count = new int[26];
            for(Character c : s.toCharArray()){
                count[c-'a']++;
            }
            String key = Arrays.toString(count);
            map.putIfAbsent(key,new ArrayList<String>());
            map.get(key).add(s) ;
        }

        return new ArrayList<>(map.values());

    }
}
