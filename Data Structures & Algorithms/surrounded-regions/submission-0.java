class Solution {
    private int ROWS,COLS;
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;


        for(int i = 0 ; i <ROWS ; i++){
            if(board[i][0]=='O'){
                dfs(board,i,0);
            }
            if(board[i][COLS-1]=='O'){
                dfs(board,i,COLS-1);
            }
        }

        for(int j =0; j<COLS; j++){
            if(board[0][j]=='O'){
                dfs(board,0,j);
            }
            if(board[ROWS-1][j]=='O'){
                dfs(board,ROWS-1,j);
            }
        }

        for(int r = 0 ; r<ROWS ; r++){
            for(int c = 0 ; c < COLS ; c++){
              if(board[r][c]=='O'){
                board[r][c] = 'X';
              }else if(board[r][c]=='T'){
                board[r][c] = 'O';
              }    
            }
        }
        
    }

    public void dfs(char[][] board, int r ,int c){
        if(r<0 || c <0 || r==ROWS || c==COLS || board[r][c]!='O'){
            return;
        }

        board[r][c] = 'T';
        dfs(board,r,c+1);
        dfs(board,r,c-1);
        dfs(board,r+1,c);
        dfs(board,r-1,c);
    }
}
