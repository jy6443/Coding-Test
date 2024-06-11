class Solution {
    public int[] solution(int n, int k) {
        int t = n / k;
        int[] answer = new int[t];
        for(int i=1; i<=t; i++){
            answer[i-1] = k * i;  
        }
        return answer;
    }
}