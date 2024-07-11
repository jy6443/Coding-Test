class Solution {
    public int answer;
    
    public void bt(int dep, int[][] dungeons, int k, boolean[] check) {
        for (int i=0; i<dungeons.length; i++) {
           if(dungeons[i][0] <= k && !check[i]){
               check[i] = true;
               bt(dep+1,dungeons,k-dungeons[i][1],check);
               check[i] = false;
           }
        }
        answer = Math.max(answer, dep);
    }
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        boolean[] check = new boolean[dungeons.length];
        bt(0,dungeons,k,check);
        return answer;
    }
}