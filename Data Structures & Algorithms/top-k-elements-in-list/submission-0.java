class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map =  new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>((o1,o2)->o1.getValue()-o2.getValue());

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            minHeap.add(entry);
            if (minHeap.size()>k){
                minHeap.remove();
            }
        }

        int[] res = new int[k];

        for (int i = 0; i <k ; i++){
            res[i] = minHeap.poll().getKey();
        }

        return res;


        
    }
}
