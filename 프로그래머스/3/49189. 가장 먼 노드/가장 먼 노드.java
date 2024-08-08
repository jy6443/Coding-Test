import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int[] visit = new int[n+1]; 
        Map<Integer,List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1; i<=n; i++){
            map.put(i,new ArrayList<>());
        }
        for(int[] e : edge){
            int a = e[0], b = e[1];
            map.get(a).add(b);
            map.get(b).add(a);
        }
        q.add(1);
        visit[1] = 1;
        while(!q.isEmpty()){
            int out = q.remove();
            for(int next : map.get(out)){
                if(visit[next] == 0){
                    visit[next] = visit[out] + 1;
                    q.add(next);
                }
            }
        }
        int max_val = 0;
        int answer = 0;
        for(int i=1; i<=n; i++){
            if(visit[i] > max_val){
                max_val = visit[i];
                answer = 1;
            } else if (visit[i] == max_val){
                answer++;
            }
            
        }
        return answer;
    }
}