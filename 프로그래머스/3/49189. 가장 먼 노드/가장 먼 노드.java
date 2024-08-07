import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] visit = new int[n+1];
        Map<Integer,List<Integer>> nodes = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1; i<=n; i++){
            nodes.put(i,new ArrayList<>());
        }
        for(int i=0; i<edge.length; i++){
            int a = edge[i][0], b = edge[i][1];
            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }
        q.add(1);
        visit[1] = 1;
        while(!q.isEmpty()){
            int out = q.remove();
            for(int next : nodes.get(out)){
                if(visit[next] == 0){
                    visit[next] = visit[out] + 1;
                    q.add(next);
                }
            }
        }
        int max_dep = 0;
        for(int dep : visit){
            if(dep > max_dep){
                max_dep = dep;
                answer = 1;
            } else if(dep == max_dep){
                answer++;
            }
        }
        return answer;
    }
}