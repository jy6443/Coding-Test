class Solution {
    public int answer;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        boolean[] visit = new boolean[dungeons.length];
        bt(k,dungeons,visit,0);
        return answer;
    }
    public void bt(int k,int[][] dungeons, boolean[] visit, int cnt){
        for(int i=0; i<dungeons.length; i++){
            if(dungeons[i][0] <= k && !visit[i]){
                visit[i] = true;
                bt(k-dungeons[i][1], dungeons, visit, cnt+1);
                visit[i] = false;
            }
        }
        answer = Math.max(answer, cnt);
    }
}