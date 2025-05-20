import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static boolean yes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            Room[] rooms = new Room[n+1];
            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char type = st.nextToken().charAt(0);
                int cost = Integer.parseInt(st.nextToken());
                List<Integer> to = new ArrayList<>();
                while (st.hasMoreTokens()) {
                    int next = Integer.parseInt(st.nextToken());
                    if (next == 0) break;
                    to.add(next);
                }
                rooms[i] = new Room(type, cost, to);
            }
            yes = false;
            boolean[][] visited = new boolean[n+1][501];
            dfs(n, 1, rooms, 0,  visited);
            System.out.println(yes ? "Yes" : "No");
        }
    }
    public static void dfs (int n, int cur, Room[] rooms, int money, boolean[][] visited) {
        if (yes) return;

        if (rooms[cur].type == 'L') {
            if (money < rooms[cur].cost) {
                money = rooms[cur].cost;
            }
        } else if (rooms[cur].type == 'T') {
            if (money < rooms[cur].cost) {
                return;
            }
            money -= rooms[cur].cost;
        }
        if (visited[cur][money]) return;
        visited[cur][money] = true;

        for (int next : rooms[cur].to) {
            dfs(n, next, rooms, money, visited);
        }

        if (cur == n) {
            yes = true;
            return;
        }
    }
    static class Room {
        char type;
        int cost;
        List<Integer> to;

        public Room(char type, int cost, List<Integer> to) {
            this.type = type;
            this.cost = cost;
            this.to = to;
        }
    }
}