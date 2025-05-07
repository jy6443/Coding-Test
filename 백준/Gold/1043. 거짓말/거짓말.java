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
        boolean[] peoples = new boolean[n+1];
        Map<Integer, Set<Integer>> relation = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        int[] known = new int[len];
        for (int i = 0; i < len; i++) {
            known[i] = Integer.parseInt(st.nextToken());
            peoples[known[i]] = true;
        }
        for (int i = 1; i <= n; i++) {
            relation.put(i, new HashSet<>());
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int[] temp = new int[cnt];
            for (int j = 0; j < cnt; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }
            list.add(temp);
            if (cnt > 1) {
                for (int j = 0; j < cnt - 1; j++) {
                    for (int k = j + 1; k < cnt; k++) {
                        relation.get(temp[j]).add(temp[k]);
                        relation.get(temp[k]).add(temp[j]);
                    }
                }
            }
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            q.add(known[i]);
        }
        while (!q.isEmpty()) {
            int out = q.remove();
            if (!peoples[out]) {
                continue;
            }
            for (int next : relation.get(out)) {
                if (!peoples[next]) {
                    q.add(next);
                    peoples[next] = true;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < m; i++) {
            boolean isvalid = false;
            for (int p : list.get(i)) {
                if (peoples[p]) {
                    isvalid = true;
                    break;
                }
            }
            if (!isvalid) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}