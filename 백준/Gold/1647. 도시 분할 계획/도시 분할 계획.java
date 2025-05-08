import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static int n;
    public static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            edges.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.get(a).add(new int[]{b, c});
            edges.get(b).add(new int[]{a, c});
        }
        boolean[] visited = new boolean[n+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int[] first : edges.get(1)) {
            pq.add(first);
        }
        visited[1] = true;
        int cnt = 1;
        int totalCost = 0;
        int maxCost = 0;
        while (!pq.isEmpty() && cnt < n) {
            int[] now = pq.remove();
            int to = now[0];
            int cost = now[1];

            if (visited[to]) {
                continue;
            }
            visited[to] = true;
            cnt++;
            totalCost += cost;
            maxCost = Math.max(maxCost, cost);

            for (int[] edge : edges.get(to)) {
                if (!visited[edge[0]]) {
                    pq.add(edge);
                }
            }
        }
        System.out.println(totalCost - maxCost);
    }
}