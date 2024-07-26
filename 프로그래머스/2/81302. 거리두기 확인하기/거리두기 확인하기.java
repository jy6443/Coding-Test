import java.util.*;
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i=0; i<5; i++) {
            int key = 1;
            breakpoint:for(int j=0; j<5; j++) {
                for(int k=0; k<5; k++) {
                    if(places[i][j].charAt(k) == 'P') {
                        if(check(places[i], j, k) == 0){
                            key = 0;
                            break breakpoint;
                        }
                    }
                }
            }
            answer[i] = key;
        }
        return answer;
    }
    public int check(String[] now, int a, int b) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{a,b,0});
        int[][] dir = {{1,0},{0,1},{-1,0}};
        boolean[][] visit = new boolean[5][5];
        visit[a][b] = true;
        while(!q.isEmpty()){
            int[] out = q.remove();
            int y = out[0], x = out[1], dep = out[2];
            if(dep > 2) {
                break;
            }
            if(now[y].charAt(x) == 'P' && dep > 0){
                return 0;
            }
            for(int[] d : dir) {
                int ny = y + d[0], nx = x + d[1];
                if(dep < 2 && ny >= 0 && ny < 5 && nx >= 0 && nx < 5 && now[ny].charAt(nx) != 'X' && !visit[ny][nx]){
                    visit[ny][nx] = true;
                    q.add(new int[] {ny,nx,dep+1});
                    
                }
            }
        }
        return 1;
    }
}