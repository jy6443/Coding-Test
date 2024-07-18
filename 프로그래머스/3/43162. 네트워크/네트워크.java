class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        // for(int i=0; i<n; i++) {
        //     computer[i][i] = 0;
        // }
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if(!visit[j] && computers[i][j] == 1) {
                    visit[j] = true;
                    dfs(j,computers,visit);
                    answer++;
                }
            }
        }
        return answer;
    }
    public void dfs(int j, int[][] computers, boolean[] visit) {
        for(int k=0; k<computers.length; k++) {
            if(!visit[k] && computers[j][k] == 1) {
                visit[k] = true;
                dfs(k,computers,visit);
            }
        }
    }
}