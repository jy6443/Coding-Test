import java.util.*;
class Solution {
    public int solution(int[] wallet, int[] bill) {
        Arrays.sort(wallet); // wallet[0] < wallet[1]
        int answer = 0; 
        int small = (bill[0] <= bill[1]) ? bill[0] : bill[1];
        int big = (bill[0] <= bill[1]) ? bill[1] : bill[0];
        
        while (true) {
            if(big <= wallet[1] && small <= wallet[0]) {
                break;
            } else {
                if(small <= (big / 2)) {
                    big = big / 2;
                } else {
                    int temp = small;
                    small = big / 2;
                    big = temp;
                }
                answer += 1;
            }
        }
        return answer;
        
    }
}

