class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int l = 0, r = 0;
        int temp = 0;
        int len = sequence.length;
        while(r < sequence.length){
            temp += sequence[r];
            while(temp >= k){
                if((temp == k) && (r-l < len)){
                    answer[0] = l;
                    answer[1] = r;
                    len = r - l;
                }
                temp -= sequence[l];
                l++;    
            }
            r++;
        }
        return answer;
    }
}