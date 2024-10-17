import java.util.*;
class Solution {
    public int row;
    public int col;
    public int solution(int[] mats, String[][] park) {
        row = park.length;
        col = park[0].length;
        Arrays.sort(mats);
        for(int l=mats.length-1; l>=0; l--) {
            int m = mats[l];
            for(int i=0; i<=row-m; i++) {
                for(int j=0; j<=col-m; j++) {
                    if(check(park,i,j,m)) {
                        return m;
                    }
                }
            }
        }
        return -1;
    }
    public boolean check(String[][] park, int y, int x, int k) {
        for(int i=y; i<y+k; i++) {
            for(int j=x; j<x+k; j++) {
                if(park[i][j].equals("-1")){
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}