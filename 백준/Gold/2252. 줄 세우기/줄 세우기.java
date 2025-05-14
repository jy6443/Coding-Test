import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[] order;
    public static int[][] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        order = new int[n + 1];
        input = new int[m][2];
        for (int i = 1; i <= n; i++) {
            order[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            input[i][0] = from;
            input[i][1] = to;
        }
        while (true) {
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                int from = input[i][0];
                int to = input[i][1];
                if (order[from] > order[to]) {
                    cnt++;
                    int temp = order[from];
                    order[from] = order[to];
                    order[to] = temp;
                }
            }
            if (cnt == 0) {
                break;
            }
        }
        
        int[] answer = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            answer[order[i]] = i;
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}