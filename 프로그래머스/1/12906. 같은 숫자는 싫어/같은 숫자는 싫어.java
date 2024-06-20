import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> result = new ArrayList<>();
        int prev = -1;
        for(int n : arr){
            if(n != prev){
                result.add(n);
                prev = n;
            }
        }
        int[] answer = new int[result.size()];
        for(int j=0; j<answer.length; j++){
            answer[j] = result.get(j);
        }
        return answer;
    }
    
}