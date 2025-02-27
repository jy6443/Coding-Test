import java.util.*;
class Solution {
    public int answer;
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        bt(new ArrayList<>(), n, 1, q, ans);
        return answer;
    }
    public void bt(List<Integer> code, int n, int start, int[][] q, int[] ans) {
        if (code.size() == 5) {
            if (validation(code, q, ans)) {
                answer++;
            }
            return;
        }
        for (int i=start; i<=n; i++) {
            code.add(i);
            bt(code, n, i+1, q, ans);
            code.remove(code.size()-1);
        }
    }
    public boolean validation(List<Integer> code, int[][] q, int[] ans) {
        for (int i=0; i<q.length; i++) {
            int cnt = 0;
            for (int item : q[i]) {
                if (code.contains(item)) {
                    cnt++;
                }
            }
            if (cnt != ans[i]) {
                return false;
            }
        }
        return true;
    }
}