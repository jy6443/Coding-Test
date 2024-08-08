import java.util.*;
class Solution {
    public int row;
    public int col;
    public int solution(String[][] relation) {
        int answer = 0;
        row = relation.length;
        col = relation[0].length;
        List<List<Integer>> keys = new ArrayList<>();
        for(int cnt=1; cnt<=col; cnt++){ // i=1
            List<Integer> key = new ArrayList<>();
            boolean[] visit = new boolean[col];
            find(key,cnt,keys,0,relation,visit);
        }
        return keys.size();
    }
    public void find(List<Integer> key, int cnt, List<List<Integer>> keys, int idx,String[][] relation,boolean[] visit){
        if(key.size() == cnt && uniq(key,relation)){
            for(List<Integer> min : keys){
                if(key.containsAll(min)){
                    return;
                }
            }
            keys.add(new ArrayList<>(key));
            return;
        }
        for(int i=idx; i<col; i++){
            if(!visit[i]){
                visit[i] = true;
                key.add(i);
                find(key,cnt,keys,i,relation,visit);
                visit[i] = false;
                key.remove(key.size()-1);
            }
        }
    }
    public boolean uniq(List<Integer> key, String[][] relation){
        Set<String> set = new HashSet<>();
        for(String[] rel : relation){
            String check = "";
            for(int id : key){
                check += rel[id];
            }
            set.add(check);
        }
        return relation.length == set.size();
    }
}