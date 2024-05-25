class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        for(int t: array){
            if(t>height){
                answer += 1;
            }
        }
        return answer;
    }
}