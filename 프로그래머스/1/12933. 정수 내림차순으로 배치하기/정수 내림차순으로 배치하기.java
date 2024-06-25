import java.util.Arrays;
class Solution {
    public long solution(long n) {
        long result = 0;
        long term = 1;
        String num = n + "";
        int[] answer = new int[num.length()];
        for (int i=0; i<num.length(); i++) {
            answer[i] = num.charAt(i) - '0';
        }
        Arrays.sort(answer);
        for (int i : answer) {
            result += (i*term);
            term *= 10;
        }
        return result;
    }
}