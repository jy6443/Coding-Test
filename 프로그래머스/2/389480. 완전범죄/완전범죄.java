import java.util.*;
class Solution {
    public int answer;
    public boolean flag;
    public int solution(int[][] info, int n, int m) {
        answer = Integer.MAX_VALUE;
        flag = false;
        Set<String> visited = new HashSet<>();
        bt(info, 0, 0, 0, n, m, visited);
        if (!flag) {
            answer = -1;
        }
        return answer;
    }
    public void bt(int[][] info, int idx, int a, int b, int n, int m, Set<String> visited) {
        if(idx == info.length) {
            answer = answer > a ? a : answer;
            flag = true;
            return;
        }
        String key = a + "," + b + "," + idx;
        if (visited.contains(key)) {
            return;
        }
        visited.add(key);
        if (info[idx][0] + a >= n && info[idx][1] >= m) {
            return;
        }
        if (info[idx][0] + a < n) {
            bt(info, idx+1, info[idx][0] + a, b, n, m, visited);
        }
        if (info[idx][1] + b < m) {
            bt(info, idx+1, a, info[idx][1] + b, n, m, visited);
        }
        
    }
}