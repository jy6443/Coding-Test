import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int t, n, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            Map<Integer, Integer> data = new HashMap<>();
            cnt = 0;
            boolean[] visited = new boolean[n + 1];
            for (int from = 1; from <= n; from++) {
                int to = Integer.parseInt(st.nextToken());
                data.put(from, to);
                if (from == to) {
                    cnt++;
                    visited[to] = true;
                }
            }
            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    List<Integer> path = new ArrayList<>();
                    path.add(j);
                    visited[j] = true;
                    cycle(path, data, visited);
                }
            }
            System.out.println(n - cnt);
        }
    }
    public static void cycle(List<Integer> log, Map<Integer, Integer> data, boolean[] visited) {
        int from = log.get(log.size() - 1);
        int to = data.get(from);
        if (visited[to]) {
            for (int i = 0; i < log.size(); i++) {
                if (log.get(i) == to) {
                    cnt += (log.size() - i);
                    break;
                }
            }
            return;
        } else {
            log.add(to);
            visited[to] = true;
            cycle(log, data, visited);
        }
    }
}