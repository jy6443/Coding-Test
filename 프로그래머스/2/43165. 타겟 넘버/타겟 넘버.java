class Solution {
    public int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(0,numbers,0,target);
        return answer;
    }
    public void dfs(int idx, int[] numbers, int val, int target){
        if(idx == numbers.length){
            if(val == target){
                answer++;
            }
            return;
        }
        dfs(idx+1,numbers,val+numbers[idx],target);
        dfs(idx+1,numbers,val+(-1*numbers[idx]),target);
    }
}