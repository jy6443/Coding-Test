import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int row = maps.length;
        int col = maps[0].length;
        int answer = -1;
        
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0,0});
        while(!q.isEmpty()){
            int[] out = q.remove();
            int y = out[0], x = out[1];
            if(y == row-1 && x == col-1){
                answer = maps[y][x];
                break;
            }
            for(int[] d : dir) {
                int ny = y + d[0], nx = x + d[1];
                if(0 <= ny && ny < row && 0 <= nx && nx < col && maps[ny][nx] == 1){
                    maps[ny][nx] = maps[y][x] + 1;
                    q.add(new int[] {ny,nx});
                }
            }
        }
        return answer;
    }
}