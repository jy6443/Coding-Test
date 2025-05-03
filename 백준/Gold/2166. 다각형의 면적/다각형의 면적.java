import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] points = new int[n+1][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }
        points[n][0] = points[0][0];
        points[n][1] = points[0][1];
        long a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            a += (long) points[i][0] * points[i+1][1];
            b += (long) points[i][1] * points[i+1][0];
        }
        double sum = Math.abs(a - b);
        System.out.printf("%.1f", Math.abs(sum / 2));
    }
}