class Solution {
    private Map<Integer,List<Integer>> preMap = new HashMap<>();


    private Set<Integer> visited = new HashSet<>();

    private Set<Integer> cycle = new HashSet<>();

    List<Integer> output = new ArrayList<>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int i = 0; i< numCourses ; i++){
            preMap.put(i, new ArrayList<>());
        }
        
        for(int[] pre : prerequisites){
            preMap.get(pre[0]).add(pre[1]);
        }

        for(int crs = 0; crs<numCourses;crs++){
            if(!dfs(crs)){
                return new int[0];
            }
        }

        int[] res = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            res[i] = output.get(i);
        }

        return res;

    }

    public boolean dfs(int crs){
        if(cycle.contains(crs)){
            return false;
        }

        if(visited.contains(crs)){
            return true;
        }
        cycle.add(crs);
        for(int c : preMap.get(crs)){
            if(!dfs(c)){
                return false;
            }
        }
        cycle.remove(crs);
        visited.add(crs);
        output.add(crs);
        return true;
    }
}
