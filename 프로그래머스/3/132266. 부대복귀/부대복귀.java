import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=1; i<=n; i++) {
            map.put(i,new ArrayList<>());
        }
        for(int[] road : roads) {
            map.get(road[0]).add(road[1]);
            map.get(road[1]).add(road[0]);
        }
        int[] value = dijkstra(n,destination,map);
        for(int i=0; i<sources.length; i++){
            int num = sources[i];
            if(value[num] == Integer.MAX_VALUE){
                answer[i] = -1;
            } else {
                answer[i] = value[num];
            }
        }
       
        return answer;
    }
    public int[] dijkstra(int n, int dest, Map<Integer,List<Integer>> map){
        Queue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int[] visit = new int[n+1];
        Arrays.fill(visit,Integer.MAX_VALUE);
        pq.add(new int[] {dest, 0});
        visit[dest] = 0;
        while(!pq.isEmpty()) {
            int[] out = pq.remove();
            int now = out[0], cost = out[1];
            if(visit[now] < cost){
                continue;
            }
            for(int next : map.get(now)){
                if(visit[next] <= cost + 1){
                    continue;
                }
                visit[next] = cost + 1;
                pq.add(new int[] {next, cost+1});
            }
        }
        return visit;
    }
}