import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] points = new int[m][4]; // (x1, y1, x2, y2) x행 y열
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                points[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = nums[i][0];
            } else {
                dp[i][0] = dp[i-1][0] + nums[i][0];
                dp[0][i] = dp[0][i-1] + nums[0][i];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + nums[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            int x1 = points[i][0]-1, y1 = points[i][1]-1, x2 = points[i][2]-1, y2 = points[i][3]-1;
//            int result = dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] +dp[x1-1][y1-1];
            int result = dp[x2][y2];
            if (y1 != 0) {
                result -= dp[x2][y1-1];
            }
            if (x1 != 0) {
                result -= dp[x1-1][y2];
            }
            if (x1 != 0 && y1 != 0) {
                result += dp[x1-1][y1-1];
            }
            System.out.println(result);
        }

    }
}