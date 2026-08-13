class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0},
                                               {0, 1}, {0, -1}};

    private int area = 0;
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int r =0; r < grid.length ; r++){
            for (int c=0; c < grid[r].length;c++){
                if(grid[r][c]==1){
                    this.area = 0;
                    dfs(r,c,grid);
                    maxArea = Math.max(maxArea,this.area);
                }
            }
        }
        return maxArea;
    }

    public void dfs(int r, int c , int[][] grid){

        if(r<0 || c<0 || r>= grid.length || c >= grid[r].length|| grid[r][c] == 0 ){
            return;
        }
        if (grid[r][c] == 1){
            grid[r][c] = 0;
            this.area = this.area +1;
            for (int[] dir : directions){
                dfs(r+dir[0],c+dir[1],grid);
            }
        }
    }
}
