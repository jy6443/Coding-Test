import java.util.Arrays;
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] word = {"aya","ye","woo","ma"};
        for(int i=0; i<babbling.length; i++){
            String target = babbling[i];
            for(int j=0; j<4; j++){
                target = target.replace(word[j],"-");
            }
            target = target.replace("-","");
            if(target.equals("")){
                answer += 1;
            }
        }
        return answer;
    }
}