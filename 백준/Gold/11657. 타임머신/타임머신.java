import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
//    boolean timemachine = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i+1, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map.get(a).add(new int[] {b, c});
        }
        long[] data = new long[n+1];

        Arrays.fill(data, Long.MAX_VALUE);
        data[1] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                if (data[j] == Long.MAX_VALUE) {
                    continue;
                }
                for (int[] next : map.get(j)) {
                    int dest = next[0];
                    int cost = next[1];
                    if (data[dest] > data[j] + cost) {
                        data[dest] = data[j] + cost;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (data[i] == Long.MAX_VALUE) {
                continue;
            }
            for (int[] now : map.get(i)) {
                int dest = now[0];
                int cost = now[1];
                if (data[dest] > data[i] + cost) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (data[i] == Long.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(data[i]);
            }
        }
    }
}