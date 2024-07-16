import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import java.io.IOException;

public class Main {
    public static int dep;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 1 ~ 500,000
        String[] input = br.readLine().split(" ");
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = (Integer.parseInt(input[i]));
        }
        Arrays.sort(list);
        int left = 0;
        int right = n - 1;
        int a = list[left];
        int b = list[right];
        while (left < right) {
            if (list[right] + list[left] > 0) {
                if (Math.abs(b + a) > Math.abs(list[right] + list[left])) {
                    a = list[left];
                    b = list[right];
                }
                right--;
            } else {
                if (Math.abs(b + a) > Math.abs(list[right] + list[left])) {
                    a = list[left];
                    b = list[right];
                }
                left++;
            }
        }
        if (a > b) {
            System.out.println(b + " " + a);
        } else {
            System.out.println(a + " " + b);
        }

    }

}