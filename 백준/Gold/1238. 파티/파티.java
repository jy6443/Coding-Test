import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, x, cnt, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        Map<Integer, List<int[]>> edges1 = new HashMap<>();
        Map<Integer, List<int[]>> edges2 = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            edges1.put(i, new ArrayList<>());
            edges2.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges1.get(a).add(new int[]{b, c});
            edges2.get(b).add(new int[]{a, c});
        }

        int[] a = find(edges1);
        int[] b = find(edges2);
        for (int i = 1; i <= n; i++) {
            if (i == x) continue;
            answer = Math.max(answer, a[i] + b[i]);
        }
        System.out.println(answer);
    }
    public static int[] find (Map<Integer, List<int[]>> edges) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int[] visited = new int[n + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[x] = 0;
        pq.add(new int[]{x, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.remove();
            int to = now[0];
            int cost = now[1];

            if (visited[to] < cost) {
                continue;
            }

            for (int[] next : edges.get(to)) {
                if (visited[next[0]] > cost + next[1]) {
                    visited[next[0]] = cost + next[1];
                    pq.add(new int[] {next[0], next[1] + cost});
                }
            }
        }
        return visited;
    }
}