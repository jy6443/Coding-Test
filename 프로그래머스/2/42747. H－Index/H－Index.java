import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int len = citations.length;
        Arrays.sort(citations); // 0 1 3 5 6
        for(int i=len; i>0; i--) {
            int x = citations.length - i;
            if(citations[x] >= i) {
                return i;
            } else {
                continue;
            }
        }
        return 0;
    }
}