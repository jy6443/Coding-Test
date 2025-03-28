import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int len = order.length;
        int idx = 0;
        Deque<Integer> sub = new ArrayDeque<>();
        Deque<Integer> main = new ArrayDeque<>();
        for (int i=len; i>0; i--) {
            main.push(i);
        }
        while (true) {
            if (!main.isEmpty() && main.peek() == order[idx]) {
                main.pop();
                answer++;
                idx++;
            } else if (!sub.isEmpty() && sub.peek() == order[idx]) {
                sub.pop();
                answer++;
                idx++;
            } else if (!main.isEmpty()) {
                sub.push(main.pop());
            } else {
                break;
            }
        }
        return answer;
    }
}