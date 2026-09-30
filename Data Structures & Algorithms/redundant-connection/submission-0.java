class Solution {
    private  List<List<Integer>> adj;
    private boolean[] visit;
    private Set<Integer> cycle;
    private int cycleStart;
    public int[] findRedundantConnection(int[][] edges) {
        adj = new ArrayList<>();
        for(int i = 0 ; i <=edges.length ; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        visit = new boolean[edges.length+1];
        cycle = new HashSet<>();

        cycleStart = -1;
        dfs(1,-1);
        for(int i = edges.length-1 ; i >=0; i--){
            if(cycle.contains(edges[i][0]) && cycle.contains(edges[i][1])){
                return new int[]{edges[i][0],edges[i][1]};
            }
        }
        return new int[0];

    }

    private boolean dfs(int node, int par){
        if(visit[node]){
            cycleStart = node;
            return true;
        }
        visit[node] = true;
        for (int nei : adj.get(node)){
            if(nei==par) continue;
            if(dfs(nei,node)){
                if(cycleStart!=-1) cycle.add(node);
                if(cycleStart==node){
                    cycleStart = -1;
                }
                return true;
            }
        }
        return false;

    }
}


