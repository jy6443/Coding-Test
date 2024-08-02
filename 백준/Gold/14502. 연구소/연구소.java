import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import java.io.IOException;

public class Main {
    public static int answer;
    public static int[][] dir;
    public static int n;
    public static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 3 ≤ N, M ≤ 8
        m = Integer.parseInt(st.nextToken()); // 3 ≤ N, M ≤ 8
        int[][] maps = new int[n][m];
        dir = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                maps[i][j] = Integer.parseInt(tokens[j]);
            }
        }
        block(0,maps);
        System.out.println(answer);

    }
    public static int bfs(int[][] maps){
        int count = 0;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i][j] == 2) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.remove();
            int y = cur[0], x = cur[1];
            for (int[] d : dir){
                int ny = y + d[0], nx = x + d[1];
                if(0<= ny && ny < n && 0<= nx && nx < m && !visited[ny][nx] && maps[ny][nx] == 0){
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i][j] == 0 && !visited[i][j]){
                    count++;
                }
            }
        }
        return count;
    }

    public static void block(int cnt, int[][] maps) {
        if(cnt == 3){
            int safe_area = bfs(maps);
            answer = Math.max(answer, safe_area);
            return;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(maps[i][j] == 0){
                    maps[i][j] = 1;
                    block(cnt+1, maps);
                    maps[i][j] = 0;
                }
            }
        }
    }
}