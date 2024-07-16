import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import java.io.IOException;

public class Main {
    public static int dep;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 1 ~ 500,000
        int m = Integer.parseInt(st.nextToken());

        int[][] pics = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().trim().split(" ");
            for (int j = 0; j < m; j++) {
                pics[i][j] = Integer.parseInt(line[j]);
            }
        }
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int cnt = 0;
        int area = 0;
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && pics[i][j] == 1) {
                    visited[i][j] = 1;
                    dep = 0;
                    dfs(n,m,i,j,pics,visited,dx,dy);
                    cnt++;
                    area = Math.max(area,dep);
                }

            }
        }
        System.out.println(cnt);
        System.out.println(area);
    }
    public static void dfs(int n, int m, int i, int j, int[][] pics, int[][] visited, int[] dx, int[] dy) {
        dep++;
        for (int k = 0; k < 4; k++) {
            int di = i + dx[k];
            int dj = j + dy[k];
            if (0 <= di && di < n && 0 <= dj && dj < m &&visited[di][dj] == 0 && pics[di][dj] == 1) {
                visited[di][dj] = visited[i][j] + 1;
                dfs(n,m,di,dj,pics,visited,dx,dy);
            }
        }
    }
}
