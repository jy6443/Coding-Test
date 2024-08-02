import java.util.*;
class Solution {
    public int answer;
    public int solution(int n, int[][] wires) {
        answer = n;
        int len = wires.length;
        boolean[] visit = new boolean[n+1];
        Map<Integer,List<Integer>> node = new HashMap<>();
        for(int i=0; i<n; i++){
            node.put(i+1,new ArrayList<>());
        }
        for(int[] cur : wires){
            node.get(cur[0]).add(cur[1]);
            node.get(cur[1]).add(cur[0]);
        }
        dfs(1,node,visit,n);
        
        return answer;
    }
    public int dfs(int now, Map<Integer,List<Integer>> node, boolean[] visit, int n){
        int count = 1;
        visit[now] = true;
        for(int d : node.get(now)){
            if(!visit[d]){
                count += dfs(d, node, visit, n);
            }
        }
        answer = Math.min(answer, Math.abs(n - 2 * count));
        return count;
    }
}