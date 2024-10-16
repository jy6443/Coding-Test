import java.util.*;
class Solution {
    public String solution(String video_len,String pos,String op_start,String op_end, String[] commands) {
        String answer = "";
        int len = ((video_len.charAt(0)-'0') * 10 + (video_len.charAt(1)-'0')) * 60 + (video_len.charAt(3)-'0') * 10 + (video_len.charAt(4)-'0');
        int time = ((pos.charAt(0)-'0') * 10 + (pos.charAt(1)-'0')) * 60 + (pos.charAt(3)-'0') * 10 + (pos.charAt(4)-'0');
        int start = ((op_start.charAt(0)-'0') * 10 + (op_start.charAt(1)-'0')) * 60 + (op_start.charAt(3)-'0') * 10 + (op_start.charAt(4)-'0');
        int end = ((op_end.charAt(0)-'0') * 10 + (op_end.charAt(1)-'0')) * 60 + (op_end.charAt(3)-'0') * 10 + (op_end.charAt(4)-'0');
    
        
        if(time >= start && time <= end) {
            time = end;
        }
        for(String s : commands) {
            if(s.equals("next")) {
                time = Math.min(len, time + 10);
            } else {
                time = Math.max(0, time - 10);
            }
            if(time >= start && time <= end) {
            time = end;
            }
        }
        
        int hour = time / 60;
        int min = time % 60;
        if(hour < 10) {
            answer += "0";
        }
        answer += (hour + "");
        answer += ":";
        if(min < 10) {
            answer += "0";
        }
        answer += (min + "");
        return answer;
    }
}
