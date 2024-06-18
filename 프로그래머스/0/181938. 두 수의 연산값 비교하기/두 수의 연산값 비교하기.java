class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String num = "";
        num += a;
        num += b;
        answer = Math.max(Integer.parseInt(num),2*a*b);
        return answer;
    }
}