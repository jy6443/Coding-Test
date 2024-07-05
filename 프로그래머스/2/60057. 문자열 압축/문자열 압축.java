import java.util.*;
class Solution {
    public int solution(String s) {
        int n = s.length();
        int answer = n;
        for(int token=1; token<=n/2; token++){
            StringBuilder sb = new StringBuilder();
            String pre = s.substring(0,token);
            int cnt = 1;
            for(int i=token; i<n; i+=token){
                String cur;
                if(i+token <= n){
                    cur = s.substring(i,i+token);
                } else {
                    cur = s.substring(i);
                }
                
                if(pre.equals(cur)){
                    cnt++;
                } else {
                    if(cnt > 1){
                        sb.append(cnt);
                        sb.append(pre);
                    } else {
                        sb.append(pre);
                    }
                    pre = cur;
                    cnt = 1;
                }
            }
            if(cnt > 1){
                sb.append(cnt);
                sb.append(pre);
            } else {
                sb.append(pre);
            }
            answer = Math.min(answer,sb.length());
        }
        
        
        
        return answer;
    }
}