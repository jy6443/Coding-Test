import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = 0;
        if (grid[n-1][n-1] == 1) {
            System.out.println(answer);
        } else {
            move(grid, new int[]{0, 0, 0, 1});
            System.out.println(answer);
        }

    }
    public static void move(int[][] grid, int[] point) {
        int y1 = point[0], x1 = point[1], y2 = point[2], x2 = point[3];
        if ((y1 == n - 1 && x1 == n - 1) || (y2 == n - 1 && x2 == n - 1)) {
            answer++;
            return;
        }
        if (y1 == y2) { // 가로
            if (x2 + 1 < n && grid[y2][x2+1] == 0) {
                move(grid, new int[]{y1, x1 + 1, y2, x2 + 1});
            }
            if (x2 + 1 < n && y2 + 1 < n && grid[y2][x2+1] == 0 && grid[y2+1][x2] == 0 && grid[y2+1][x2+1] == 0) {
                move(grid, new int[]{y1, x1 + 1, y2 + 1, x2 + 1});
            }
        } else if (x1 == x2) { // 세로
            if (y2 + 1 < n && grid[y2+1][x2] == 0) {
                move(grid, new int[]{y1 + 1, x1, y2 + 1, x2});
            }
            if (x2 + 1 < n && y2 + 1 < n && grid[y2][x2+1] == 0 && grid[y2+1][x2] == 0 && grid[y2+1][x2+1] == 0) {
                move(grid, new int[]{y1 + 1, x1, y2 + 1, x2 + 1});
            }
        } else { // 대각선
            if (x2 + 1 < n && grid[y2][x2+1] == 0) {
                move(grid, new int[]{y1 + 1, x1 + 1, y2, x2 + 1});
            }
            if (y2 + 1 < n && grid[y2+1][x2] == 0) {
                move(grid, new int[]{y1 + 1, x1 + 1, y2 + 1, x2});
            }
            if (x2 + 1 < n && y2 + 1 < n && grid[y2][x2+1] == 0 && grid[y2+1][x2] == 0 && grid[y2+1][x2+1] == 0) {
                move(grid, new int[]{y1 + 1, x1 + 1, y2 + 1, x2 + 1});
            }
        }
    }
}