class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;
        int start = (h1 * 3600) + (m1 * 60) + s1;
        int end = (h2 * 3600) + (m2 * 60) + s2;
        answer = alram(end) - alram(start);
        if ((start * 59 % 3600) == 0 || (start * 719 % 43200) == 0) {
            answer += 1;
        }
        return answer;
    }
    public int alram(int t) {
        int m = t * 59 / (60 * 60); // 분침 초침은 1시간에 (60-1)번은 무조건 만남.
        int h = t * 719 / (60 * 60 * 12); // 시침과 초침은 12시간에 (720-1)번은 무조건 만남.
        int common = (t >= (60 * 60 * 12)) ? 2 : 1;
        return m + h - common;
    }
}