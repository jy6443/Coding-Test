import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] arr = new int[2][n];
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            for (int j = 1; j < n; j++) {
                if (j == 1) {
                    arr[0][j] += arr[1][j-1];
                    arr[1][j] += arr[0][j-1];
                } else {
                    int before = Math.max(arr[0][j-2], arr[1][j-2]);
                    arr[0][j] = Math.max(arr[0][j] + arr[1][j-1], arr[0][j] + before);
                    arr[1][j] = Math.max(arr[1][j] + arr[0][j-1], arr[1][j] + before);
                }
            }
            System.out.println(arr[0][n-1] > arr[1][n-1] ? arr[0][n-1] : arr[1][n-1]);
        }
    }
}