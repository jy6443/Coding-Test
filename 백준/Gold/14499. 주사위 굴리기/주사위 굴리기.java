import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] dirs = new int[][]{{0,0}, {0,1}, {0,-1}, {-1,0}, {1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] order = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }
        Map<Integer, Integer> dice = new HashMap<>(); // 동 서 북 남
        for (int i = 1; i < 7; i++) {
            dice.put(i, 0); // 1-6 , 3-4 , 2-5
        }
        int top = 1, bottom = 6, front = 5, back = 2, left = 4, right = 3;
        for (int i = 0; i < order.length; i++) {
            int dir = order[i];
            y += dirs[dir][0];
            x += dirs[dir][1];
            if (0 <= x && x < m && 0 <= y && y < n) {
                if (dir == 1) { // 동
                    int temp = top;
                    top = left;
                    left = bottom;
                    bottom = right;
                    right = temp;
                } else if (dir == 2) { // 서
                    int temp = top;
                    top = right;
                    right = bottom;
                    bottom = left;
                    left = temp;
                } else if (dir == 3) { // 북
                    int temp = top;
                    top = front;
                    front = bottom;
                    bottom = back;
                    back = temp;
                } else { // 남
                    int temp = top;
                    top = back;
                    back = bottom;
                    bottom = front;
                    front = temp;
                }
                if (grid[y][x] != 0) {
                    dice.put(bottom, grid[y][x]);
                    grid[y][x] = 0;
                } else {
                    grid[y][x] = dice.get(bottom);
                }
                System.out.println(dice.get(top));
            } else {
                y -= dirs[dir][0];
                x -= dirs[dir][1];
            }
        }
    }
}