import java.util.*;
class Solution {
    public int row;
    public int col;
    public int solution(String[] maps) {
        row = maps.length;
        col = maps[0].length();
        int answer = 0;
        int[] start = new int[2];
        int[] lev = new int[2];
        int[] end = new int[2];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(maps[i].charAt(j) == 'S'){
                    start = new int[] {i,j};
                    maps[i] = maps[i].replace('S','O');
                } else if(maps[i].charAt(j) == 'L'){
                    lev = new int[] {i,j};
                    maps[i] = maps[i].replace('L','O');
                } else if(maps[i].charAt(j) == 'E'){
                    end = new int[] {i,j};
                    maps[i] = maps[i].replace('E','O');
                }
            }
        }
        
        int first = bfs(start,lev,maps);
        int second = bfs(lev,end,maps);
        if(first > 0 && second > 0) {
            return first + second;
        }
        
        return -1;
    }
    public int bfs(int[] go, int[] stop, String[] maps){
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        int[][] visit = new int[row][col];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(go);
        while(!q.isEmpty()){
            int[] out = q.remove();
            int y = out[0], x = out[1];
            if(y ==  stop[0] && x == stop[1]){
                return visit[y][x];
            }
            for(int[] d : dir) {
                int ny = y + d[0], nx = x + d[1];
                if(ny >= 0 && ny < row && nx >= 0 && nx < col && maps[ny].charAt(nx) == 'O' && visit[ny][nx] == 0){
                    visit[ny][nx] = visit[y][x] + 1;
                    q.add(new int[] {ny,nx});
                }
            }
        }
        return -1;
        
    }
}