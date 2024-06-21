import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        Arrays.sort(d);
        for (int i : d){
            sum += i;
            if (sum <= budget){
                answer += 1;
            } else {
                break;
            }
        }
        return answer;
    }
}