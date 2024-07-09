import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        // 초기값 세팅
        for(int i=0;i<prices.length; i++){ 
            answer[i] = prices.length - (i+1);
        }
        Deque<Integer> s = new ArrayDeque<>();
        for(int i=0; i<prices.length; i++){
            while(!s.isEmpty() && prices[s.peek()] > prices[i]){
                int j = s.pop();
                answer[j] = i - j;
            }
            s.push(i);
        }
        return answer;
    }
}