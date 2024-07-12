import java.util.*;
class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        int col = relation[0].length;
        int row = relation.length;
        List<List<Integer>> keys = new ArrayList<>(); //열의 조합들을 다 모은 이차원배열
        for(int cnt=1; cnt<=col; cnt++) { //몇개의 속성(열)의 조합
            List<Integer> now = new ArrayList<>(); //이번턴의 열 조합
            dfs(cnt,0,col,now,keys,relation);
        }
        answer = keys.size();
        System.out.println(keys);
        return answer;
    }
    
    public void dfs(int cnt, int start, int end, List<Integer> now, List<List<Integer>> keys, String[][] relation) {
        if(now.size() == cnt && isKey(now, relation)) {
            for (List<Integer> one : keys) {
                if(now.containsAll(one)){
                    return;
                }
            }
            keys.add(new ArrayList<>(now));
            return;
        }
        for (int i=start; i<end; i++) {
            now.add(i);
            dfs(cnt,i+1,end,now,keys,relation);
            now.remove(now.size()-1);
        }
    }
    public boolean isKey(List<Integer> now, String[][] relation) {
        Set<String> set = new HashSet<>();
        for (String[] row : relation) {
            StringBuilder sb = new StringBuilder();
            for (int idx : now) {
                sb.append(row[idx]);
            }
            set.add(sb.toString());
        }
        if(relation.length == set.size()) {
            return true;
        } else {
            return false;
        }
    }
}