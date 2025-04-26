class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int len = diffs.length;
        int left = 1;
        int right = 1;
        for (int diff : diffs) {
            if (diff > right) {
                right = diff;
            }
        }
        int now = (left + right) / 2;
        while (true) {
            long cnt = 0;
            for (int i=0; i<len; i++) {
                if (diffs[i] <= now) {
                    cnt += times[i];
                } else {
                    cnt += ((times[i-1] + times[i]) * (diffs[i] - now));
                    cnt += times[i];
                }
            }
            if (cnt <= limit) {
                right = now;
                now = (left + right) / 2;
            } else {
                left = now;
                now = (left + right) / 2;
            }
            if (left == now) {
                now++;
                break;
            }
        }
        if (left == 1) {
            now = 1;
        }
        return now;
    }

}