import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        Map<Integer,List<int[]>> map = new HashMap<>();
        for(int i=1; i<=n; i++){
            map.put(i,new ArrayList<>());
        }
        for(int[] fare : fares){
            int aNode = fare[0], bNode = fare[1], cost = fare[2];
            map.get(aNode).add(new int[] {bNode, cost});
            map.get(bNode).add(new int[] {aNode, cost});
        }
        answer = taxi(n,s,a,map) + taxi(n,s,b,map);
        for(int i=1; i<=n; i++){
            if(i==s){
                continue;
            }
            int costI = taxi(n, s, i, map); 
            int costA = taxi(n, i, a, map); 
            int costB = taxi(n, i, b, map); 

            answer = Math.min(answer, costI + costA + costB);
        }

        return answer;
    }
    
    public int taxi(int n, int start, int end, Map<Integer,List<int[]>> map){
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        int[] visit = new int[n+1];
        Arrays.fill(visit,Integer.MAX_VALUE);
        pq.add(new int[]{start,0});
        visit[start] = 0;
        while(!pq.isEmpty()){
            int[] out = pq.remove();
            int now = out[0], now_cost = out[1];
            // System.out.println(now + " " + now_cost);
            if(now == end) {
                return now_cost;
            }
            for(int[] now_fare : map.get(now)){
                int next = now_fare[0], next_cost = now_fare[1] + now_cost;
                if(next_cost < visit[next]){
                    visit[next] = next_cost;
                    pq.add(new int[] {next, next_cost});
                }
            }
            
        }
        return Integer.MAX_VALUE;
    }
}