import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Integer> q = new ArrayDeque<>();
        int[] visit = new int[words.length];
        for(int i=0; i<words.length; i++){
            if(trans(begin,words[i])){
                q.add(i);
                visit[i] = 1;
            }
        }
        
        while(!q.isEmpty()){
            int out = q.remove();
            if(words[out].equals(target)){
                answer = visit[out];
            }
            for(int i=0; i<words.length; i++){
                if(trans(words[out],words[i]) && visit[i]==0){
                    visit[i] = visit[out] + 1;
                    q.add(i);
                }
            }
        }
        return answer;
    }
    public boolean trans(String a, String b){
        int len = a.length();
        int cnt = 0;
        for(int i=0; i<len; i++){
            if(a.charAt(i) != b.charAt(i)){
                cnt++;
            }
        }
        return cnt == 1;
    }
}