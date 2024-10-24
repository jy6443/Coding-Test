import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n <= 50
        int[] num = new int[n]; // -100 <= num <= 100
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        if (n == 1) {
            System.out.println('A');
        } else if (n == 2) {
            if (num[0] == num[1]) {
                System.out.println(num[1]);
            } else {
                System.out.println('A');
            }
        } else {
            int a = 0, b = 0;

            if (num[0] != num[1]) {
                a = (num[2] - num[1]) / (num[1] - num[0]);
            }
            b = num[1] - (a * num[0]);
            boolean flag = true;
            for (int i = 1; i < n; i++) {
                if (num[i] != (a * num[i-1]) + b) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println((a * num[n-1]) + b);
            } else {
                System.out.println('B');
            }
        }
    }
}