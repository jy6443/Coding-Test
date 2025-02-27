import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int bridge_weight = 0;
        
        Deque<Integer> num = new ArrayDeque<>();
        Deque<Integer> q = new ArrayDeque<>();
        for (int i=0; i<truck_weights.length; i++) {
            num.add(truck_weights[i]);
        }
        
        while (!num.isEmpty()) {
            int next = num.peek();
            if (q.size() == bridge_length) {
                int out = q.remove();
                bridge_weight -= out;
            } 
            if (bridge_weight + next <= weight) {
                q.add(next);
                bridge_weight += next;
                num.remove();
            } else {
                q.add(0);
            }
            
            answer++;
        }
        answer += bridge_length;
        
        return answer;
    }
}