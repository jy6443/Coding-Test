import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int len = id_list.length;
        int[] answer = new int[len];
        Map<String, Integer> idx = new HashMap<>();
        Map<Integer, List<Integer>> data = new HashMap<>();
        Set<String> repo = new HashSet<>();
        for (int i=0; i<len; i++) {
            idx.put(id_list[i], i);
            data.put(i, new ArrayList<>());
        }
        for (int i=0; i<report.length; i++) {
            repo.add(report[i]);
        }
        for (String s : repo){
            String[] str = s.split(" ");
            int a = idx.get(str[1]);
            int b = idx.get(str[0]);
            data.get(a).add(b);
        }
        for (int i=0; i<len; i++) {
            if (data.get(i).size() >= k) {
                for (int j=0; j<data.get(i).size(); j++) {
                    answer[data.get(i).get(j)]++;
                }
            }
        }
        return answer;
    }
}