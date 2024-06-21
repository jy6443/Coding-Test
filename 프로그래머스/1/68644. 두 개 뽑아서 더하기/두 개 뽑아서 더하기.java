import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> result = new HashSet<>();
        for (int i=0; i<numbers.length-1; i++){
            for (int j=i+1; j<numbers.length; j++){
                int val = numbers[i] + numbers[j];
                result.add(val);
            }
        }
        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        return answer;
    }
}