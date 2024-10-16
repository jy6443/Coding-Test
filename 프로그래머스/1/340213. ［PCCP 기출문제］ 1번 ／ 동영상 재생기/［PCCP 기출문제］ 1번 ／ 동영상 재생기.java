import java.util.*;
class Solution {
    public String solution(String video_len,String pos,String op_start,String op_end, String[] commands) {
        String answer = "";
        Map<String, Integer> timer = new HashMap<>();
        timer.put("video_len", (((video_len.charAt(0)-'0') * 10 + (video_len.charAt(1)-'0')) * 60 + (video_len.charAt(3)-'0') * 10 + (video_len.charAt(4)-'0')));
        timer.put("pos", (((pos.charAt(0)-'0') * 10 + (pos.charAt(1)-'0')) * 60 + (pos.charAt(3)-'0') * 10 + (pos.charAt(4)-'0')));
        timer.put("op_start", (((op_start.charAt(0)-'0') * 10 + (op_start.charAt(1)-'0')) * 60 + (op_start.charAt(3)-'0') * 10 + (op_start.charAt(4)-'0')));
        timer.put("op_end", (((op_end.charAt(0)-'0') * 10 + (op_end.charAt(1)-'0')) * 60 + (op_end.charAt(3)-'0') * 10 + (op_end.charAt(4)-'0')));

        if(timer.get("pos") >= timer.get("op_start") && timer.get("pos") <= timer.get("op_end")) {
            timer.put("pos", timer.get("op_end")); 
        }
        for(String s : commands) {
            int now = timer.get("pos");
            if(s.equals("next")) {
                timer.put("pos", Math.min(timer.get("video_len"), now + 10));
            } else {
                timer.put("pos", Math.max(0,now - 10));
            }
            if(timer.get("pos") >= timer.get("op_start") && timer.get("pos") < timer.get("op_end")) {
                timer.put("pos", timer.get("op_end")); 
            }
        }
        int result = timer.get("pos");
        int hour = result / 60;
        int min = result % 60;
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