import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static long max_val;
    public static long min_val;
    public static int n;
    public static char[] opt = new char[]{'+', '-', '*', '/'};
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] cal = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cal[i] = Integer.parseInt(st.nextToken()); // + - * /
        }
        max_val = Long.MIN_VALUE;
        min_val = Long.MAX_VALUE;
        char[] opt_list = new char[n-1];
        bt(cal, 0, opt_list);
        System.out.println(max_val);
        System.out.println(min_val);

    }
    public static void bt(int[] cal, int idx, char[] opt_list) {
        if (idx == n - 1) {
            long temp = calculator(opt_list);
            max_val = Math.max(max_val, temp);
            min_val = Math.min(min_val, temp);
            return ;
        }
        for (int i = 0; i < 4; i++) {
            if (cal[i] > 0) {
                cal[i]--;
                opt_list[idx] = opt[i];
                bt(cal, idx + 1, opt_list);
                cal[i]++;
            }
        }
    }
    public static long calculator(char[] opt_list) {
        List<Long> num_arr = new ArrayList<>();
        List<Character> opt_arr = new ArrayList<>();
        for (int i = 0; i < opt_list.length; i++) {
            opt_arr.add(opt_list[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            num_arr.add((long) arr[i]);
        }
        int i = 0;
        while (i < opt_arr.size()) {
            if (opt_arr.get(i) == '*' || opt_arr.get(i) == '/') {
                long a = num_arr.get(i);
                long b = num_arr.get(i+1);
                if (opt_arr.get(i) == '*') {
                    num_arr.remove(i);
                    num_arr.remove(i);
                    num_arr.add(i, (a * b));
                    opt_arr.remove(i);
                } else {
                    num_arr.remove(i);
                    num_arr.remove(i);
                    num_arr.add(i, (a / b));
                    opt_arr.remove(i);
                }
            } else {
                i++;
            }
        }
        long start = num_arr.get(0);
        for (int j = 0; j < opt_arr.size(); j++) {
            if (opt_arr.get(j) == '+') {
                start += num_arr.get(j+1);
            } else {
                start -= num_arr.get(j+1);
            }
        }
        return start;
    }
}
