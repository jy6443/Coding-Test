import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int t = 0;
        int cnt = 0;
        int total = jobs.length;
        Arrays.sort(jobs, (i,j) -> i[0]-j[0]);
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        
        int idx = 0;
        while(cnt < total){
            while(idx < total && jobs[idx][0] <= t){
                pq.add(jobs[idx]);
                idx++;
            }
            if(!pq.isEmpty()){
                int[] out = pq.remove();
                t += out[1];
                answer += (t - out[0]);
                cnt++;
            } else {
                t = jobs[idx][0];
            }
        }
        
        return answer / total;
    }
}