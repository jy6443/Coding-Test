import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static char[][] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        answer = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = '*';
            }
        }
        star(n,0,0);
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++)
                sb.append(answer[i][j]);
            sb.append('\n');
        }
        System.out.println(sb);
    }
    public static void star(int n, int y, int x) {
        if (n == 1) {
            return;
        }
        int now = n / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    for (int r = 0; r < now; r++) {
                        for (int c = 0; c < now; c++) {
                            answer[y + now + r][x + now + c] = ' ';
                        }
                    }
                } else {
                    star(now, y + i * now, x + j * now);
                }
            }
        }
    }
}