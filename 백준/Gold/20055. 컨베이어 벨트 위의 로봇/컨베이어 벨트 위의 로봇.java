import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = 2 * n;
        List<Integer> arr = new ArrayList<>();
        List<Boolean> robot = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
            robot.add(false);
        }
        int answer = 0;
        int zero = 0;
        while (zero < k) {
            Collections.rotate(arr, 1);
            Collections.rotate(robot, 1);
            robot.set(n-1, false);

            for (int i = n-2; i >= 0; i--) {
                if (robot.get(i) && !robot.get(i+1) && arr.get(i+1) > 0) {
                    robot.set(i+1, true);
                    robot.set(i, false);

                    int next = arr.get(i+1) - 1;
                    arr.set(i+1, next);
                    if (next == 0) {
                        zero++;
                    }
                }
            }
            robot.set(n-1, false);

            if (!robot.get(0) && arr.get(0) > 0) {
                robot.set(0, true);
                int next = arr.get(0) - 1;
                arr.set(0, next);
                if (next == 0) {
                    zero++;
                }
            }
            answer++;
        }
        System.out.println(answer);
    }
}