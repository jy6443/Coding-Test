import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] remain = new int[speeds.length];
        for(int i=0; i<speeds.length; i++){
            int temp = 100 - progresses[i];
            if(temp % speeds[i] == 0){
                remain[i] = (temp / speeds[i]);
            } else {
                remain[i] = (temp / speeds[i])+1;
            }
        }
        List<Integer> answer = new ArrayList<>();
        int t = remain[0];
        int cnt = 1;
        for(int i=1; i<remain.length; i++){
            if(remain[i] > t){
                answer.add(cnt);
                t = remain[i];
                cnt = 1;  
            } else {
                cnt++;
            }
        }
        answer.add(cnt);
        // System.out.println(answer);
        int[] ans = new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            ans[i] = answer.get(i);
        }
        return ans;
    }
}