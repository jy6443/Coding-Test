class Solution {
    public int max;
    public int solution(int k, int[][] dungeons) {
        boolean[] check = new boolean[dungeons.length];
        max = 0;
        loop (k, dungeons, 0, check);
        return max;
    }
    public void loop(int k, int[][] dungeons, int count,boolean[] check ) {
        for(int i=0; i<dungeons.length; i++) {
            if(dungeons[i][0] <=  k && !check[i]) {
                check[i] = true;
                loop(k-dungeons[i][1], dungeons, count+1, check);
                check[i] = false;
                
                }
        }
        if (count > max) {
            max = count;
        }
    
    }
}