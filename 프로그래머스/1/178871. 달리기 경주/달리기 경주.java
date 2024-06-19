import java.util.HashMap;
import java.util.Map;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String,Integer> name = new HashMap<>();
        for(int i=1; i<= players.length; i++){
            name.put(players[i-1],i-1);
        }
        for(int j=0; j<callings.length; j++){
            int idx = name.get(callings[j]);
            String temp = players[idx-1];
            players[idx-1] = callings[j];
            players[idx] = temp;
            name.put(callings[j],idx-1);
            name.put(temp,idx);
        }
        return players;
    }
}