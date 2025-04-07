import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int range = 0;
        List<List<int[]>> data = new ArrayList<>();
        for (int i=0; i<routes.length; i++) {
            List<int[]> road = new ArrayList<>();
            for (int j=1; j<routes[i].length; j++) {
                int now = routes[i][j-1];
                int next = routes[i][j];
                if (j==1) {
                    road.add(new int[] {points[now-1][0], points[now-1][1]});
                }
                build(road, points, now, next);
            }
            range = Math.max(range, road.size());
            data.add(road);
        }
        for (int j=0; j<range; j++) {
            Map<String, Integer> lst = new HashMap<>();
            for (int i=0; i<data.size(); i++) {
                if (data.get(i).size()-1 < j) {
                    continue;
                }
                String str = data.get(i).get(j)[0] + "," + data.get(i).get(j)[1];
                if (lst.containsKey(str)) {
                    lst.put(str, lst.get(str) + 1);
                } else {
                    lst.put(str, 1);
                }
            }
            for (String k : lst.keySet()) {
                if (lst.get(k) > 1) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    public void build(List<int[]> road, int[][] points, int s, int e) {
        int[] start = points[s-1];
        int[] end = points[e-1];
        int y = start[0];
        int x = start[1];
        int ny = end[0];
        int nx = end[1];
        while ((y != ny) || (x != nx)) {
            if (y != ny) {
                if (y > ny) {
                    y--;
                    road.add(new int[] {y,x});
                } else {
                    y++;
                    road.add(new int[] {y,x});
                }
            } else {
                if (x > nx) {
                    x--;
                    road.add(new int[] {y,x});
                } else if (x < nx) {
                    x++;
                    road.add(new int[] {y,x});
                } else {
                    break;
                }
            }
        }
    }
}