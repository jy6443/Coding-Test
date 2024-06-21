// a=97 z=122
// A=65 Z=90
class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == ' '){
                answer += ' ';
            } else if(c > 96 && c < 123){
                int j = c + n;
                if(j > 122){
                    j -= 26;
                }
                answer += (char)j;
            } else {
                int j = c + n;
                if(j > 90){
                    j -= 26;
                }
                answer += (char)j;
            }
        }
        return answer;
    }
}