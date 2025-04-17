import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] dirs = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][m];
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        boolean[][] visited = new boolean[n][m];
        while (true) {
            if (!visited[r][c] && grid[r][c] == 0) {
                visited[r][c] = true;
                answer++;
            }
            if (wall(r, c, grid, visited)) {
                d = (d + 3) % 4;
                while (visited[r + dirs[d][0]][c + dirs[d][1]] || grid[r + dirs[d][0]][c + dirs[d][1]] == 1) {
                    d = (d + 3) % 4;
                }
                r += dirs[d][0];
                c += dirs[d][1];
            } else {
                int nr = r - dirs[d][0];
                int nc = c - dirs[d][1];
                if (grid[nr][nc] == 1) {
                    break;
                } else {
                    r = nr;
                    c = nc;
                }

            }
        }
        System.out.println(answer);
    }
    public static boolean wall (int r, int c, int[][] grid, boolean[][] visited) {
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (0 <= nr && nr < n && 0 <= nc && nc < m) {
                if (grid[nr][nc] == 0 && !visited[nr][nc]) {
                    return true;
                }
            }
        }
        return false;
    }
}