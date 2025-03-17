import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        List<Integer> lst = new ArrayList<>();
        String[] str = s.split(" ");
        for (String ss : str) {
            lst.add(Integer.parseInt(ss));
        }
        Collections.sort(lst);
        // System.out.println(lst.get(0));
        // System.out.println(lst.get(lst.size()-1));
        answer += lst.get(0);
        answer += " ";
        answer += lst.get(lst.size()-1);
        return answer;
    }
}