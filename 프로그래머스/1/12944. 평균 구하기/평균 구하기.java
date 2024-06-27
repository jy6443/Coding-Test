class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        for(int a : arr) {
            answer += (double) a;
        }
        answer = answer / arr.length;
        return answer;
    }
}