class Solution {
    public int solution(int n) {
        boolean[][] visit = new boolean[n][n];
        int answer = queen(visit,0,n);
        return answer;
    }
    public int queen(boolean[][] visit, int row, int n){
        if(row == n){
            return 1;
        }
        int cnt = 0;
        for(int col=0; col<n; col++){
            if(check(row,col,n,visit)){
                visit[row][col] = true;
                cnt += queen(visit,row+1,n);
                visit[row][col] = false;
            }
        }
        return cnt;
    }
    
    public boolean check(int row, int col, int n, boolean[][] visit){
        for(int i=0; i<row; i++){
            if(visit[i][col]){
                return false;
            }
        }
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
            if(visit[i][j]){
                return false;
            }       
        }
        for(int i=row-1, j=col+1; i>=0 && j<n; i--,j++){
            if(visit[i][j]){
                return false;
            } 
        }
        return true;
    }
}