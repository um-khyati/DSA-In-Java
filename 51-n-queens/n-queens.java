class Solution {
    static boolean isSafe(int n,int c, int r,  char [][] board){
       for (int i = 0; i < r; i++) {
            if (board[i][c] == 'Q')
                return false;
        }

        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

 
        for (int i = r, j = c; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
    
    return true;
    }
    public static void solve(int n, char [][] board , List<List<String>> ans,int r){
if(r==n){
ArrayList<String> a= new ArrayList<>();

    for(int i=0; i<n; i++){
       a.add(new String(board[i]));
    }
  ans.add(new ArrayList<>(a));
    return;
}

        for(int i=0; i<n; i++){
if(isSafe(n,i,r,board)){
    board[r][i]='Q';
    
    solve(n,board,ans,r+1);
    board[r][i]='.';
    
}
        }
    }
    public List<List<String>> solveNQueens(int n) {
           char [][] board =  new char[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(board[i],'.');
        }
List<List<String>> ans = new ArrayList<>();
        solve(n,board, ans,0);
        return ans;
    }
}