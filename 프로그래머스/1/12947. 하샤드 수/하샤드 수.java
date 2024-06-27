class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        String num = x + "";
        int hap = 0;
        for (int i=0; i<num.length(); i++) {
            hap += (num.charAt(i) - '0');
        }
        if(x % hap == 0) {
            answer = true;
        }
        return answer;
    }
}