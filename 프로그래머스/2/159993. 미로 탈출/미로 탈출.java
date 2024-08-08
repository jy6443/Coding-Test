import java.util.*;
class Solution {
    public int[][] dir; 
    public int[] start, lever, end;
    public int solution(String[] maps) {
        int answer = -1;
        dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[i].length(); j++){
                if(maps[i].charAt(j) == 'S'){
                    start = new int[] {i,j};
                    maps[i] = maps[i].replace('S','O');
                } else if(maps[i].charAt(j) == 'E'){
                    end = new int[] {i,j};
                    maps[i] = maps[i].replace('E','O');
                } else if(maps[i].charAt(j) == 'L'){
                    lever = new int[] {i,j};
                    maps[i] = maps[i].replace('L','O');
                }
            }
        }
        int first = depth(start,lever,maps);
        int second = depth(lever,end,maps);
        if(first != -1 && second != -1){
            answer = first+second;
        }
        return answer;
    }
    public int depth(int[] start, int[] end, String[] maps){
        int row = maps.length;
        int col = maps[0].length();
        int[][] visit = new int[row][col];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(start);
        while(!q.isEmpty()){
            int[] out = q.remove();
            int y = out[0], x = out[1];
            if(y == end[0] && x == end[1]){
                return visit[y][x];
            }
            for(int[] d : dir){
                int ny = y + d[0], nx = x + d[1];
                if(0<=ny && ny<row && 0<=nx && nx<col && maps[ny].charAt(nx) == 'O'){
                    if(visit[ny][nx] == 0){
                        visit[ny][nx] = visit[y][x] + 1;
                        q.add(new int[] {ny,nx});
                        
                    }
                }
            }
        }
        return -1;
    }
}