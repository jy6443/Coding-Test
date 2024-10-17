import java.util.*;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int m = health; // 최대체력
        int len = attacks.length;
        int con = 0; // 연속
        int time = 1;
        int rap = 0;
        int last = attacks[len-1][0];
        while(rap < len) {
            if(con == bandage[0]) {
                health = Math.min(m, health+bandage[2]);
                con = 0;
            }
            if(time < attacks[rap][0]) {
                health = Math.min(m, health+bandage[1]);
                time += 1;
                con += 1;
            } else {
                health -= attacks[rap][1];
                con = 0;
                time += 1;
                rap += 1;
                if(health < 0) {
                    break;
                }
            }
            
        }
        return health > 0 ? health : -1;
    }
}