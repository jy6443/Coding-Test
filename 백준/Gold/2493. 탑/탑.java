import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim()); // 1 ~ 500,000
        int[] numbers = Arrays.stream(br.readLine().trim().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n-1; i > -1; i--) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int temp = stack.pop();
                answer[temp] = i+1;
            }
            stack.push(i);
        }
        for (int number : answer) {
            System.out.print(number + " ");
        }

    }
}
