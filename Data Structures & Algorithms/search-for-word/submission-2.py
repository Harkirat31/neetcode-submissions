class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        res = False

        s = set()

        def backtrack(i,j,c,s):
            nonlocal res
            if res:
                return
            if c ==len(word):
                res = True
                return
            if i>=len(board) or j >=len(board[i]):
                return
            if (i,j) in s:
                return
            
        
            if word[c]==board[i][j]:
                s.add((i,j))
                backtrack(i+1,j,c+1,s)
                backtrack(i,j+1,c+1,s)
                if i>0:
                    backtrack(i-1,j,c+1,s)
                if j>0:
                    backtrack(i,j-1,c+1,s)
                s.remove((i,j))
        for i in range(len(board)):
            if res:
                break
            for j in range(len(board[i])):
                if res:
                    break
                backtrack(i,j,0,s)
        
        return res

        




    
    

        