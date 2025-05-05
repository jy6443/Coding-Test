import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int node;
    public static int dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Map<Integer, List<int[]>> tree = new HashMap<>();
        for (int i = 0; i < n; i++) {
            tree.put(i+1, new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree.get(a).add(new int[]{b, c});
            tree.get(b).add(new int[]{a, c});
        }
        if (n == 1) {
            System.out.println(0);
            return;
        }
        node = 0;
        dist = 0;
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        depth(1, tree, visited);
        dist = 0;
        visited = new boolean[n+1];
        visited[node] = true;
        depth(node, tree, visited);
        System.out.println(dist);
    }

    public static void depth (int start, Map<Integer, List<int[]>> tree, boolean[] visited) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start, 0});
        while (!q.isEmpty()) {
            int[] cur = q.remove();
            int now = cur[0];
            int cost = cur[1];
            if (dist < cost) {
                dist = cost;
                node = now;
            }
            for (int[] next : tree.get(now)) {
                int nnow = next[0];
                int ncost = cost + next[1];
                if (!visited[nnow]) {
                    visited[nnow] = true;
                    q.add(new int[] {nnow, ncost});
                }
            }
        }
    }
}
