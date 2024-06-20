class Solution {
    public int solution(String s) {
        String[] alpa = new String[] {"zero","one","two","three","four","five","six","seven","eight","nine"};
        for(int i=0; i<10; i++){
            s = s.replace(alpa[i],Integer.toString(i));
        }
        int answer = Integer.parseInt(s);
        return answer;
    }
}