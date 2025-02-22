class Solution {
    boolean solution(String s) {
        boolean answer = false;
        int score = 0;
        int idx = 0;
        while (score >= 0 && idx < s.length()) {
            if (s.charAt(idx) == '(') {
                score++;
            } else {
                score--;
            }
            idx++;
        }
        if (score == 0 && idx == s.length()) {
            answer = true;
        }
        return answer;
    }
}