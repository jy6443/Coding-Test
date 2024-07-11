import java.util.*;
class Solution {
    public Set<Integer> set;
    public boolean[] check;
    public boolean isPrime(int x) {
        for(int i=2; i<Math.sqrt(x)+1; i++) {
            if(x != 2 && x % i == 0) {
               return false;
            }
        }
        return true;
    }
    public void dfs(int dep, String numbers, boolean[] check, int k, StringBuilder sb) {
        if(dep == k){
            set.add(Integer.parseInt(sb.toString()));
            return;
        }
        for(int j=0; j<numbers.length(); j++){
            char c = numbers.charAt(j);
            if(!check[j]) {
                check[j] = true;
                sb.append(c);
                dfs(dep+1,numbers,check,k,sb);
                sb.deleteCharAt(sb.length()-1);
                check[j] = false;
            }
        }
    }
    public int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        check = new boolean[numbers.length()];
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=numbers.length(); i++){
            dfs(0,numbers,check,i,sb);
        }
        for(Integer num : set) {
            if(num > 1 && isPrime(num)){
                answer++;
            }
        }
        return answer;
    }
}