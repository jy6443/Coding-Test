import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList <Integer> num = new ArrayList<>();
        for (int n : arr) {
            if (n % divisor == 0) {
                num.add(n);
            }
        }
        num.sort(Comparator.naturalOrder());
        if (num.size() == 0){
            num.add(-1);
        }
        int[] answer = num.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}