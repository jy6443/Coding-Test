class Solution {
    public int solution(String s) {
        int answer = 1;
        int idx = 0;
        int next = 1;
        int xcnt = 1;
        int notxcnt = 0;
        while (next < s.length()) {
            char c = s.charAt(idx);
            if (xcnt == notxcnt) {
                answer++;
                idx = next;
                next = idx + 1;
                xcnt = 1;
                notxcnt = 0;
                continue;
            }
            if (c == s.charAt(next)) {
                xcnt++;
            } else {
                notxcnt++;
            }
            next++;
        }
        return answer;
    }
}