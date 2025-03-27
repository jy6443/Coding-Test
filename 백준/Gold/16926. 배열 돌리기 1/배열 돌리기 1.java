import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][m];
        int[][] answer = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        List<List<int[]>> data = new ArrayList<>();
        boolean[][] visit = new boolean[n][m];
        int[][] dir = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int temp = Math.min(m, n) / 2;
        for (int i = 0; i < temp; i++) {
            int y = i, x = i;
            visit[y][x] = true;
            List<int[]> lst = new ArrayList<>();
            lst.add(new int[]{y, x});
            int alt = 0;
            while (alt < 4) {
                y += dir[alt][0];
                x += dir[alt][1];
                if (0 <= y && 0 <= x && y < n && x < m && !visit[y][x]) {
                    visit[y][x] = true;
                    lst.add(new int[]{y, x});
                } else {
                    y -= dir[alt][0];
                    x -= dir[alt][1];
                    alt++;
                }
            }
            data.add(lst);
        }
        for (int i = 0; i < temp; i++) {
            for (int j = 0; j < data.get(i).size(); j++) {
                int y = data.get(i).get(j)[0];
                int x = data.get(i).get(j)[1];
                int k = (j + r) % data.get(i).size();
                answer[data.get(i).get(k)[0]][data.get(i).get(k)[1]] = grid[y][x];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

    }
}