class Solution {
    public int answer;
    public int solution(int n) {
        answer = 0;
        int[][] visit = new int[n][n];
        dfs(0,visit,n);
        return answer;
    }
    public void dfs(int s, int[][] visit, int n) {
        if(s == n) {
            answer++;
            return;
        }
        for(int i=0; i<n; i++) {
            if(visit[s][i] == 0){
                queen(visit,s,i,n,1);
                dfs(s+1,visit,n);
                queen(visit,s,i,n,-1);
            }
        }
    }
    public void queen(int[][] visit, int row, int col, int n, int flag) {
        for(int i=0; i<n; i++) {
            visit[i][col]+=flag;
            for(int j=0; j<n; j++) {
                if(col-row == j-i || col+row == i+j) {
                    visit[i][j]+=flag;
                }
            }
        }
        visit[row][col]-=flag;
    }
}