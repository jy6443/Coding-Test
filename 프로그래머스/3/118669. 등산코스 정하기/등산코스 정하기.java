import java.util.*;
class Solution {
    public int target;
    public int cost;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        target = Integer.MAX_VALUE;
        cost = Integer.MAX_VALUE;
        Arrays.sort(summits);
        Map<Integer,List<int[]>> map = new HashMap<>();
        for(int i=1; i<=n; i++){
            map.put(i,new ArrayList<>());
        }
        for(int[] path : paths){
            int a = path[0], b = path[1], dist = path[2];
            map.get(a).add(new int[] {b,dist});
            map.get(b).add(new int[] {a,dist});
        }
        
        
        for(int gate : gates){
            cal(n,gates,gate, map, summits);
        }
        // System.out.println(target);
        // System.out.println(cost);
        int[] answer = new int[]{target, cost};
        return answer;
    }
    
    public void cal(int n, int[] gates, int start, Map<Integer,List<int[]>> map, int[] summits){
        // System.out.println("start "+start);
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> { 
            if (a[1] != b[1]) { 
                return a[1] - b[1]; 
            } else { 
                return a[0] - b[0]; 
            }
        });
        pq.add(new int[]{start,0});
        
        int[] visit = new int[n+1];
        Arrays.fill(visit,Integer.MAX_VALUE);
        for(int gate : gates){
            visit[gate] = 0;
        }
            
        out:
        while(!pq.isEmpty()){
            int[] out = pq.remove();
            int now = out[0], now_dist = out[1];
            for(int summit : summits){
                if(now == summit){
                    if(cost > now_dist || (cost == now_dist && target > summit)){
                        // System.out.println("안에서 "+summit + " " + now_dist);
                        target = summit;
                        cost = now_dist;
                    }
                    break out;
                }
            }
            for(int[] arr : map.get(now)){
                int next = arr[0], next_dist = arr[1];
                int real_dist = Math.max(next_dist,now_dist);
                if(visit[next] > real_dist){
                    visit[next] = real_dist;
                    // System.out.println("now_dist "+now_dist+"next_dist "+next_dist);
                    pq.add(new int[] {next, real_dist});
                }
            }
        }
        // return visit;
    }
}