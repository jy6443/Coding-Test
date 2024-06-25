public class Solution {
    public int solution(int n) {
        int answer = 0;
        String num = n + "";
        for (int i=0; i<num.length(); i++) {
            answer += (num.charAt(i) - '0');
        }
        
        return answer;
    }
}