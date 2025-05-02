import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] maxDp = new int[n][3];
        int[][] minDp = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int temp = Integer.parseInt(st.nextToken());
                minDp[i][j] = temp;
                maxDp[i][j] = temp;
            }
        }

        for (int i = 1; i < n; i++) {
            // index : 0
            int maxNext = Math.max(maxDp[i-1][0], maxDp[i-1][1]);
            int minNext = Math.min(minDp[i-1][0], minDp[i-1][1]);
            maxDp[i][0] = maxDp[i][0] + maxNext;
            minDp[i][0] = minDp[i][0] + minNext;

            // index : 2
            int maxNext2 = Math.max(maxDp[i-1][1], maxDp[i-1][2]);
            int minNext2 = Math.min(minDp[i-1][1], minDp[i-1][2]);
            maxDp[i][2] = maxDp[i][2] + maxNext2;
            minDp[i][2] = minDp[i][2] + minNext2;

            // index : 1
            maxDp[i][1] = maxDp[i][1] + Math.max(maxNext, maxNext2);
            minDp[i][1] = minDp[i][1] + Math.min(minNext, minNext2);
        }
        int maxResult = Math.max(Math.max(maxDp[n-1][0], maxDp[n-1][1]), maxDp[n-1][2]);
        int minResult = Math.min(Math.min(minDp[n-1][0], minDp[n-1][1]), minDp[n-1][2]);
        System.out.println(maxResult + " " + minResult);
    }
}