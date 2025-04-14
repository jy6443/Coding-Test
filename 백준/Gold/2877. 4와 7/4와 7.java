import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder ans = answer(k);
        System.out.println(ans);
    }
    public static StringBuilder answer (int step) {
        if (step == 1) {
            return new StringBuilder("4");
        } else if (step == 2) {
            return new StringBuilder("7");
        } else {
            int pre = (step - 1) / 2;
            int even = step % 2;
            if (even == 0) {
                return answer(pre).append("7");
            } else {
                return answer(pre).append("4");
            }
        }
    }
}

