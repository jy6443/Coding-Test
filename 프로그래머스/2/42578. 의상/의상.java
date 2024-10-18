import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> clo = new HashMap<>();
        for(String[] c : clothes) {
            if(clo.containsKey(c[1])) {
                int now = clo.get(c[1]);
                clo.put(c[1],now+1);
            } else {
                clo.put(c[1],1);
            }
        }

        for(String key : clo.keySet()) {
            answer *= (clo.get(key)+1);
        }

        return answer-1;
    }
}