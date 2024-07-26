import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import java.io.IOException;

public class Main {
    public static int dep;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 1 ~ 500,000
        int m = Integer.parseInt(st.nextToken()); // 승객 수
        int fuel = Integer.parseInt(st.nextToken()); // 연료
        int[][] road = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                road[i][j] = Integer.parseInt(tokens[j]);
            }
        }
        int[][] start = new int[m][2];
        int[][] end = new int[m][2];
        st = new StringTokenizer(br.readLine());
        int taxi_y = Integer.parseInt(st.nextToken())-1;
        int taxi_x = Integer.parseInt(st.nextToken())-1;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            start[i][0] = Integer.parseInt(st.nextToken())-1;
            start[i][1] = Integer.parseInt(st.nextToken())-1;
            end[i][0] = Integer.parseInt(st.nextToken())-1;
            end[i][1] = Integer.parseInt(st.nextToken())-1;
        }
        HashSet<Integer> done = new HashSet<>();
        while(done.size() < m){
            int[] out = next(taxi_y, taxi_x, start, road, done);
            if(out[0] == -1){
                fuel = -1;
                break;
            }
            int idex = out[0];
            int consumed = out[1];
            fuel -= consumed;
            if(fuel < 0){
                fuel = -1;
                break;
            }
            int dist = distance(start[idex][0],start[idex][1],end[idex][0],end[idex][1],road);
            if(dist == -1 || fuel < dist){
                fuel = -1;
                break;
            }
            done.add(idex);
            taxi_y = end[idex][0];
            taxi_x = end[idex][1];
            fuel += dist;
        }
        System.out.println(fuel);
    }
    public static int distance(int before_y, int before_x, int after_y, int after_x, int[][] road) {
        int n = road.length;
        int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
        boolean[][] visit = new boolean[n][n];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{before_y, before_x,0});
        visit[before_y][before_x] = true;
        while (!q.isEmpty()) {
            int[] curr = q.remove();
            if (curr[0] == after_y && curr[1] == after_x) {
                return curr[2];
            }
            for (int[] d : dir) {
                int ny = curr[0] + d[0];
                int nx = curr[1] + d[1];
                if (ny >= 0 && ny < n && nx >= 0 && nx < n && road[ny][nx] == 0 && !visit[ny][nx]) {
                    visit[ny][nx] = true;
                    q.add(new int[]{ny, nx, curr[2]+1});
                }
            }
        }
        return -1;
    }
    public static int[] next(int y, int x, int[][] start, int[][] road, HashSet<Integer> done) {
        int n = road.length;
        int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
        boolean[][] visit = new boolean[n][n];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x, 0});
        visit[y][x] = true;
        List<int[]> box = new ArrayList<>();
        int min_dist = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] curr = q.remove();
            if(curr[2] > min_dist) {
                break;
            }
            for(int i = 0; i < start.length; i++){
                if(!done.contains(i) && curr[0] == start[i][0] && curr[1] == start[i][1]){
                    box.add(new int[]{i, curr[2]});
                    min_dist = curr[2];
                }
            }
            for (int[] d : dir) {
                int ny = curr[0] + d[0];
                int nx = curr[1] + d[1];
                if(ny >= 0 && ny < n && nx >= 0 && nx < n && road[ny][nx] == 0 && !visit[ny][nx]) {
                    visit[ny][nx] = true;
                    q.add(new int[]{ny, nx, curr[2]+1});
                }
            }
        }
        if(box.size() == 0){
            return new int[]{-1, -1};
        }
        box.sort((a, b) -> {
            if(a[1] != b[1]){
                return a[1] - b[1];
            }
            if(start[a[0]][0] != start[b[0]][0]){ // start[idx][0] -> row
                return start[a[0]][0] - start[b[0]][0];
            }
            return start[a[0]][1] - start[b[0]][1];
        });
        return box.get(0);
    }

}
