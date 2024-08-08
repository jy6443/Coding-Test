import java.util.*;
class Solution {
    int[][] dir;
    public int[] solution(String[][] places) {
        int[] answer = new int[] {1,1,1,1,1};
        dir = new int[][]{{1,0},{-1,0},{0,1}};
        for(int i=0; i<5; i++){
            loop:for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    if(places[i][j].charAt(k) == 'P'){
                        if(bfs(places[i], j, k)){
                            answer[i] = 0;
                            break loop;
                        }
                    }
                }
            }
        }
        return answer;
    }
    public boolean bfs(String[] place, int y, int x){
        boolean[][] visit = new boolean[5][5];
        Queue<int[]> q = new ArrayDeque<>();
        visit[y][x] = true;
        q.add(new int[] {y,x,0});
        while(!q.isEmpty()){
            int[] out = q.remove();
            int cy = out[0], cx = out[1], dep = out[2];
            if(dep > 0 && place[cy].charAt(cx) == 'P'){
                return true;
            }
            if(dep < 2){
                for(int[] d : dir){
                    int ny = cy + d[0], nx = cx + d[1];
                    if(0<=ny && ny<5 && 0<=nx && nx<5 && visit[ny][nx] == false && place[ny].charAt(nx) != 'X'){
                        visit[ny][nx] = true;
                        q.add(new int[] {ny,nx,dep+1});
                    }
                }
            }
        }
        return false;
    }
}