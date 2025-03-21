import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[w];
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int dep = 1; dep <= h; dep++ ) {
            int cnt = 0;
            int flag = 0;
            for (int i = 0; i < w; i++) {
                if (arr[i] < dep) {
                    if (flag > 0) {
                        cnt += 1;
                    }
                } else {
                    flag += 1;
                    answer += cnt;
                    cnt = 0;
                }
            }
        }
        System.out.println(answer);
    }
}