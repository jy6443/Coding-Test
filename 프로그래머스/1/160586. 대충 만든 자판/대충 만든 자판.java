import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int len_keymap = keymap.length;
        int len_targets = targets.length;
        int[] answer = new int[len_targets];
        Map<Character, Integer> data = new HashMap<>();
        for (int i=0; i<len_keymap; i++) {
            for (int j=0; j<keymap[i].length(); j++) {
                char c = keymap[i].charAt(j);
                if (data.containsKey(c)) {
                    if (data.get(c) > j) {
                        data.put(c,j+1);
                    }
                } else {
                    data.put(c,j+1);
                }
            }
        }
        for (int i=0; i<len_targets; i++) {
            int cnt = 0;
            for (int j=0; j<targets[i].length(); j++) {
                char c = targets[i].charAt(j);
                if (data.containsKey(c)) {
                    cnt += data.get(c);
                } else {
                    cnt = -1;
                    break;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}