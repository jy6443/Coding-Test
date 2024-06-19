import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public int[] solution(int n, int[] numlist) {
        List<Integer> result = new ArrayList<>();
        for(int i : numlist){
            if(i%n == 0){
                result.add(i);
            }        
        }
        int[] answer = result.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}