import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> run = new HashMap<String, Integer>();
        for (int i=0; i<participant.length; i++) {
            run.put(participant[i],run.getOrDefault(participant[i],0)+1);
        }
        for (int j=0; j<completion.length; j++){
            run.put(completion[j],run.get(completion[j])-1);
        }
        for(String key : run.keySet()){
            if(run.get(key) == 1){
                answer += key;
                break;
            }
        }
        return answer;
    }
}