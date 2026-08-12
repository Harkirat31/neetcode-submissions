class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        ROWS = len(grid)-1
        COLS = len(grid[0])-1

        
        directions = [[0,1],[1,0],[0,-1],[-1,0]]
        islands = 0
        def dfs(r,c):
            if r>ROWS or c >COLS or r<0 or c<0 or grid[r][c]=="0":
                return
            grid[r][c] = "0"

            for dr,dc in directions:
                dfs(r+dr,c+dc)
        for r in range(len(grid)):
            for c in range(len(grid[r])):
                if grid[r][c] == "1":
                    islands+=1
                    dfs(r,c)
        
        return islands
        
            
            

        