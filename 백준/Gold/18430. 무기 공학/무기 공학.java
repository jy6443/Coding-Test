import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[][] wood;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        wood  = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                wood[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = 0;
        boolean[][] visited = new boolean[n][m];
        bt(visited, 0, 0);
        System.out.println(answer);

    }
    public static void bt (boolean[][] visited, int sum, int index) {
        if (index >= n * m) {
            answer = answer < sum ? sum : answer;
            return;
        }
        int i = index / m;
        int j = index % m;
        if (!visited[i][j]) {
            // 1. 북서
            if (i - 1 >= 0 && j - 1 >= 0 && !visited[i - 1][j] && !visited[i][j - 1]) {
                visited[i][j] = true;
                visited[i - 1][j] = true;
                visited[i][j - 1] = true;
                bt(visited, sum + (wood[i][j] * 2) + wood[i - 1][j] + wood[i][j - 1], index + 1);
                visited[i][j] = false;
                visited[i - 1][j] = false;
                visited[i][j - 1] = false;
            }
            // 2. 북동
            if (i - 1 >= 0 && j + 1 < m && !visited[i - 1][j] && !visited[i][j + 1]) {
                visited[i][j] = true;
                visited[i - 1][j] = true;
                visited[i][j + 1] = true;
                bt(visited, sum + (wood[i][j] * 2) + wood[i - 1][j] + wood[i][j + 1], index + 1);
                visited[i][j] = false;
                visited[i - 1][j] = false;
                visited[i][j + 1] = false;
            }
            // 3. 남서
            if (i + 1 < n && j - 1 >= 0 && !visited[i + 1][j] && !visited[i][j - 1]) {
                visited[i][j] = true;
                visited[i + 1][j] = true;
                visited[i][j - 1] = true;
                bt(visited, sum + (wood[i][j] * 2) + wood[i + 1][j] + wood[i][j - 1], index + 1);
                visited[i][j] = false;
                visited[i + 1][j] = false;
                visited[i][j - 1] = false;
            }
            // 4. 남동
            if (i + 1 < n && j + 1 < m && !visited[i + 1][j] && !visited[i][j + 1]) {
                visited[i][j] = true;
                visited[i + 1][j] = true;
                visited[i][j + 1] = true;
                bt(visited, sum + (wood[i][j] * 2) + wood[i + 1][j] + wood[i][j + 1], index + 1);
                visited[i][j] = false;
                visited[i + 1][j] = false;
                visited[i][j + 1] = false;
            }
        }
        bt(visited, sum, index + 1);
    }
}
