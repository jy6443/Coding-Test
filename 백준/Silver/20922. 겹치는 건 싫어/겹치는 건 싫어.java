import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 1 ~ 200,000
        int k = Integer.parseInt(st.nextToken()); // 1 ~ 100

        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int first = 0;
        int last = 0;
        int[] cnt = new int[100001];
        int answer = 0;
        while (first < n) {
            if (cnt[numbers[first]] < k) {
                cnt[numbers[first]]++;
                first++;
                answer = Math.max(answer, first - last);
            } else {
                cnt[numbers[last]]--;
                last++;
            }
        }
        System.out.println(answer);
    }
}
