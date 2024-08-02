import java.util.*;
class Solution {
    public int solution(int n, int[][] edges) {
        int answer = 0;
        int max_val = 0;
        int len = edges.length;
        int[] visit = new int[n+1];
        int[][] edge = new int[len * 2][2];
        for(int i=0; i<edges.length; i++){
            edge[i][0] = edges[i][0];
            edge[i][1] = edges[i][1];
            edge[len+i][0] = edge[i][1];
            edge[len+i][1] = edge[i][0];
        }
        
        Arrays.sort(edge, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        Queue<Integer> q = new ArrayDeque<>();
        visit[1] = 1;
        for(int[] node : edge) {
            if(node[0] == 1){
                q.add(node[1]);
                visit[node[1]] = visit[node[0]] + 1;
            } else{
                break;
            }
        }
        while(!q.isEmpty()){
            int out = q.remove();
            for(int[] node : edge){
                if(node[0] == out && visit[node[1]] == 0){
                    q.add(node[1]);
                    visit[node[1]] = visit[out] + 1;
                } else if(node[0] > out){
                    break;
                }   
            }
            
        }
        for(int i : visit){
            if(i > max_val){
                answer = 1;
                max_val = i;
            } else if(i == max_val){
                answer++;
            } else{
                continue;
            }
        }
        
        return answer;
    }
}