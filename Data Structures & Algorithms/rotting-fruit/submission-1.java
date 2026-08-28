class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int totalFresh = 0;

        for(int i =0 ; i < m ; i++){
            for (int j = 0; j<n ; j++){
                if(grid[i][j]==2){
                    q.add(new int[] {i , j});
                }
                if(grid[i][j]==1){
                    totalFresh++;
                }
            }
        }

        if(q.size()==0 && totalFresh==0){
            return 0;
        }

        int min  = -1;
        while (!q.isEmpty()){
            min++;
            int  l = q.size();
            while(l>0){
                int[] node = q.poll();
                int row = node[0];
                int col = node[1];
                for(int[] dir : dirs){
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if(r<0 || c<0 || r>=m || c>=n || grid[r][c]==0 || grid[r][c]==2){
                        continue;
                    }else{
                        totalFresh--;
                        grid[r][c] = 2;
                        q.add(new int[]{r,c});
                    }
                }
                l--;
            }
        }

        if(totalFresh>0){
            return -1;
        }

        return min;
    }
}
