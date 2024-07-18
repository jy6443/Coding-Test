import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Integer> q = new ArrayDeque<>();
        int[] visit = new int[words.length];
        for (int i=0; i<words.length; i++) {
            int cnt = 0;
            for (int j=0; j<words[i].length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    cnt++;
                }
            }
            if (cnt == begin.length()-1) {
                q.add(i);
                visit[i] = 1;
            }
        }
        while(q.size() > 0) {
            int idx  = q.remove();
            if (words[idx].equals(target)) {
                answer = visit[idx];
                break;
            }
            for (int i=0; i<words.length; i++) {
                int cnt = 0;
                if (visit[i] == 0) {
                    for (int j=0; j<words[i].length(); j++) {
                        if (words[idx].charAt(j) == words[i].charAt(j)) {
                            cnt++;
                        }
                    }
                    if (cnt == begin.length()-1) {
                        if (answer == 0) { answer++; }
                        q.add(i);
                        visit[i] = visit[idx] + 1;
                    }
                }
            }
            
        }
        
        return answer;
    }
}