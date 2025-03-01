import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int len = friends.length;
        int[][] data = new int[len][len];
        int[] answer = new int[len];
        Map<String, Integer> member = new HashMap<>();
        for (int i=0; i<len; i++) {
            member.put(friends[i], i);
        }
        for (int i=0; i<gifts.length; i++) {
            String[] str = gifts[i].split(" ");
            data[member.get(str[0])][member.get(str[1])]++;
        }
        int[] index = new int[len];
        for (int i=0; i<len; i++) {
            int plus = 0;
            int minus = 0;
            for (int j=0; j<len; j++) {
                if (i == j) {
                    continue;
                }
                plus += data[i][j];
                minus += data[j][i];
            }
            index[i] = (plus - minus);
        }
        for (int i=0; i<len; i++) {
            for (int j=0; j<len; j++) {
                if (i == j) {
                    continue;
                }
                if (data[i][j] == 0 && data[j][i] == 0 && (index[i] > index[j])) {
                    answer[i] += 1;
                    continue;
                }
                if ((data[i][j] == data[j][i]) && (index[i] > index[j])) {
                    answer[i] += 1;
                    continue;
                }
                if (data[i][j] > data[j][i]) {
                    answer[i] += 1;
                }
            }
        }
        Arrays.sort(answer);
        return answer[len-1];
    }
}