import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] now, goal;
    public static void main(String[] args) throws IOException {
        int answer = -1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        now = new int[n];
        goal = new int[n];
        String line = br.readLine();
        for (int i = 0; i < n; i++) {
            now[i] = line.charAt(i) - '0';
        }
        line = br.readLine();
        for (int i = 0; i < n; i++) {
            goal[i] = line.charAt(i) - '0';
        }
        int[] a = now.clone();
        int[] b = now.clone();
        a[0] = 1 - a[0];
        a[1] = 1 - a[1];
        int a_cnt = 1, b_cnt = 0;
        for (int i = 1; i < n - 1; i++) {
            if (a[i - 1] != goal[i - 1]) {
                a[i - 1] = 1 - a[i - 1];
                a[i] = 1 - a[i];
                a[i + 1] = 1 - a[i + 1];
                a_cnt += 1;
            }
            if (b[i - 1] != goal[i - 1]) {
                b[i - 1] = 1 - b[i - 1];
                b[i] = 1 - b[i];
                b[i + 1] = 1 - b[i + 1];
                b_cnt += 1;
            }
        }
        if (a[n - 2] != goal[n - 2]) {
            a[n - 2] = 1 - a[n - 2];
            a[n - 1] = 1 - a[n - 1];
            a_cnt += 1;
        }
        if (b[n - 2] != goal[n - 2]) {
            b[n - 2] = 1 - b[n - 2];
            b[n - 1] = 1 - b[n - 1];
            b_cnt += 1;
        }
        if (a[n -1] == goal[n - 1] && b[n - 1] == goal[n - 1]) {
            answer = Math.min(a_cnt, b_cnt);
        } else if (a[n -1] == goal[n - 1]) {
            answer = a_cnt;
        } else if (b[n - 1] == goal[n - 1]) {
            answer = b_cnt;
        } 
        
        System.out.println(answer);
    }
}