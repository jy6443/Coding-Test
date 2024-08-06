class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length]; // 0으로 세팅.
        for(int i=0; i<prices.length; i++){
            int t = 0;
            int j = i + 1;
            while(j < prices.length){
                t++;
                if(prices[i] > prices[j]){
                    break;
                } else {
                    j++;
                }
            }
            answer[i] = t;
        }        
        return answer;
    }
}