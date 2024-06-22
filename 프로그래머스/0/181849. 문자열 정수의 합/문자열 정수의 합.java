class Solution {
    public int solution(String num_str) {
        int answer = 0;
        for (int i=0; i<num_str.length(); i++){
            char c = num_str.charAt(i);
            answer += (c - '0');
        }
        return answer;
    }
}