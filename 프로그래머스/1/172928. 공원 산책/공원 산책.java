import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        int[] now = find(park);
        Map<String, int[]> dir = new HashMap<>();
        dir.put("N", new int[] {-1,0});
        dir.put("S", new int[] {1,0});
        dir.put("W", new int[] {0,-1});
        dir.put("E", new int[] {0,1});
        
        for (int i=0; i<routes.length; i++) {
            String[] str = routes[i].split(" ");
            String op = str[0];
            int temp = Integer.parseInt(str[1]);
            int ny = now[0];
            int nx = now[1];
            int[] d = dir.get(op);
            for(int j=0; j<temp; j++) {
                ny += d[0];
                nx += d[1];
                if (0 > ny || ny >= park.length || 0 > nx || nx >= park[0].length() || park[ny].charAt(nx) == 'X') {
                    ny = now[0];
                    nx = now[1];
                    break;
                }
            }
            now = new int [] {ny, nx};
        }
        return now;
    }
    public int[] find(String[] park) {
        for (int i=0; i<park.length; i++) {
            for (int j=0; j<park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {0,0};
    }
}