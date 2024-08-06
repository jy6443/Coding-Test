import java.util.*;
class Solution {
    public int solution(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
        Queue<Character> q = new ArrayDeque<>();
        int answer = 0;
        for(int i=0; i<s.length(); i++){
            q.add(s.charAt(i));
        }
        for(int i=0; i<s.length(); i++){
            Deque<Character> stack = new ArrayDeque<>();
            for(int j=0; j<s.length(); j++){
                char c = q.remove();
                if(!stack.isEmpty() && map.get(c) == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
                q.add(c);
            }
            char cc = q.remove();
            q.add(cc);
            if(stack.isEmpty()){
                answer++;
            }
        }
        
        return answer;
    }
}