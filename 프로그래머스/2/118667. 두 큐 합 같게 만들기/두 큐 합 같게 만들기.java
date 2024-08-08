import java.util.*;
class Solution {
    public long solution(int[] queue1, int[] queue2) {
        long answer = 0;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        long sum1 = 0, sum2 = 0;
        for(int i=0; i<queue1.length; i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        while(sum1 != sum2){
            if(answer > 3 * queue1.length){
                answer = -1;
                break;
            }
            if(sum1 > sum2){
                int out = q1.remove();
                sum1 -= out;
                sum2 += out;
                q2.add(out);
                answer++;
            } else{
                int out = q2.remove();
                sum2 -= out;
                sum1 += out;
                q1.add(out);
                answer++;
            }
        }
        return answer;
    }
}