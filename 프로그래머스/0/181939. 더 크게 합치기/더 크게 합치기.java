class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String ab = a + "" + b;
        String ba = b + "" + a;
        answer = Math.max(Integer.parseInt(ab),Integer.parseInt(ba));
        return answer;
    }
}