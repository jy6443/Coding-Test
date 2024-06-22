import java.util.*;
class Solution {
    public String[] solution(String[] strArr) {
        ArrayList<String> answer = new ArrayList<>();
        for (int i=0; i<strArr.length; i++) {
            if (!strArr[i].contains("ad")) {
                answer.add(strArr[i]);
            }
        }
        String[] result = answer.toArray(new String[answer.size()]);
        return result;
    }
}