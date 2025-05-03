import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int temp = arr[0];
        while (left < n && right < n) {
            if (temp >= s) {
                answer = answer > right - left ? right - left : answer;
                temp -= arr[left];
                left++;
            } else {
                right++;
                if (right == n) {
                    break;
                }
                temp += arr[right];
            }
        }
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        System.out.println(answer+1);
    }
}