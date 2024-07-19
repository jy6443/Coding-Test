class Solution {
    public static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        int val = 0;
        dfs(0,numbers,val+numbers[0],target);
        dfs(0,numbers,val-numbers[0],target);

        return answer;
    }
    public void dfs(int idx, int[] numbers, int val, int target) {
        if (idx+1 == numbers.length) {
            if (val == target) {
                answer++;
                return;
            }
            return;
        }
        dfs(idx+1,numbers,val+numbers[idx+1],target);
        dfs(idx+1,numbers,val-numbers[idx+1],target);
        
    }
}