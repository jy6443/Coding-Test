import java.util.*;
class Solution {
    public int solution(String numbers) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=1; i<=numbers.length(); i++){
            boolean[] visit = new boolean[numbers.length()];
            StringBuilder temp = new StringBuilder();
            num(set,visit,i,numbers,temp);
        }
        for(Integer p : set){
            if(isPrime(p)){
                answer++;
            }
        }
        return answer;
    }
    public void num(Set<Integer> set, boolean[] visit, int cnt, String numbers,StringBuilder temp){
        if(temp.length() == cnt){
            set.add(Integer.parseInt(temp.toString()));
        }
        for(int i=0; i<numbers.length(); i++){
            if(!visit[i]){
                visit[i] = true;
                temp.append(numbers.charAt(i));
                num(set,visit,cnt,numbers,temp);
                visit[i] = false;
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
    public boolean isPrime(int x){
        if(x == 2){ return true; }
        if(x>1){
            for(int i=2; i<Math.sqrt(x)+1; i++){
                if(x%i==0){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}