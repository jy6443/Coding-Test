class Solution {
    public static int answer;
    public static int target;
    public int solution(int[] numbers, int tar) {
        answer = 0;
        target = tar;
        // boolean[] visit = new boolean[numbers.length];
        // visit[0] = true;
        int val = 0;
        dfs(0,numbers,val+numbers[0]);
        dfs(0,numbers,val-numbers[0]);

        return answer;
    }
    public void dfs(int idx, int[] numbers, int val) {
        if (idx+1 == numbers.length) {
            if (val == target) {
                answer++;
                return;
            }
            return;
        }
        dfs(idx+1,numbers,val+numbers[idx+1]);
        dfs(idx+1,numbers,val-numbers[idx+1]);
        
    }
}