class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n]; 
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(i, computers, visit); 
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int node, int[][] computers, boolean[] visit) {
        visit[node] = true;
        
        for (int i = 0; i < computers.length; i++) {
            if (computers[node][i] == 1 && !visit[i]) {
                dfs(i, computers, visit);
            }
        }
    }
}