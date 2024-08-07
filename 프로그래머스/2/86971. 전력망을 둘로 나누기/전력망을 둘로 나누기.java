import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=1; i<=n; i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0; i<wires.length; i++){
            int a = wires[i][0], b = wires[i][1];
            map.get(a).add(b);
            map.get(b).add(a);
        }
        for(int i=0; i<wires.length; i++){
            int cnt = 0;
            boolean visit[] = new boolean[n+1];
            int a = wires[i][0], b = wires[i][1];
            Queue<Integer> q = new ArrayDeque<>();
            q.add(a);
            visit[a] = true;
            visit[b] = true;
            while(!q.isEmpty()){
                int out = q.remove();
                cnt++;
                for(int temp : map.get(out)){
                    if(!visit[temp]){
                        q.add(temp);
                        visit[temp] = true;
                    }
                }
            }
            answer = Math.min(answer, Math.abs(n - (2*cnt)));
        }
        return answer;
    }
}