class Solution {
    boolean solution(String s) {
        boolean answer = false;
        int p = 0;
        int y = 0;
        String ss = s.toLowerCase();
        System.out.println(ss);
        for (int i=0; i<ss.length(); i++) {
            if (ss.charAt(i) == 'p') {
                p ++;
            }
            if (ss.charAt(i) == 'y') {
                y ++;
            }
        }
        if (p == y) {
            answer = true;
        }
        return answer;
    }
}