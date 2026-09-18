class Solution {

    private Map<Integer,List<Integer>> adj = new HashMap();

    private Set<Integer> visited = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {

        for(int i =0; i < n; i++){
            adj.put(i,new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        if(!dfs(0,-1)){
            return false;
        }

        return visited.size()==n;
    }

    public boolean dfs(int n ,int pre){
        if(visited.contains(n)){
            return false;
        }
        visited.add(n);
        for(int nei : adj.get(n)){
            if(nei==pre){
                continue;
            }
            if(!dfs(nei,n)){
                return false;
            }
        }
        return true;
    }

}
