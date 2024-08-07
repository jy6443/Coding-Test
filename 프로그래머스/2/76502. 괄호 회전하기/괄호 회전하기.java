import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        String ss = s + s;
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(int i=0; i<s.length(); i++){
            Deque<Character> stack = new ArrayDeque<>();
            for(int j=i; j<i+s.length(); j++){
                char c = ss.charAt(j);
                if(!stack.isEmpty() && map.containsKey(c) && stack.peek() == map.get(c)){
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            if(stack.isEmpty()){
                answer++;
            }
        }
        return answer;
    }
}