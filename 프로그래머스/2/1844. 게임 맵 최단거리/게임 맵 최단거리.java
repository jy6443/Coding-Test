import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int row = maps.length;
        int col = maps[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0,0});
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()) {
            int[] out = q.remove();
            int y = out[0], x = out[1];
            if(y == row-1 && x == col-1) {
                return maps[y][x];
            }
            for(int[] d : dir) {
                int ny = y + d[0], nx = x + d[1];
                if (ny >= 0 && ny < row && nx >= 0 && nx < col && maps[ny][nx] == 1) {
                    q.add(new int[] {ny,nx});
                    maps[ny][nx] = maps[y][x] + 1;
                }
            }
        }
        return answer;
    }
}