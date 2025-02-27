class Solution {
    public int solution(int n, int w, int num) {
        int answer = 1;
        int now = (num-1) / w;
        while (true) {
            int standard = 2 * w * (now + 1) + 1;
            if (n < standard - num) {
                break;
            }
            num = standard - num;
            answer++;
            now++;
        }
        return answer;
    }
}