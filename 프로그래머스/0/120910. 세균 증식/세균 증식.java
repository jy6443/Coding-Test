class Solution {
    public int solution(int n, int t) {
        int answer = n;
        answer *= Math.pow(2,t);
        return answer;
    }
}