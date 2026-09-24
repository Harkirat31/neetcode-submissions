class Solution {
    private  List<List<Integer>> adj = new ArrayList<>();
    private Set<Integer> visited = new HashSet<>();
    public int countComponents(int n, int[][] edges) {
        for(int i = 0 ; i <n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int res = 0 ;

        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                dfs(i);
                res++;
            }
        }
        return res;

    }

    public void dfs(int node){
        visited.add(node);
        for(int nei:adj.get(node)){
            if(!visited.contains(nei)){
                dfs(nei);
            }
        }
    }
}
