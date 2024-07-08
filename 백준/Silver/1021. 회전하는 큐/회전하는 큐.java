import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 1 ~ 500,000
        int m = Integer.parseInt(st.nextToken());
        String[] line = br.readLine().trim().split(" ");
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = Integer.parseInt(line[i]);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            stack.push(n-i);
        }
        int answer = 0;
        for (int i = 0; i < m; i++) {
            int target = nums[i];
            while (stack.peek() != target){
                int len = stack.size();
                int idx = 0;
                for (Integer num : stack) {
                    if (num != target){
                        idx++;
                    } else{
                        break;
                    }
                }
                if (idx * 2 <= len){
                    while (stack.peek() != target) {
                        int out = stack.remove();
                        stack.add(out);
                        answer++;
                    }
                } else {
                    while (stack.peek() != target) {
                        int out = stack.removeLast();
                        stack.addFirst(out);
                        answer++;
                    }
                }

            }
            int rf = stack.remove();

        }
        System.out.println(answer);
    }
}
