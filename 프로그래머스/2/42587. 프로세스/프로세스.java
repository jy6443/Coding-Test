import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        Deque<int[]> q = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i=0; i<priorities.length; i++) {
            q.add(new int[] {i, priorities[i]});
            pq.add(priorities[i]);
        }
        while(!pq.isEmpty()) {
            int out = pq.remove();
            while(q.peek()[1] != out) {
                q.add(q.remove());
            }
            int[] value = q.remove();
            if (value[0] == location) {
                break;
            } else {
                answer++;
            }
        }
        return answer;
    }
}